package org.leanpoker.player.startinghand;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.leanpoker.player.Parser.Card;

public class StartingHandHandler {
	
	private static final String PROPERTY_FILE = "starting-hand.properties";
	private static Map<String, Integer> mapping;

	public int getStartingHandValue(Card card1, Card card2) {
//		if (card1.number>12 && card2.number>12)
//			return 1;
//		return 10;
		return find(card1, card2);
	}
	
	private final int find(Card card1, Card card2) {
		Integer value = getMapping().get(decode(card1, card2));
		if (value==null) {
			value = getMapping().get(decode(card2, card1));
		}
		if (value!=null)
			return value.intValue();
		else
			return 10;
	}
	
	private final Map<String, Integer> getMapping() { 
		if (mapping==null) {
			mapping = new HashMap<String, Integer>();
			Properties props = new Properties();
			try {
				props.load(getClass().getResourceAsStream(PROPERTY_FILE));
				for (String key : props.stringPropertyNames()) {
					try {
						int value = Integer.parseInt(props.getProperty(key));
						mapping.put(key, value);
					} catch (NumberFormatException ex) {
						ex.printStackTrace(System.err);
					}
				}
			} catch (IOException ex) {
				ex.printStackTrace(System.err);
				// TODO
			}
		}
		return mapping;
	}
	
	private final String decode(Card card1, Card card2) {
		StringBuilder str = new StringBuilder();
		if (card1.suit!=card2.suit) {
			str.append("o");
		} else {
			str.append("s");
		}
		str.append(decode(card1.number));
		str.append(decode(card2.number));
		return str.toString();
	}
	
	private final String decode(int cardType) {
		if (cardType < 10)
			return Integer.toString(cardType);
		switch (cardType) {
		case 10: return "T";
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		case 14: return "A";
		}
		return "";
	}
	
}
