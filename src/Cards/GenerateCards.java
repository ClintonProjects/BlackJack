package Cards;

import java.util.LinkedList;

import Model.Card;

public class GenerateCards {

	/*
	 * Author @Clinton Bates Student Code: 20253060
	 * 
	 * This Class/Object is used to generates cards.
	 */

	public static LinkedList<Card> allCards = null;

	// This method is used to set all the cards to list (only called once per
	// program load)
	public void setCards() {
		LinkedList<Card> allCards = new LinkedList<Card>();
		String[] List = { "Diamands", "Heart", "Spade", "Clubs" }, faceCards = { "Jack", "Queen", "King", "Ace" };
		Card card;

		// for loop with all the suits
		for (String cardSuit : List)
			// for loop to add all the cards from 2-10, then all face cards example jack
			for (int i = 2; i <= 13; i++) {
				if (i > 10)
					// Adds face cards, Jack,Queen,King, Ace.
					card = new Card(faceCards[i - 11], 10, cardSuit);
				else
					// Adds normal cards (1-10)
					card = new Card(String.valueOf(i), i, cardSuit);
				allCards.add(card);
			}

		for (int i = 0; i <= 3; i++) {
			card = new Card("Ace", 1, faceCards[3]);
			allCards.add(card);
		}
		
		// fixes the face value / The 1 and 11 will be handled later.
		allCards.get(allCards.size() - 1).setCardValue(1);
		GenerateCards.allCards = allCards;
	}

	public void print() {
		// Prints all the cards
		//Java 8:
		allCards.forEach(i -> System.out.print(i.abbreviatedCard() + ","));
		//Java 7:
		//for (Card card : allCards) {
		//System.out.print(card.abbreviatedCard() + ",");
		//}
	}

	
}
