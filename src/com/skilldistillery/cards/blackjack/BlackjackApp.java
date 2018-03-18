package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {

	private boolean won = false;
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
		giveUserHand();
		giveDealerHand();

		System.out.println("\nYour cards: ");
		showUserHand();
		System.out.println("\nDealer shows: ");
		showDealerCard();
		System.out.println();
		System.out.print("\nYour hand is worth " + hand.getValueOfUserHand() + ". ");
		if (hand.getValueOfUserHand() == 21) {
			System.out.println("Nice!");
			dealerLogic();
		}
		System.out.println(userName + ", would you like to hit or to stay?");
		String hitOrStay = kb.next();
		if (hitOrStay.startsWith("h")) {
			while (true) {
				hitUser();
				System.out.print("Your hand is now worth " + hand.getValueOfUserHand() + ". ");
				if (hand.getValueOfUserHand() > 21) {
					System.out.println("Bust! You lose this round.");
					playAgain();
				}
				else if(hand.getValueOfUserHand() == 21) {
					System.out.println("Nice!");
					dealerLogic();
				}
				System.out.println(userName + ", would you like to hit or to stay?");
				hitOrStay = kb.next();
				hitOrStay.toLowerCase();
				if (hitOrStay.contains("s")) {
					dealerLogic();
				}
			}
		}
		else {
			dealerLogic();
		}
	}

	public static void main(String[] args) {
		app.preRun();
		app.deckPrep();
		app.run();
	}

	private void preRun() {
		System.out.println("What is your name?");
		userName = kb.nextLine();
		System.out.print("\nAlright, " + userName + ".");
		System.out.println(" Let's play some Blackjack!");
		int starLineLength = userName.length() + 37;
		for (int i = 0; i < starLineLength; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	protected void deckPrep() {
		deck = d.createDeck();
		d.checkDeckSize(deck);
		d.shuffle(deck);
	}
	
	protected void dealerLogic() {
		System.out.println("\nDealer's hole card: ");
		showDealerHoleCard();
		while (hand.getValueOfUserHand() > hand.getValueOfDealerHand()) {
			System.out.print("Dealer hits, drawing a ");
			hitDealer();
		}
		if (hand.getValueOfDealerHand() > 21) {
			System.out.print("Dealer's hand: ");
			showDealerHand();
			System.out.println("Dealer busts! You win!");
			won = true;
			playAgain();
		}
		else if (hand.getValueOfDealerHand() > hand.getValueOfUserHand()) {
			System.out.print("Dealer wins with a hand of ");
			showDealerHand();
			playAgain();
		}
		
		if (hand.getValueOfDealerHand() == hand.getValueOfUserHand()) {
			
			System.out.print("Dealer's hand: " );
			showDealerHand();
			System.out.println("Push; nobody wins.");
			playAgain();
		} 
	}

	private void playAgain() {
		
		System.out.println("Would you like to play again?");
		
		if (won) {
			System.out.println("Remember.. NEVER quit when you're on a heater.");
		}
		
		playAgain = kb.next();
		playAgain.toLowerCase();
		
		if (playAgain.contains("y")) {
			hand.resetHands();
			won = false;
			d.checkDeckSize(deck);
			if (deck.size() < 4) {
				System.out.println("Would you like to restart with a new deck?");
				String restart = kb.next();
				restart.toLowerCase();
				if (restart.contains("y")) {
					deckPrep();
				}
				else {
					destroy();
				}
			}
			run();
		}
		else {
			System.out.println("Goodbye, " + userName + "!");
			destroy();
		}
	}

	public Deck getDeck() {
		return d;
	}

	public static BlackjackApp getApp() {
		return app;
	}

	public void hitUser() {
		Card c = d.deck.remove(0);
		System.out.println("\n" + c.toString());
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
	
	public void showDealerHand() {
		List<Card> dealerHand = hand.getDealerHand();
		for (int i = 0; i < dealerHand.size(); i++) {
			
			System.out.print(dealerHand.get(i).toString());
			
			if (i < dealerHand.size() - 2) {
				System.out.print(", ");
			}
			else if (i == dealerHand.size() - 2) {
				System.out.print(", and ");
			}
		}
		System.out.println("; value: " + hand.getValueOfDealerHand() + "\n");
	}

	public void showDealerCard() {
		List<Card> dealerHand = hand.getDealerHand();
		System.out.print(dealerHand.get(0));
	}
	
	public void showDealerHoleCard() {
		List<Card> dealerHand = hand.getDealerHand();
		System.out.println(dealerHand.get(1) + "\n");
	}

	private void destroy() {
		System.err.println("Blackjack simulator self-destruct sequence engaged.");
		kb.close();
		System.exit(0);
	}
}
