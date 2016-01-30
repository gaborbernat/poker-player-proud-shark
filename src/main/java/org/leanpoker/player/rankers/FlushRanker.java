package org.leanpoker.player.rankers;

import org.leanpoker.player.domain.Card;
import org.leanpoker.player.domain.Suit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlushRanker implements RankerType {
    @Override
    public int getRank(List<Card> cards) {
        Map<String, List<Card>> groups = new HashMap<>();

        groups.put(Suit.clubs.toString(), new ArrayList<Card>());
        groups.put(Suit.diamonds.toString(), new ArrayList<Card>());
        groups.put(Suit.hearts.toString(), new ArrayList<Card>());
        groups.put(Suit.spades.toString(), new ArrayList<Card>());


        for (Card card : cards) {
            groups.get(card.getSuit().toString()).add(card);
        }

        int max = 0;
        for (Map.Entry<String, List<Card>> entry : groups.entrySet()) {
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
            }
        }

        if (max >= 5) {
            return 500;
        } else {
            return  0;
        }
    }
}
