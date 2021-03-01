package Main;
import java.util.LinkedList;

import Cards.GenerateCards;
import Index.GameIndex;
import Index.GameIndex.GameState;
import Model.Card;
import Players.Bettor;
import Players.Host;

public class Main {
	
	/*
	 * Author @Clinton Student Code: 20253060
	 * 
	 * This is the main class, I normally keep the main empty and won't have something like onStart in same class,
	 * but in this example, because this only small project, I decided to keep the 2 in same class.
	 * as it's common practice in bigger projects, for example in string boot you just have the main like so
	 *	SpringApplication.run(Application.class, args); and then you have depencies in the xml etc,
	 */ 
	
	public static void main(String args[]) {
		onStart();
	}
	
	public static void onStart() {
		System.out.println("you can type 'end' at any time to end the game");
		System.out.println("------------------------------------");
		GenerateCards generateCards = new GenerateCards();
		generateCards.setCards();
		GameIndex.gameIndex(GameState.HostFirstTurn);
	}

}
