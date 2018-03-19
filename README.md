#Blackjack Project

##Skill Distillery Week 3 Weekend Homework

###By: Eli Harper

####Built with Java in Eclipse

This project was created to contain most of the aspects of a real game of blackjack. In order to create this app, I used the following classes:
*Player: an abstract class that gives its subclasses the states of name and hand, which all players who could be incorporated into this game will have
*AbstractDealer: another abstract class that has been implemented for the sake of future additional states that may be exclusive to the dealer
*Dealer: the class of the non-playing character that controls the logic while the user is not making choices; originally, I intended for the class to house this logic in its own methods, but its current chief responsibility is to keep its hand separate from the user's
*Hand: this class contains methods responsible for manipulating the deck and hand through .remove() and .add(). Additionally, the hand class is responsible for displaying each of the players' hands, calculating their values, and resetting them after each round
*BlackjackApp: this app controls all of the main() and run() methods - which are fairly extensive. These methods are responsible for instantiating external classes, deck creation and handling the cards within; the deck and cards, for the most part, are brought from the common package inside of the Blackjack project.


Within the common package, the deck of cards is created by applying the Rank and Suit enums to each card created (52 total) in nested for loops created so that each card is unique and has all of the necessary properties. Once the deck is created, it is shuffled prior to the round and is continually used until the deck is depleted. At the point that the deck is depleted, the user will be prompted to restart with a new deck.
