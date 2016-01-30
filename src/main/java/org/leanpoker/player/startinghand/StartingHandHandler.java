package org.leanpoker.player.startinghand;

import org.leanpoker.player.Parser.Card;

public class StartingHandHandler {
	
	private static final String PROPERTY_FILE = "starting-hand.properties";

	public int getStartingHandValue(Card card1, Card card2) {
		if (card1.number>12 && card2.number>12)
			return 1;
		return 10;
	}
	
	private final String decode(Card card1, Card card2) {
		StringBuilder str = new StringBuilder();
		return null;
	}
	
	private final String decode(int cardType) {
		if (cardType < 10)
			return Integer.toString(cardType);
		return null;
	}
	
}
