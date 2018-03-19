package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer extends AbstractDealer {
	
	public Dealer(String name, List<Card> dealerHand) {
		super(name, dealerHand);
	}

	@Override
	protected boolean hitMe() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
