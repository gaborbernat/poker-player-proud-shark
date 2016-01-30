package org.leanpoker.player.startinghand;

import org.leanpoker.player.domain.Card;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class StartingHandHandler {
	
	private static final String PROPERTY_FILE = "starting-hand.properties";
	private static Map<String, Integer> mapping;

	public int getStartingHandValue(Card card1, Card card2) {
		return find(card1, card2);
	}
	
	private final int find(Card card1, Card card2) {
		Integer value = getMapping().get(decode(card1, card2));
		if (value==null) {
			value = getMapping().get(decode(card2, card1));
		}
		if (value!=null)
			return value;
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
		if (!card1.getSuit().equals(card2.getSuit())) {
			str.append("o");
		} else {
			str.append("s");
		}
		str.append(decode(card1.getNumber()));
		str.append(decode(card2.getNumber()));
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
