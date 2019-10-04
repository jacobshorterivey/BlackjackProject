package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	//FIELDS
	List<Card> deckOfCards;

	//CONSTRUCTORS
	public Deck() {
		deckOfCards = new ArrayList<>();
		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();
		
		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				Card currentCard = new Card(suit, rank);
				deckOfCards.add(currentCard);
			}
		}
//		System.out.println("Deck starting size: " + deckOfCards.size());
		
	}
	
	
	//METHODS
	public int checkDeckSize() {
		System.out.println("Current deck size: " + deckOfCards.size());
		return deckOfCards.size();
	}
	
	public Card dealCard() {
		return deckOfCards.remove(0);
	}
	
	public List<Card> shuffleDeck(){
		Collections.shuffle(deckOfCards);
		return deckOfCards;
	}
}
