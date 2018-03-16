package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;

public abstract class AbstractDealer extends Player {

	public AbstractDealer(String name, List<Card> hand, int moneys) {
		super(name, hand, moneys);
	}

	protected boolean hitMe() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
