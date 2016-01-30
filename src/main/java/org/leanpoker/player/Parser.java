package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class Parser {
	final static String OUR_NAME = "Proud Shark";

	public static List<Card> getOurHand(JsonElement request) {
		return getHand(request, OUR_NAME);
	}

	public static List<Card> getHand(JsonElement request, final String name) {
		List<Card> elements = new ArrayList<>();
		for (JsonElement i : getPlayer(request, name).get("hole_cards").getAsJsonArray()) {
			JsonObject p = i.getAsJsonObject();
			elements.add(new Card(p.get("rank").getAsString(), p.get("suit").getAsString()));
		}
		return elements;
	}

	public static JsonObject getPlayer(JsonElement request, String name) {
		for (JsonElement players : request.getAsJsonObject().get("players").getAsJsonArray()) {
			final JsonObject p = players.getAsJsonObject();
			if (p.get("name").equals(name)) { return p; }
		}
		return null;
	}

	public static JsonObject getOurPlayer(JsonElement request) {
		return getPlayer(request, OUR_NAME);
	}

	public static enum Suit {
		hearts, spades, clubs, diamonds;
	}

	public static class Card {
		public final int number;
		public final Suit suit;

		Card(String number, String type) {
			this.number = getNumber(number);
			this.suit = Suit.valueOf(type);
		}

		private int getNumber(String number) {
			switch (number) {
				case "2":
					return 2;
				case "3":
					return 3;
				case "4":
					return 4;
				case "5":
					return 5;
				case "6":
					return 6;
				case "7":
					return 7;
				case "8":
					return 8;
				case "9":
					return 9;
				case "10":
					return 10;
				case "J":
					return 11;
				case "Q":
					return 12;
				case "K":
					return 13;
				case "A":
					return 14;
				default:
					return 1;
			}
		}
	}

}
