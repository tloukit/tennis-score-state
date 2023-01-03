package entities;


import scorestates.ScoreState;
import scorestates.ScoreStateStandardPoints;
import util.ScoreTennis;

public class Game {

	private Player[] players;
	private ScoreState scoreState;
	private Set set;
	
	private static final double HALF_A_SECOND = 0.5;
	private static final int PLAYER_1 = 1;
	private static final int PLAYER_2 = 2;
	
	
	public Game() {
		players = new Player[] {new Player("Djokovic"), new Player("Loukit")};
		players[0].setGames(0);
		players[1].setGames(0);
		scoreState = new ScoreStateStandardPoints(this);
	}
	
	public void pointScored(Player player) {
		this.scoreState.pointScored(player);
		displayScore();
	}
	
	public void displayScore() {
		// retrieve the player points and map it/them  with the tennis score
		String player1Score =  ScoreTennis.values()[players[0].getPoints()].toString();
		String player2Score =  ScoreTennis.values()[players[1].getPoints()].toString();
		System.out.println(players[0].getPlayerName() + " " + player1Score + " " + players[1].getPlayerName() + " " + player2Score);
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public ScoreState getScoreState() {
		return scoreState;
	}

	public void setScoreState(ScoreState scoreState) {
		this.scoreState = scoreState;
	}
	
	public int chooseScoringPlayer() {
		return(Math.random() < HALF_A_SECOND ?  PLAYER_1 : PLAYER_2);
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}
}
