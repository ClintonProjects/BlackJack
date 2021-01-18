package Bettorturn;

import java.util.LinkedList;
import java.util.Random;

import Cards.GenerateCards;
import Model.Card;
import Model.PlayerScore;

public abstract class PlayerTurn {

	/*
	 * Author @Clinton Bates Student Code: 20253060
	 * 
	 * This is the player actions.
	 */

	// This will parent the host/dealer and player.
	static PlayerScore host = new PlayerScore(), player = new PlayerScore();
	protected PlayerScore temp = new PlayerScore();

	// gets a random cards.
	public Card getRandomCard() {
		Random rand = new Random();
		int n = rand.nextInt(GenerateCards.allCards.size() - 1);
		return GenerateCards.allCards.get(n);
	}

	// adds cards to the player.
	protected PlayerScore addCard(Card card, PlayerScore temp) {
		LinkedList<Card> currentCards = temp.getCurrentCards();
		currentCards.add(card);
		temp.setCurrentCards(currentCards);
		return temp;
	}

	// both player have first turn that differnt from there other turns,
	// for example hot only hits once
	public abstract void fristTurn();

	// both players need to hit but there hits work differntly
	// (player can't hit past 21, but host has to stop/go till 16)
	public abstract void hit();
	
	//resets the game.
	public static void reset() {
		host = new PlayerScore();
		player = new PlayerScore();
	}

}
