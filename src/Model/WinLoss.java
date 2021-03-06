package Model;

public class WinLoss {
	
	/*
	 * Author @Clinton Student Code: 20253060 This Object is used for the
	 * This class simply stores the players win and loss's
	 */

	private int wins;
	private int draws;
	private int loss;

	public WinLoss() {
		this.wins = 0;
		this.draws = 0;
		this.loss = 0;
	}

	public int getWins() {
		return wins;
	}

	public void addWin() {
		wins += 1;
	}

	public int getDraws() {
		return draws;
	}

	public void addDraws() {
		draws += 1;
	}

	public int getLoss() {
		return loss;
	}

	public void addLoss() {
		loss += 1;
	}

	public double radio() {
		int games = wins + loss + draws;
		return 100.0 * wins / games;
	}

	public void print() {
		System.out.println("------------------------------------");
		System.out.println("W" + getWins() + "-D" + getDraws() + "-L" + getLoss() + " / Win %: "
				+ String.format("%.2f", radio()) + "%");
		System.out.println("------------------------------------");
	}

}
