package org.leanpoker.player.domain;

import org.leanpoker.player.Parser.Suit;

public class Card {
	private final String rank;
	private final String suit;

	public Card(Integer rank, Suit suit) {
		this.rank = rank.toString();
		this.suit = suit.toString();
	}

	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public int getNumber(){
		return getNumber(rank);
	}

	public Suit getSuit(){
		return Suit.valueOf(suit);
	}

	@Override
	public String toString() {
		return "Card [rank=" + rank + ", suit=" + suit + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
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
		Card other = (Card) obj;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		return true;
	}

	private int getNumber(String number) {
		switch (number) {
		case "2":
			return 2;
		case "3":
			return 3;
		case "4":
			return 4;
		case "5":
			return 5;
		case "6":
			return 6;
		case "7":
			return 7;
		case "8":
			return 8;
		case "9":
			return 9;
		case "10":
			return 10;
		case "J":
			return 11;
		case "Q":
			return 12;
		case "K":
			return 13;
		case "A":
			return 14;
		default:
			return 1;
		}
	}
}