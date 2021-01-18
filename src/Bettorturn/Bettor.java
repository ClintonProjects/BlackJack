package Bettorturn;

import java.util.Scanner;

import Index.GameIndex;
import Index.GameIndex.GameState;
import Model.Card;

public class Bettor extends PlayerTurn {

	/*
	 * Author @Clinton Bates Student Code: 20253060
	 * 
	 * This class handles the bettor
	 */

	Scanner sc = new Scanner(System.in);

	@Override
	public void hit() {
		Card newCard = getRandomCard();
		addCard(newCard);
		System.out.println("The player has just drew a " + newCard.abbreviatedCard() + ", leave his total at ["
				+ player.totalStringMessage() + "]");

		if (player.finalScore() > 21)
			GameIndex.gameIndex(GameState.BettorLoss);
		else if (player.finalScore() == 21)
			GameIndex.gameIndex(GameState.HostTurn);
		else
			GameIndex.gameIndex(GameState.PlayerTurn);
	}

	public void playerChoice() {
		//Let the player choose weather they are going to hit or stay.
		String choice;
		boolean temp = false;
		System.out.println("Would you like to hit or stay?");
		do {
			choice = sc.next();
			if (choice.equalsIgnoreCase("hit") || choice.equalsIgnoreCase("h") || choice.equalsIgnoreCase("stay")
					|| choice.equalsIgnoreCase("s"))
				temp = true;
			else
				System.out.println("You have entered an invaild command");
		} while (temp == false);
		if (choice.equalsIgnoreCase("hit") || choice.equalsIgnoreCase("h"))
			GameIndex.gameIndex(GameState.PlayerHit);
		else if (choice.equalsIgnoreCase("stay") || choice.equalsIgnoreCase("s"))
			GameIndex.gameIndex(GameState.HostTurn);
	}

	public void addCard(Card card) {
		// This calls the method in the parent.
		player = addCard(card, player);
	}

	@Override
	public void fristTurn() {
		Card newCardOne = getRandomCard();
		Card newCardTwo = getRandomCard();
		addCard(newCardOne);
		addCard(newCardTwo);
		System.out.println("The player has just drew a " + newCardOne.abbreviatedCard() + " , "
				+ newCardTwo.abbreviatedCard() + " leave his total at [" + player.totalStringMessage() + "]");
		if (player.finalScore() != 21)
			GameIndex.gameIndex(GameState.PlayerTurn);
		else
			GameIndex.gameIndex(GameState.HostTurn);
	}
}
