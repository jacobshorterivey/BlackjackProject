package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;

public abstract class Participant {
	// FIELDS
	private BlackjackHand hand;

	// CONSTRUCTORS
	public Participant() {
		hand = new BlackjackHand();
	}

	// METHODS
	public void insertCard(Card card) {
		hand.addCard(card);
	}
	
	public BlackjackHand getHand() {
		return this.hand;
	}
	
	public int getHandSize() {
		return getHand().getHandSize();
	}

}
