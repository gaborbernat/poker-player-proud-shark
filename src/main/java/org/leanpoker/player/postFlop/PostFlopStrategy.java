package org.leanpoker.player.postFlop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.leanpoker.player.Game;
import org.leanpoker.player.domain.Card;
import org.leanpoker.player.domain.GameState;
import org.leanpoker.player.domain.Ranker;

public class PostFlopStrategy {

	private List<Card> myCards;
	private List<Card> commonCards;
	private GameState state;

	public PostFlopStrategy(GameState  state) {
		this.state = state;
		this.myCards = state.getPlayers().get(state.getInAction()).getHole_cards();
		this.commonCards = state.getCommunityCards();;
	}

	public int getRank() {
		Ranker ranker = new Ranker();
		int commonRank = ranker.getRank(commonCards);
		List<Card> allCards = new ArrayList<>();
		allCards.addAll(commonCards);
		allCards.addAll(myCards);
		int myRank = ranker.getRank(allCards);
		if (commonRank < myRank) {
			return myRank;
		} else {
			return 0;
		}
	}

	public int getBet() {
		int rank = getRank();
		 Game game = new Game(state);
		 if(rank>300){
			 return 10000;
		 } else if(game.isDealerUs()){ 
			 return 20;
		 } 
		 return 0;
	}

}
