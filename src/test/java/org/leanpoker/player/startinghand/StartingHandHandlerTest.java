package org.leanpoker.player.startinghand;

import org.junit.Assert;
import org.junit.Test;
import org.leanpoker.player.Parser.Card;

public class StartingHandHandlerTest {

	StartingHandHandler tested = new StartingHandHandler();
	
	@Test
	public void getStartingHandValue_22() {
		// given
		Card card1 = new Card("2", "hearts");
		Card card2 = new Card("2", "spades");
		int result = tested.getStartingHandValue(card1, card2);
		Assert.assertEquals(10, result);
	}
	
	@Test
	public void getStartingHandValue_AA() {
		// given
		Card card1 = new Card("A", "hearts");
		Card card2 = new Card("A", "spades");
		int result = tested.getStartingHandValue(card1, card2);
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void getStartingHandValue_AK() {
		// given
		Card card1 = new Card("K", "hearts");
		Card card2 = new Card("A", "hearts");
		int result = tested.getStartingHandValue(card1, card2);
		Assert.assertEquals(1, result);
	}
	
}
