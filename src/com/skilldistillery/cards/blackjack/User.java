package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;

public class User extends Player {
	
	public User(String name, List<Card> hand) {
		super(name, hand);
	}
	
	@Override
	protected boolean hitMe() {
		
		return false;
	}
	
	
	
	
	

}
