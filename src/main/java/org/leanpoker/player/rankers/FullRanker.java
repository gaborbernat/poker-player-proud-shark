package org.leanpoker.player.rankers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.leanpoker.player.domain.Card;

public class FullRanker implements RankerType {

	@Override
	public int getRank(List<Card> cards) {
		Map<Integer, Integer> groups = new HashMap<>();
		for (Card card : cards) {
			int number = card.getNumber();
			Integer actual = groups.get(number);
			if (actual == null) {
				actual = 0;
			}
			actual++;
			groups.put(number, actual);
		}

		int twoIndex = 15;
		int threeIndex = 15;
		int maxRank = 0;
		for (int i = 14; i > 1; i--) {
			Integer actual = groups.get(i);
			actual = (actual == null) ? 0 : actual;
			if (actual > 2 && threeIndex == 15) {
				threeIndex = i;
				maxRank += i * actual;
			} else if (actual > 1 && twoIndex == 15) {
				maxRank += i * actual;
				twoIndex = i;
			}
		}
		return twoIndex < 15 && threeIndex < 15 ? maxRank + 500 : 0;
	}

}
