package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;

public abstract class Player {
	protected String name;
	protected List <Card> hand;
	protected int moneys;
	public Player(String name, List<Card> hand, int moneys) {
		super();
		this.name = name;
		this.hand = hand;
		this.moneys = moneys;
	}
	
	protected abstract boolean hitMe();
	
}