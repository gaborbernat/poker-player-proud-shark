package org.leanpoker.player.domain;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.leanpoker.player.Parser.Suit;

public class RankerTest {
	@Test
	public void testPairRanker(){
		ArrayList<Card> cards = new ArrayList<>();
		cards.add(new Card("A", Suit.hearts.name()));
		cards.add(new Card("A", Suit.clubs.name()));
		Ranker ranker = new Ranker();
		//when
		int actual = ranker.getRank(cards);
		
		Assert.assertEquals(128, actual);
	}
	
	@Test
	public void testTwoPairRanker(){
		ArrayList<Card> cards = new ArrayList<>();
		cards.add(new Card("A", Suit.hearts.name()));
		cards.add(new Card("A", Suit.clubs.name()));
		cards.add(new Card("10", Suit.hearts.name()));
		cards.add(new Card("10", Suit.clubs.name()));
		Ranker ranker = new Ranker();
		//when
		int actual = ranker.getRank(cards);
		
		Assert.assertEquals(248, actual);
	}
}
