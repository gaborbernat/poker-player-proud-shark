package org.leanpoker.player;

import org.leanpoker.player.domain.GameState;
import org.leanpoker.player.domain.OtherPlayer;

public class Game {
	
	private static final String TEAM_NAME = "Proud Shark";
	private static final String STATUS_ACTIVE = "active";
	
	private final GameState state;
	
	private int index;
	
	public Game(GameState state) {
		this.state = state;
	}

	/**
	 * A játékban hányas számú játékos vagyunk? a "players" lista indexe.
	 */
	public int getOurIndex() {
		if (index<0) {
			index = 0;
			for (OtherPlayer player : state.getPlayers()) {
				if (TEAM_NAME.equals(player.getName())) {
					break;
				}
				index++;
			}
		}
		return index;
	}
	
	/**
	 * Hány aktív játékos van még? (Aktív = nem esett ki és nem foldolt)
	 */
	public int getActivePlayerCount() {
		int cnt = 0;
		for (OtherPlayer player : state.getPlayers()) {
			if (STATUS_ACTIVE.equals(player.getStatus())) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public boolean isDealerUs() {
		return state.getDealer()==getOurIndex();
	}
	
}
