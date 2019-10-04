package com.skilldistillery.blackjack;

import java.util.Scanner;

public class Dealing {
	Scanner kb;

	public static void main(String[] args) {
		Dealing d = new Dealing();
		try {
			d.run();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void run() {
		int cardsToDeal;
		int totalValue = 0;
		Card currentCard;
		Deck deck = new Deck();
		
		kb = new Scanner(System.in);
		System.out.print("How many cards would you like to be dealt? ");

		cardsToDeal = kb.nextInt();
		if (cardsToDeal < 0 || cardsToDeal > 52) {
			throw new IllegalArgumentException("Maximum deck size is 52. Enter an integer 0 - 52.");
		}
		deck.deckOfCards = deck.shuffleDeck();
		for (int i = 0; i < cardsToDeal; i++) {
			currentCard = deck.dealCard();
			System.out.println("Card #" + (i+1) + ": " + currentCard.toString());
			totalValue += currentCard.getValue();

		}
		 System.out.println("Total value of all cards: " + totalValue);
		
		 kb.close();
	}

}
