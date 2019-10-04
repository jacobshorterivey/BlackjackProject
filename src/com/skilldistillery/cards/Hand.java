package com.skilldistillery.cards;

import java.util.LinkedList;
import java.util.List;

public abstract class Hand {
	//FIELDS
	protected List<Card> hand;

	//CONSTRUCTORS
	public Hand(List<Card> hand) {
		hand = new LinkedList<Card>();
		this.hand = hand;
	}
	
	
	//METHODS
	public void addCard(Card card) {
		
	}
	
	public void clear() {
		
	}
	
	public abstract int getHandValue();


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Your hand: ");
		for (Card card : hand) {
			builder.append(card.toString()).append(", ");
		}
		if(    builder.charAt(builder.length()-1) == ',' ) {
			builder.deleteCharAt(builder.length()-1);
		}
		
		return builder.toString();
	}
	
	
}
