package org.leanpoker.player.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ranker {
    public static int getRank(List<Card> cards) {
        Map<Integer, List<Card>> groups = new HashMap<>();

        for (int i = 2; i <= 14; ++i) {
            groups.put(i, new ArrayList<Card>());
        }

        for (Card card : cards) {
            groups.get(card.getNumber()).add(card);
        }

        int max = 0, index = 0;
        for (int i = 14; i >= 2; --i) {
            if (groups.get(i).size() > max) {
                max = groups.get(i).size();
                index = i;
            }
        }

        int rank = 0;
        switch (max) {
            case 2:
                rank = 100;
                break;
            case 3:
                rank = 300;
                break;
            case 4:
                rank = 600;
                break;
        }

        List bestgroup = groups.get(index);

        for (Card card : groups.get(index)){
            rank += card.getNumber();
        }

        return rank;
    }
}
