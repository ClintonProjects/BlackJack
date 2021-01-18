package Model;

public class Card {

	/*
	 * Author @Clinton Bates Student Code: 20253060 This Object is used for the
	 * creation of cards
	 */

	// Example Jack, 7, 4.
	private String faceCardName;
	private int cardValue;
	private String cardSuit;

	public Card(String faceCardName, int cardValue, String cardSuit) {
		this.faceCardName = faceCardName;
		this.cardValue = cardValue;
		this.cardSuit = cardSuit;
	}

	public String getFaceCardName() {
		return faceCardName;
	}

	public void setFaceCardName(String faceCardName) {
		this.faceCardName = faceCardName;
	}

	public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	public String getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(String cardSuit) {
		this.cardSuit = cardSuit;
	}

	public String abbreviatedCard() {
		if (!faceCardName.equalsIgnoreCase("10"))
			return faceCardName + " of " + cardSuit;
		else
			return faceCardName + " of " + cardSuit;
	}

	public void print() {
		System.out.println(faceCardName + " " + cardValue + " " + cardSuit);
	}

}
