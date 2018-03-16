package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;

public class Hand {
	List<Card> hand = new ArrayList<>();
	
	public List<Card> hand(){
		
		return hand;
	}
	
	public void addCard(Card cardDealt) {
		
	}
	
	public List<Card> getCardsInHand(){
		
		return hand;
	}
	
	public int getValueOfHand() {
		
		return 0;
	}
}
