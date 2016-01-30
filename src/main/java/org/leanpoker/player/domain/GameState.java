package org.leanpoker.player.domain;

import java.util.List;

public class GameState {
	private int round;
	private int bet_index;
	private int small_blind;
	private int current_buy_in;
	private int pot;
	private int minimum_raise;
	private int dealer;
	private int orbits;
	private int in_action;
	private List<?> players;
	private List<Card> community_cards;

	public GameState(int round, int betIndex, int smallBlind, int currentBuyIn, int pot, int minimumRaise, int dealer,
			int orbits, int inAction, List<?> players, List<Card> communityCards) {
		this.round = round;
		this.bet_index = betIndex;
		this.setCommunityCards(communityCards);
		this.setPlayers(players);
		this.setInAction(inAction);
		this.setOrbits(orbits);
		this.setDealer(dealer);
		this.setMinimumRaise(minimumRaise);
		this.setPot(pot);
		this.setCurrentBuyIn(currentBuyIn);
		this.setSmallBlind(smallBlind);
	}

	@Override
	public String toString() {
		return "GameState [round=" + round + ", bet_index=" + bet_index + ", small_blind=" + small_blind
				+ ", current_buy_in=" + current_buy_in + ", pot=" + pot + ", minimum_raise=" + minimum_raise
				+ ", dealer=" + dealer + ", orbits=" + orbits + ", in_action=" + in_action + ", players=" + players
				+ ", community_cards=" + community_cards + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bet_index;
		result = prime * result + ((community_cards == null) ? 0 : community_cards.hashCode());
		result = prime * result + current_buy_in;
		result = prime * result + dealer;
		result = prime * result + in_action;
		result = prime * result + minimum_raise;
		result = prime * result + orbits;
		result = prime * result + ((players == null) ? 0 : players.hashCode());
		result = prime * result + pot;
		result = prime * result + round;
		result = prime * result + small_blind;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameState other = (GameState) obj;
		if (bet_index != other.bet_index)
			return false;
		if (community_cards == null) {
			if (other.community_cards != null)
				return false;
		} else if (!community_cards.equals(other.community_cards))
			return false;
		if (current_buy_in != other.current_buy_in)
			return false;
		if (dealer != other.dealer)
			return false;
		if (in_action != other.in_action)
			return false;
		if (minimum_raise != other.minimum_raise)
			return false;
		if (orbits != other.orbits)
			return false;
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		if (pot != other.pot)
			return false;
		if (round != other.round)
			return false;
		if (small_blind != other.small_blind)
			return false;
		return true;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getBetIndex() {
		return bet_index;
	}

	public void setBetIndex(int betIndex) {
		this.bet_index = betIndex;
	}

	public int getSmallBlind() {
		return small_blind;
	}

	public void setSmallBlind(int smallBlind) {
		this.small_blind = smallBlind;
	}

	public int getCurrentBuyIn() {
		return current_buy_in;
	}

	public void setCurrentBuyIn(int currentBuyIn) {
		this.current_buy_in = currentBuyIn;
	}

	public int getPot() {
		return pot;
	}

	public void setPot(int pot) {
		this.pot = pot;
	}

	public int getMinimumRaise() {
		return minimum_raise;
	}

	public void setMinimumRaise(int minimumRaise) {
		this.minimum_raise = minimumRaise;
	}

	public int getDealer() {
		return dealer;
	}

	public void setDealer(int dealer) {
		this.dealer = dealer;
	}

	public int getOrbits() {
		return orbits;
	}

	public void setOrbits(int orbits) {
		this.orbits = orbits;
	}

	public int getInAction() {
		return in_action;
	}

	public void setInAction(int inAction) {
		this.in_action = inAction;
	}

	public List<?> getPlayers() {
		return players;
	}

	public void setPlayers(List<?> players) {
		this.players = players;
	}

	public List<Card> getCommunityCards() {
		return community_cards;
	}

	public void setCommunityCards(List<Card> communityCards) {
		this.community_cards = communityCards;
	}

}
