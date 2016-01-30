package org.leanpoker.player.domain;

import org.leanpoker.player.rankers.*;

import java.util.ArrayList;
import java.util.List;

public class Ranker {
    List<RankerType> rankers;

    public Ranker() {
        rankers = new ArrayList<>();
        rankers.add(new NumberRanker());
        rankers.add(new TwoPairRanker());
        rankers.add(new FullRanker());
        rankers.add(new StraightRanker());
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
