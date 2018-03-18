package com.skilldistillery.cards.common;

import com.skilldistillery.cards.common.Rank;
import com.skilldistillery.cards.common.Suit;

public class Card {

	public Rank rank;
	private Suit suit;

	public Card(Suit suit, Rank rank) {
		this.rank = rank;
		this.suit = suit;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(rank);
		builder.append(" of ");
		builder.append(suit);
		return builder.toString();
	}

	public Suit getSuit() {
		return suit;
	}
	
	public int getValue() {
		return rank.getValue();
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
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
	
	
}
