package org.leanpoker.player.domain;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.leanpoker.player.domain.GameState;

import com.google.gson.Gson;

public class GameStateConversionTest {
	@Test
	public void testParse(){
		//given
		GameState expected = new GameState(3, 1, 10, 320, 
				5, 15, 2, 7, 4, new ArrayList<Card>(), new ArrayList());
		String string = "{"
				+ "'torunament_id':'sdfasdf',"
				+ "'round': 3,"
				+ "'bet_index': 1,"
				+ "'small_blind': 10,"
				+ "'current_buy_in': 320,"
				+ "'pot': 5,"
				+ "'minimum_raise': 15,"
				+ "'dealer': 2,"
				+ "'orbits': 7,"
				+ "'in_action': 4,"
				+ "'players': [],"
				+ "'community_cards': ["
				+ "  {\"rank\": \"4\",\"suit\": \"spades\"},"
				+ "]"
				+ "}";
		Gson gson = new Gson();
		//when
		GameState actual = gson.fromJson(string, GameState.class);
		//then
		Assert.assertEquals(expected, actual); 
	}
}
