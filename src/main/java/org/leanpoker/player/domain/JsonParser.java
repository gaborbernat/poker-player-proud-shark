package org.leanpoker.player.domain;

import com.google.gson.Gson;

public class JsonParser {
	private static final Gson gson = new Gson();
	public static final GameState parseGameState(String json){
		return gson.fromJson(json, GameState.class);
	}
}
