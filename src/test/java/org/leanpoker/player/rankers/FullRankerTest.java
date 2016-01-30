package org.leanpoker.player.rankers;

import org.junit.Assert;
import org.junit.Test;

import org.leanpoker.player.domain.Card;
import org.leanpoker.player.domain.Suit;

import java.util.ArrayList;
import java.util.List;

public class FullRankerTest {

	@Test
	public void testFullRanker() {
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card("A", Suit.clubs.name()));
		cards.add(new Card("A", Suit.diamonds.name()));
		cards.add(new Card("10", Suit.clubs.name()));
		cards.add(new Card("10", Suit.diamonds.name()));
		cards.add(new Card("10", Suit.hearts.name()));
		// when
		FullRanker underTest = new FullRanker();
		int actual = underTest.getRank(cards);
		// then
		Assert.assertEquals(558, actual);
	}
}
