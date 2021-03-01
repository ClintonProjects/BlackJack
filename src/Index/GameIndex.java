package Index;

import Model.WinLoss;
import Players.Bettor;
import Players.Host;
import Players.PlayerTurn;

public class GameIndex {

	/*
	 * Author @Clinton Student Code: 20253060 This is an index, the code will
	 * always push back to the index for each phase of the game, sort of like
	 * recursion method.
	 */

	public enum GameState {
		BettorWin, BettorFirstTurn, HostFirstTurn, PlayerTurn, PlayerHit, PlayerStay, HostTurn, BettorLoss, Draw
	}

	//All Objects
	private static WinLoss winLoss = new WinLoss();
	private static Host host = new Host();
	private static Bettor bettor = new Bettor();

	//the index which is decided by switch statement using enums to declare the section 
	public static void gameIndex(GameState currentPlayerState) {
		switch (currentPlayerState) {
		case BettorWin:
			winLoss.addWin();
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
			winLoss.addLoss();
			System.out.println("The player has loss");
			resetGame();
			break;
		case Draw:
			winLoss.addDraws();
			System.out.println("The game has ended in an draw");
			resetGame();
			break;
		default:
			System.out.println("The game has broke. :(");
			break;
		}
	}

	// reset the 
	public static void resetGame() {
		host = new Host();
		bettor = new Bettor();
		winLoss.print();
		PlayerTurn.reset();
		gameIndex(GameState.HostFirstTurn);
	}

}
