package Players;

import Index.GameIndex;
import Index.GameIndex.GameState;
import Model.Card;

public class Host extends PlayerTurn {

	/*
	 * Author @Clinton Bates Student Code: 20253060 This class handles the AI/dealer
	 * (The host as I am going to refer it as)
	 */

	public Host() {
		super();
	}

	public void addCard(Card card) {
		// This calls the method in the parent.
		host = addCard(card, host);
	}

	public void fristTurn() {
		addCard(getRandomCard());
		// prints out the first card
		System.out.println("The host has drew a " + host.getCurrentCards().get(0).abbreviatedCard());
		GameIndex.gameIndex(GameState.BettorFirstTurn);
	}

	@Override
	public void hit() {
		Card newCard = getRandomCard();
		
		addCard(newCard);
		
		System.out.println(
				"The host has drew a " + newCard.abbreviatedCard() + ", leave his total at [" + host.finalScore() + "]");

		int hostScore = host.finalScore(), playerScore = player.finalScore();

		// if the host busts
		if (hostScore > 21)
			GameIndex.gameIndex(GameState.BettorWin);
		// if the host is less then equals 21 and more then player (Host wins)
		else if (hostScore <= 21 && hostScore > playerScore || hostScore > playerScore && hostScore >= 16)
			GameIndex.gameIndex(GameState.BettorLoss);
		// if the host is less then equals 21 or over 16 and same as the player (Host draw)
		else if (hostScore <= 21 && hostScore == playerScore || hostScore == playerScore && hostScore >= 16)
			GameIndex.gameIndex(GameState.Draw);
		//if the host is over 16 and player has more
		else if (hostScore < playerScore && hostScore >= 16)
			GameIndex.gameIndex(GameState.BettorWin);
		else
			GameIndex.gameIndex(GameState.HostTurn);
	}
}
