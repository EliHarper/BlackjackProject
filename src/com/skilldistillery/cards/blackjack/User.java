package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;

public class User extends Player {

	public User(String name, List<Card> hand, int moneys) {
		super(name, hand, moneys);
	}
	
	@Override
	protected boolean hitMe() {
		
		return false;
	}
	
	
	

}
