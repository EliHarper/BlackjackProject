package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;

public class Hand {
	private List<Card> dealerHand = new ArrayList<>();
	private List <Card> userHand = new ArrayList<>();

	public Hand(){
	}
	
	public List<Card> getDealerHand(){
		return dealerHand;
	}
	
	public void addToDealerHand(Card card) {
		dealerHand.add(card);
	}

	public void addToUserHand(Card card) {
		userHand.add(card);
	}

	public List<Card> getUserHand(){
		return userHand;
	}
	
	public int getValueOfDealerHand() {
		int sum = 0;
		for (int i = 0; i < dealerHand.size(); i++) {
			sum += dealerHand.get(i).getValue();
		}
		return sum;
	}
	public int getValueOfUserHand() {
		int sum = 0;
		for (int i = 0; i < userHand.size(); i++) {
			sum += userHand.get(i).getValue();
		}
		return sum;
	}
}
