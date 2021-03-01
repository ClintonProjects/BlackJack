package Model;

import java.util.LinkedList;

public class PlayerScore {

	/*
	 * Author @Clinton Student Code: 20253060 This Object is used for the
	 * creation of cards
	 */

	private LinkedList<Card> currentCards;

	public PlayerScore() {
		// Constructor
		currentCards = new LinkedList<Card>();
	}

	public void setCurrentCards(LinkedList<Card> currentCards) {
		this.currentCards = currentCards;
	}

	public LinkedList<Card> getCurrentCards() {
		return currentCards;
	}

	private int getCardScorePreAce() {
// 		Java 7
//		int totalOfCards = 0;
//		for (Card card : currentCards) {
//			totalOfCards += card.getCardValue();
//		}
//		return totalOfCards;
		// Java 8
		return currentCards.stream().mapToInt(i -> i.getCardValue()).sum();
	}

	public int finalScore() {
		// This method will return the score of the player
		if (getCardsContainsAce() && getCardScorePreAce() + 10 <= 21)
			return getCardScorePreAce() + 10;
		else
			return getCardScorePreAce();
	}
	
	public boolean getCardsContainsAce() {
		// Java 7
		// for (Card card : currentCards) {
		// if (card.getFaceCardName().equalsIgnoreCase("ace"))
		// return true;
		// }
		// return false;
		// Java 8
		return currentCards.stream().anyMatch(i -> i.getFaceCardName().equalsIgnoreCase("ace"));
	}

	public String totalStringMessage() {
		//return the ace value in string format:
		if (getCardsContainsAce())
			return String.valueOf(getCardScorePreAce()) + "/" + String.valueOf(getCardScorePreAce() + 10);
		else
			return String.valueOf(getCardScorePreAce());
	}

}
