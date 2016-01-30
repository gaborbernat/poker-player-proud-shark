package org.leanpoker.player.rankers;

import org.leanpoker.player.domain.Card;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StraightRanker implements RankerType {
    @Override
    public int getRank(List<Card> cards) {
        if (cards.size() < 5) return 0;

        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getNumber() - o2.getNumber();
            }
        });

        for (int i = 1; i < cards.size(); ) {
            if (cards.get(i).getNumber() == cards.get(i - 1).getNumber()) {
                cards.remove(i);
            } else {
                ++i;
            }
        }

        if (cards.size() < 5) return 0;

        int highestSize = 1, highestStart = -1, sequenceSize = 1;
        for (int i = 1; i < cards.size(); ++i) {
            int value = cards.get(i).getNumber();
            int lastValue = cards.get(i-1).getNumber();
            if (value == lastValue + 1) {
                sequenceSize += 1;
                if (sequenceSize > highestSize) {
                    highestStart = i - sequenceSize + 1;
                    highestSize = sequenceSize;
                }
            } else {
                sequenceSize = 1;
            }
        }

        int sum = 0;
        for (int i = highestStart; i < highestSize + highestStart; ++i) {
            sum += cards.get(i).getNumber();
        }

        if (highestSize >= 5) {
            return 400 + sum;
        } else {
            return 0;
        }
    }
}
