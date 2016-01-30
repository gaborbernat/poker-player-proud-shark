package org.leanpoker.player;

import org.leanpoker.player.startinghand.StartingHandHandler;

import com.google.gson.JsonElement;

import java.util.List;

public class Player {

	static final String VERSION = "Let's do this fixed - 2";

	public static int betRequest(JsonElement request) {
		try {
			return shouldWeGo(request) ? allInValue() : 0;
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}

	}

	public static boolean shouldWeGo(JsonElement element) {
		List<Parser.Card> ourCards = Parser.getOurHand(element);
		Parser.Card f = ourCards.get(0);
		Parser.Card s = ourCards.get(1);
		return new StartingHandHandler().getStartingHandValue(f, s) <= 0;
	}

	private static int allInValue() {
		return 1000000;
	}

	public static void showdown(JsonElement game) {}

}
