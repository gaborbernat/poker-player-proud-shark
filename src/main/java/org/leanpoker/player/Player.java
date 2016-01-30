package org.leanpoker.player;

import org.leanpoker.player.domain.JsonParser;

import com.google.gson.JsonElement;

public class Player {

	static final String VERSION = "Steady red, adapt";

	public static int betRequest(JsonElement request) {
		try {
			return new Game(JsonParser.parseGameState(request.getAsString())).firstStrategy();
		} catch (Exception e) {
			// noinspection ThrowablePrintedToSystemOut
			System.err.println(e);
			return 0;
		}

	}

	public static void showdown(JsonElement game) {}

}
