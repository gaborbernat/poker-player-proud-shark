package org.leanpoker.player;

import org.leanpoker.player.domain.Card;
import org.leanpoker.player.domain.GameState;
import org.leanpoker.player.domain.OtherPlayer;
import org.leanpoker.player.startinghand.StartingHandHandler;

import java.util.List;

public class Game {

	private static final String TEAM_NAME = "Proud Shark";
	private static final String STATUS_ACTIVE = "active";

	private final GameState state;

	private int index;

	public Game(GameState state) {
		this.state = state;
	}

	/**
	 * The index of our player in the "players" list.
	 */
	public int getOurIndex() {
		if (index < 0) {
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
	 * Number of active players.
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

	/**
	 * Is the dealer our player?
	 */
	public boolean isDealerUs() {
		return state.getDealer() == getOurIndex();
	}

	public boolean shouldWeGo() {
		List<Card> cards = state.getPlayers().get(state.getInAction()).getHole_cards();
		final int limit = getActivePlayerCount() <= 3 ? 3 : 1;
		return new StartingHandHandler().getStartingHandValue(cards.get(0), cards.get(1)) <= limit;
	}

	private static int allInValue() {
		return 1000000;
	}

	public int firstStrategy() {
		return shouldWeGo() ? allInValue() : 0;
	}

	public boolean isThereAnyBetInRound() {
		return state.getPot() > state.getSmallBlind() * 3;
	}

	public int secondStrategy() {
		if (isDealerUs() && !isThereAnyBetInRound()) { return state.getMinimumRaise(); }
		return firstStrategy();
	}

}
