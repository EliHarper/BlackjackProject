package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck;
	
//	public static void main(String[] args) {
//		Deck deck = new Deck();
//		//deck.run();
//	}
	protected void run() {
//		checkDeckSize(deck);
//		shuffle(deck);
		dealCard(deck);
	}
	
	protected Deck() {
		List<Card> deck = createDeck();
	}
	
	private void dealCard(List<Card> deck) {
		Card cardDealt = deck.remove(0);
		System.out.println(cardDealt);
	}

	protected List<Card> shuffle(List<Card> deck) {
		Collections.shuffle(deck);
		return deck;
	}

	protected void checkDeckSize(List<Card> deck) {
		if (deck.size() == 52) {
			System.out.println("Deck size is checked, 52 cards are present.");
		}
		else {
			System.out.println("Somebody here is trying to cheat..");
		}
	}

	protected List<Card> createDeck() {
		deck = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
			for(Rank r : Rank.values()) {
				Card c = new Card(s, r);
				deck.add(c);
			}
		}
		return deck;
	}

}
