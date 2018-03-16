package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;

public abstract class Player {
	protected String name;
	protected List <Card> hand;
	public Player(String name, List<Card> hand) {
		super();
		this.name = name;
		this.hand = hand;
	}
	
	protected abstract boolean hitMe();
	
}