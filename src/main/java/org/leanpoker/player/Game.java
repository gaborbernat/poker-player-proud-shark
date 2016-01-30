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
	 * A j�t�kban h�nyas sz�m� j�t�kos vagyunk? a "players" lista indexe.
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
	 * H�ny akt�v j�t�kos van m�g? (Akt�v = nem esett ki �s nem foldolt)
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
