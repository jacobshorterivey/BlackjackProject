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
		dealer = new Dealer();
		p1 = new Player();
		System.out.println("Starting game...");
		System.out.println();

		gameLoop();

	}

	public void gameLoop() {
		initialDeal();
		menu();

	}

	private void initialDeal() {
		dealer.shuffleDealerDeck();

		currCard = dealer.deal();
		p1.insertCard(currCard);
		System.out.println("The dealer dealt you a " + currCard.toString());

		currCard = dealer.deal();
		dealer.insertCard(currCard);
		System.out.println("The dealer dealt themself their hole card.");

		currCard = dealer.deal();
		p1.insertCard(currCard);
		System.out.println("The dealer dealt you a " + currCard.toString());
		
		p1.getHand().isBlackjack();
		
		currCard = dealer.deal();
		dealer.insertCard(currCard);
		System.out.println("The dealer dealt themself a " + currCard.toString());
		
		dealer.getHand().isBlackjack();
	}

	public void checkDealerCards() {
		System.out.println("The dealer is showing their hole card and a " + dealer.getHand().getHandList().get(1));
//		System.out.println(dealer.getHand().toString());
	}

	private void menu() {
		boolean keepGoing = true;
		kb = new Scanner(System.in);

		while (keepGoing) {

			System.out.println("Your " + p1.getHand().toString());
			System.out.println();
			System.out.println("What will you do?");
			System.out.println("1.) Hit");
			System.out.println("2.) Stand");
			System.out.println("3.) Check your hand's value");
			System.out.println("4.) Check the dealer's cards");
			String userInput = kb.nextLine();
			switch (userInput) {
			case "1":
				if (p1.getHand().getHandValue() == 21) {
					System.out.println("You have a score of 21, and cannot hit again. ");
				} else {
					System.out.println("You hit.");
					hit(p1);
				}
				if(p1.getHand().isBust()) {
					keepGoing = false;
					break;
				}
				break;
			case "2":
				System.out.println("You stand.");
				keepGoing = false;
				break;
			case "3":
				System.out.println("Your hand's total is: " + p1.getHand().getHandValue());
				break;
			case "4":
				checkDealerCards();
				break;
			default:
				System.out.println("Invalid entry.");
				break;
			}
		}
		
		System.out.println("Dealer turn.");
		System.out.println("Dealer " + dealer.getHand().toString());
		System.out.println();
		while(dealer.getHand().getHandValue() < 17) {
			System.out.println("Dealer hits.");
			hit(dealer);
			dealer.getHand().isBust();
		}
		if((!dealer.getHand().isBust()) && dealer.getHand().getHandValue() > 17 ) {
			System.out.println(dealer.getHand().toString());
			System.out.println("Dealer stands.");
		}
		
		
		if(  p1.getHand().getHandValue() <  dealer.getHand().getHandValue()) {
			System.out.println("Dealer wins!");
		}
		else if(  p1.getHand().getHandValue() ==  dealer.getHand().getHandValue()) {
			System.out.println("Push!");
		}else {
			System.out.println("Player wins!");
		}
		
		
		kb.close();
	}

	public void hit(Participant currPlayer) {
		currCard = dealer.deal();
		currPlayer.insertCard(currCard);
		System.out.println("The dealer dealt a " + currCard.toString());
	}
	
//
//	public void stand() {
//		System.out.println("You stand.");
//	}

//	public void doubleDown() {
//
//	}
//
//	public void split() {
//
//	}
//
//	public void surrender() {
//
//	}
//
//	public void insurance() {
//
//	}

}
