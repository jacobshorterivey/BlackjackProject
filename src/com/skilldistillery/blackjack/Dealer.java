package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealer extends Participant {
	private Deck dealerDeck = new Deck();

	public Dealer() {
		super();
	}

	public Card deal() {
		return dealerDeck.dealCard();
	}
	
	public void shuffleDealerDeck() {
		System.out.println("The dealer shuffles the deck.");
		dealerDeck.shuffleDeck();
	}

}
