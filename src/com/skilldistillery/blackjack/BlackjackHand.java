package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Hand;

public class BlackjackHand extends Hand {
	// FIELDS

	// CONSTRUCTORS
	public BlackjackHand() {
		super();
	}

	// METHODS
	@Override
	public int getHandValue() {
		int totalHandValue = 0;
		for (Card card : hand) {
			totalHandValue += card.getValue();
		}

		return totalHandValue;
	}

	public boolean isBlackjack() {
		if (hand.size() == 2) {
			if (getHandValue() == 21) {
				return true;
			}
		}
		return false;
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}


}
