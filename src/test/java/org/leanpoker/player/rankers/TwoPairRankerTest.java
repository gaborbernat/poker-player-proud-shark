package org.leanpoker.player.rankers;

import org.junit.Assert;
import org.junit.Test;

import org.leanpoker.player.domain.Card;
import org.leanpoker.player.domain.Suit;

import java.util.ArrayList;
import java.util.List;

public class TwoPairRankerTest {

	@Test
	public void testTwoPair() {
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card("A", Suit.hearts.name()));
		cards.add(new Card("A", Suit.clubs.name()));
		cards.add(new Card("2", Suit.hearts.name()));
		cards.add(new Card("2", Suit.clubs.name()));

		TwoPairRanker underTest = new TwoPairRanker();
		int actual = underTest.getRank(cards);
		Assert.assertEquals(232, actual);
	}

	@Test
	public void testNotTwoPair() {
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card("A", Suit.hearts.name()));
		cards.add(new Card("A", Suit.clubs.name()));
		cards.add(new Card("2", Suit.hearts.name()));
		cards.add(new Card("3", Suit.clubs.name()));

		TwoPairRanker underTest = new TwoPairRanker();
		int actual = underTest.getRank(cards);
		Assert.assertEquals(0, actual);
	}

}
