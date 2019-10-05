package com.skilldistillery.cards;

import java.util.LinkedList;
import java.util.List;

public abstract class Hand {
	// FIELDS
	protected List<Card> hand;

	// CONSTRUCTORS
	public Hand() {
		hand = new LinkedList<Card>();
	}

	// METHODS
	public void addCard(Card card) {
		hand.add(card);
	}

	public void clear() {
		hand.clear();
	}

	public int getHandSize() {
		return hand.size();
	}

	public List<Card> getHandList() {
		return this.hand;
	}

	public abstract int getHandValue();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("hand: ");
		for (Card card : hand) {
			builder.append(card.toString()).append(", ");
		}
		if (builder.charAt(builder.length() - 2) == ',') {
			builder.deleteCharAt(builder.length() - 2);
		}

		return builder.toString();
	}

}
