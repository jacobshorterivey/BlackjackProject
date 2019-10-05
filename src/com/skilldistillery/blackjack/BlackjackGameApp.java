package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.Card;

public class BlackjackGameApp {
	private Scanner kb;
	private Card currCard;
	private Dealer dealer;
	private Player p1;

	public static void main(String[] args) {
		BlackjackGameApp bga = new BlackjackGameApp();
		bga.launch();
	}

	private void launch() {
		System.out.println("Welcome to Blackjack!");
		System.out.println("Starting game...");
		System.out.println();

		gameLoop();

	}

	public void gameLoop() {
		boolean keepPlaying = true;
		kb = new Scanner(System.in);

		while (keepPlaying) {
			dealer = new Dealer();
			p1 = new Player();
			initialDeal();
			menu(kb);

			System.out.println("Would you like to play again? Y/N?");
			String userIn = kb.nextLine();
			if (userIn.equalsIgnoreCase("n")) {
				keepPlaying = false;
			}

		}
		kb.close();

	}

	private void initialDeal() {
		dealer.shuffleDealerDeck();

		currCard = dealer.deal();
		p1.insertCard(currCard);
		System.out.println("The dealer dealt you a " + currCard.toString());

		currCard = dealer.deal();
		dealer.insertCard(currCard);
		System.out.println("The dealer dealt themself a card face down.");

		currCard = dealer.deal();
		p1.insertCard(currCard);
		System.out.println("The dealer dealt you a " + currCard.toString());

		if (p1.getHand().isBlackjack()) {
			System.out.println("BLACKJACK!!!");

		}

		currCard = dealer.deal();
		dealer.insertCard(currCard);
		System.out.println("The dealer dealt themself a " + currCard.toString());
		System.out.println();

	}

	private void menu(Scanner kb) {
		boolean keepGoing = true;

		while (keepGoing) {

			System.out.println("Your " + p1.getHand().toString());
			System.out.println("Your hand total: " + p1.getHand().getHandValue());
			System.out.println();
			System.out.println("What will you do?");
			System.out.println("1.) Hit");
			System.out.println("2.) Stand");
			System.out.println("3.) Check the dealer's cards");
			String userInput = kb.nextLine();
			switch (userInput) {
			case "1":
				if (p1.getHand().getHandValue() == 21) {
					System.out.println("You have a score of 21, and cannot hit again. ");
				} else {
					System.out.println("You hit.");
					hit(p1);
				}
				if (p1.getHand().isBust()) {
					keepGoing = false;
				}
				break;
			case "2":
				System.out.println("You stand.");
				keepGoing = false;
				break;
			case "3":
				checkDealerCards();
				break;
			default:
				System.out.println("Invalid entry.");
				break;
			}
		}

		if (p1.getHand().isBlackjack() && !dealer.getHand().isBlackjack()) {
			System.out.println("Player got a blackjack, and dealer didn't match. Player wins!");
		} else if (!p1.getHand().isBust()) {// if-statement to prevent dealer turn if player busted
			dealerTurn();
		} else if (p1.getHand().isBust()) {
			System.out.println("Your hand total: " + p1.getHand().getHandValue());
			System.out.println("Bust! You lose.");
		}

	}

	public void dealerTurn() {
		System.out.println("Dealer turn.");
		System.out.println("Dealer reveals their " + dealer.getHand().toString());
		System.out.println("Dealer's hand total: " + dealer.getHand().getHandValue());
		if (dealer.getHand().isBlackjack()) {
			System.out.println("Dealer got a blackjack!");
		}
		while (dealer.getHand().getHandValue() < 17) {// while the dealer hasn't reached 17, they have to hit again
			System.out.println("Dealer hits.");
			hit(dealer);
		}

		if ((!dealer.getHand().isBust()) && dealer.getHand().getHandValue() >= 17) {
			// if the dealer hasn't busted and has 17 or more, they must stand
			System.out.println("Dealer has " + dealer.getHand().getHandValue() +". Dealer must stand.");
		}

		if ((p1.getHand().getHandValue() < dealer.getHand().getHandValue()) && !dealer.getHand().isBust()) {
			System.out.println("Your hand total: " + p1.getHand().getHandValue());
			System.out.println();
			System.out.println("Dealer wins!");// if player has less than dealer...
		} // and dealer hasn't busted, dealer wins
		else if (p1.getHand().getHandValue() == dealer.getHand().getHandValue()) {// if they are equal, push
			System.out.println("Push!");
		} else {
			System.out.println("Your hand total: " + p1.getHand().getHandValue());
			System.out.println("You beat the dealer! Player wins!");
		}

	}

	public void hit(Participant currPlayer) {
		currCard = dealer.deal();
		currPlayer.insertCard(currCard);

		System.out.println("The dealer dealt a " + currCard.toString());

		if (currPlayer instanceof Dealer) {
			System.out.println("Dealer's hand total: " + dealer.getHand().getHandValue());
		}

	}

	public void checkDealerCards() {
		System.out.println("The dealer is showing their face down card and a " + dealer.getHand().getHandList().get(1));
	}

}
