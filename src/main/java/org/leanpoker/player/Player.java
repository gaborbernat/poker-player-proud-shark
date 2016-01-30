package org.leanpoker.player;

import org.leanpoker.player.domain.JsonParser;

import com.google.gson.JsonElement;

public class Player {

	static final String VERSION = "Steady red, adapt, static dealer fixed rules";

	public static int betRequest(JsonElement request) {
		try {
			return new Game(JsonParser.parseGameState(request.getAsString())).secondStrategy();
		} catch (Exception e) {
			// noinspection ThrowablePrintedToSystemOut
			System.err.println(e);
			e.printStackTrace(System.err);
			return 0;
		}

	}

	public static void showdown(JsonElement game) {}

}
