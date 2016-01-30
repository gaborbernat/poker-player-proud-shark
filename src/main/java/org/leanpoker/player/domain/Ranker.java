package org.leanpoker.player.domain;

import org.leanpoker.player.rankers.NumberRanker;
import org.leanpoker.player.rankers.RankerType;
import java.util.ArrayList;
import java.util.List;

public class Ranker {
    List<RankerType> rankers;

    public Ranker() {
        rankers = new ArrayList<>();
        rankers.add(new NumberRanker());
    }

    public int getRank(List<Card> cards) {
        int maxRank = 0;
        for (RankerType ranker : rankers) {
            int rank = ranker.getRank(cards);
            if (rank > maxRank) {
                maxRank = rank;
            }
        }
        return maxRank;
    }
}
