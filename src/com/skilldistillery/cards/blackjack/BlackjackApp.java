package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {
	
	private Hand hand = new Hand();
	static BlackjackApp app = new BlackjackApp();
	private Deck d = new Deck();
	private List<Card> deck = new ArrayList<>();
	
	private void run() {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("What is your name?");
		String userName = kb.next();
		System.out.print("Alright, " + userName + ".");
		System.out.println(" Let's play some blackjack!");
		System.out.println("***********************************\n");
		
		Dealer d = new Dealer("Doug", hand.getDealerHand());
		User u = new User(userName, hand.getUserHand());
		dealerAction();
		giveUserHand();
		giveDealerHand();
		
		System.out.println("\nYour cards: ");
		showUserHand();
		System.out.println("\nDealer shows: ");
		showDealerCard();
		System.out.println();
		System.out.println(userName + ", would you like to hit or to stay?");
		String hitOrStay = kb.nextLine();
		if (hitOrStay.startsWith("h")) {
			hitUser();
		}
		
		
	}
	
	public static void main(String[] args) {
		app.run();
	}
	
	protected void dealerAction() {
		deck = d.createDeck();
		d.checkDeckSize(deck);
		d.shuffle(deck);
	}
	
	public Deck getDeck() {
		return d;
	}

	public void setDeck(Deck deck) {
		this.d = deck;
	}


	public static BlackjackApp getApp() {
		return app;
	}

	public static void setApp(BlackjackApp app) {
		BlackjackApp.app = app;
	}

	
	public void hitUser() {
		Card c = d.deck.remove(0);
		hand.addToUserHand(c);
	}
	
	public void hitDealer() {
		Card c = d.deck.remove(0);
		hand.addToDealerHand(c);
	}
	
	public void giveUserHand() {
		Card c = d.deck.remove(0);
		hand.addToUserHand(c);
		Card c2 = d.deck.remove(0);
		hand.addToUserHand(c2);
	}
	
	public void giveDealerHand() {
		Card c = d.deck.remove(0);
		hand.addToDealerHand(c);
		Card c2 = d.deck.remove(0);
		hand.addToDealerHand(c2);
	}
	
	public void showUserHand() {
		List<Card> userHand = hand.getUserHand();
		System.out.println(userHand.get(0).toString());
		System.out.println(userHand.get(1).toString());
	}
	
	public void showDealerCard() {
		List<Card> dealerHand = hand.getDealerHand();
		System.out.println(dealerHand.get(0));
	}
}
