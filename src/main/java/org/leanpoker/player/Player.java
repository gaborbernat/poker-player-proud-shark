package org.leanpoker.player;

import org.leanpoker.player.domain.GameState;
import org.leanpoker.player.domain.JsonParser;
import org.leanpoker.player.postFlop.PostFlopStrategy;

import com.google.gson.JsonElement;

public class Player {

	static final String VERSION = "Steady red, adapt, static fixed rules";

	public static int betRequest(JsonElement request) {
		try {

			GameState state = JsonParser.parseGameState(request.toString());
			if (state.getCommunityCards() == null || state.getCommunityCards().isEmpty()) {
				PostFlopStrategy strategy = new PostFlopStrategy(state);
				int bet = strategy.getBet();
				return bet;
			}
			return new Game(state).firstStrategy();
		} catch (Exception e) {
			// noinspection ThrowablePrintedToSystemOut
			System.err.println(e);
			e.printStackTrace(System.err);
			return 0;
		}

	}

	public static void showdown(JsonElement game) {}

}
