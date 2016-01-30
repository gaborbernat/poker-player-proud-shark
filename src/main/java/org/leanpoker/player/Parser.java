package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class Parser {

	private static List<Card> getOurHand(JsonElement request) {
		List<Card> elements = new ArrayList<>();
		for (JsonElement i : getPlayer(request, "Proud Shark").get("hole_cards").getAsJsonArray()) {
			JsonObject p = i.getAsJsonObject();
			elements.add(new Card(p.get("rank").getAsString(), p.get("suit").getAsString()));
		}
		return elements;
	}

	private static JsonObject getPlayer(JsonElement request, String name) {
		for (JsonElement players : request.getAsJsonObject().get("players").getAsJsonArray()) {
			final JsonObject p = players.getAsJsonObject();
			if (p.get("name").equals(name)) { return p; }
		}
		return null;
	}

	private static JsonObject getOurPlayer(JsonElement request) {
		return getPlayer(request, "Proud Shark");
	}

	static enum Suit {
		hearts, spades, clubs, diamonds;
	}

	static class Card {
		public final int number;
		public final Suit suit;

		Card(String number, String type) {
			this.number = 0;
			this.suit = Suit.valueOf(type);
		}
	}

}
