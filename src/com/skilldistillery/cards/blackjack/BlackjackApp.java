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
	private String playAgain = "";
	private String userName = "";
	private static Scanner kb = new Scanner(System.in);

	private void run() {

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
		System.out.print("Your hand is worth " + hand.getValueOfUserHand() + ". ");
		System.out.println(userName + ", would you like to hit or to stay?");
		String hitOrStay = kb.next();
		if (hitOrStay.startsWith("h")) {
			while (true) {
				hitUser();
				System.out.print("Your hand is now worth " + hand.getValueOfUserHand() + " ");
				if (hand.getValueOfUserHand() > 21) {
					System.out.println("Bust! You lose this round. Would you like to play again?");
					playAgain = kb.next();
					if (playAgain.startsWith("y")) {
						run();
					}
					else {
						System.out.println("Goodbye, " + userName + "!");
						destroy();
					}
				}
				System.out.println(userName + ", would you like to hit or to stay?");
				hitOrStay = kb.next();
				if (hitOrStay.startsWith("s")) {
					break;
				}
			}
		}
		
		//Dealer Logic:
		
		

	}

	public static void main(String[] args) {
		app.preRun();
		app.run();
	}

	private void preRun() {
		System.out.println("What is your name?");
		userName = kb.next();
		System.out.print("\nAlright, " + userName + ".");
		System.out.println(" Let's play some blackjack!");
		System.out.println("***********************************\n");
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
		System.out.println(c.toString());
		hand.addToUserHand(c);
	}

	public void hitDealer() {
		Card c = d.deck.remove(0);
		System.out.println(c.toString());
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
		for (int i = 0; i < userHand.size(); i++) {
			System.out.println(userHand.get(i).toString());
		}
	}

	public void showDealerCard() {
		List<Card> dealerHand = hand.getDealerHand();
		System.out.println(dealerHand.get(0));
	}

	private void destroy() {
		kb.close();
		System.exit(0);
	}
}
