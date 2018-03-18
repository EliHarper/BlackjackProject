package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.skilldistillery.cards.blackjack.BlackjackApp;
import com.skilldistillery.cards.blackjack.Hand;

public class Deck {
	public List<Card> deck;
	
	public Deck() {
		List<Card> deck = createDeck();
	}
	
	public Card dealCard(List<Card> deck) {
		Card cardDealt = deck.remove(0);
		return cardDealt;
	}

	public List<Card> shuffle(List<Card> deck) {
		Collections.shuffle(deck);
		return deck;
	}

	public void checkDeckSize(List<Card> deck) {
		if (deck.size() == 52) {
			System.out.println("\nDeck size is checked, 52 cards are present.");
		}
		else {
			System.out.println("\nDeck size is checked, " + deck.size() + " cards remain.");
			
		}
	}

	public List<Card> createDeck() {
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
