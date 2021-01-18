package Index;

import Bettorturn.Bettor;
import Bettorturn.Host;
import Bettorturn.PlayerTurn;
import Model.Wallet;

public class GameIndex {

	/*
	 * Author @Clinton Bates Student Code: 20253060 This is an index, the code will
	 * always push back to the index for each phase of the game, sort of like
	 * recursion method.
	 */

	public enum GameState {
		BettorWin, BettorFirstTurn, HostFirstTurn, PlayerTurn, PlayerHit, PlayerStay, HostTurn, BettorLoss, Draw
	}

	private static Wallet Wallet = new Wallet();
	private static Host host = new Host();
	private static Bettor bettor = new Bettor();

	public static void gameIndex(GameState currentPlayerState) {
		switch (currentPlayerState) {
		case BettorWin:
			Wallet.addWin();
			System.out.println("The player has won!");
			resetGame();
			break;
		case PlayerTurn:
			bettor.playerChoice();
			break;
		case BettorFirstTurn:
			bettor.fristTurn();
			break;
		case HostFirstTurn:
			host.fristTurn();
			break;
		case PlayerHit:
			bettor.hit();
			break;
		case HostTurn:
			host.hit();
			break;
		case BettorLoss:
			Wallet.addLoss();
			System.out.println("The player has loss");
			resetGame();
			break;
		case Draw:
			Wallet.addDraws();
			System.out.println("The game has ended in an draw");
			resetGame();
			break;
		default:
			System.out.println("The game has broke. :(");
			break;
		}
	}

	public static void resetGame() {
		host = new Host();
		bettor = new Bettor();
		Wallet.print();
		PlayerTurn.reset();
		gameIndex(GameState.HostFirstTurn);
	}

}
