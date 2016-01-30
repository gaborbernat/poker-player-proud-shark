package org.leanpoker.player.rankers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.leanpoker.player.domain.Card;

public class TwoPairRanker implements RankerType {

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

		int maxIndex = 15;
		int maxRank = 0;
		boolean twoPair = false;
		for (int i = 14; i > 1; i--) {
			Integer actual = groups.get(i);
			actual = (actual == null) ? 0 : actual;
			if (actual > 1 && maxIndex == 15) {
				maxIndex = i;
				maxRank = i * actual;
			} else if (actual > 1) {
				maxRank += i * actual;
				twoPair = true;
			}
		}
		return twoPair ? maxRank + 200 : 0;
	}

}
