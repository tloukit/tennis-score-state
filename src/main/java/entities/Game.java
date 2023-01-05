package entities;


import scorestates.ScoreState;
import scorestates.ScoreStateStandardPoints;
import scorestates.ScoreStateTieBreak;
import util.ScoreTennisPoints;

public class Game {

	private Player[] players;
	private ScoreState scoreState;
	private Set set;
	
	private static final double HALF_A_SECOND = 0.5;
	private static final int PLAYER_1 = 1;
	private static final int PLAYER_2 = 2;
	public static final String DEUCE = "Deuce";
	private boolean isDeuce;
	private boolean isTiebreak;
	
	
	public Game() {
		players = new Player[] {new Player("Djokovic"), new Player("Loukit")};
		scoreState = new ScoreStateStandardPoints(this);
		this.isDeuce = false;
		this.set = new Set(this);
		this.isTiebreak = false;
	}
	
	public void pointScored(Player player) {
		this.scoreState.pointScored(player);
		displayScore();
	}
	
	public void displayScore() {
		// retrieve the player points and map it/them  with the tennis score
		Player player1 = players[0];
		Player player2 = players[1];
		
		if(!this.scoreState.getClass().equals(ScoreStateTieBreak.class)) {
			
			// case: 40/40 called Deuce
			if(isDeuce) {
				System.out.println(DEUCE);
			}
			// case: when one of both players has Advantage
			else if(player1.isAdvantage() || player2.isAdvantage()) {
				String playerAdvantage = player1.isAdvantage() ? "Advantage " + player1.toString() : "Advantage " + player2.toString();
				System.out.println(playerAdvantage);
			}
			// case: regular points  
			else if(!players[0].isGameWinner() && !players[1].isGameWinner() && !this.set.isEndOfSet()){
				String player1Score =  ScoreTennisPoints.values()[player1.getPoints()].toString();
				String player2Score =  ScoreTennisPoints.values()[player2.getPoints()].toString();
				System.out.println(players[0].toString() + " " + player1Score + " " + players[1].toString() + " " + player2Score);
			}
			//case : player wins a game but not the set
			else if(players[0].isGameWinner() || players[1].isGameWinner() && !this.set.isEndOfSet()) {
				this.set.printScoreInCurrentSet();
				System.out.println();
				this.players[0].setGameWinner(false);
				this.players[1].setGameWinner(false);
				
			}
		}
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
	
	public boolean isDeuce() {
		return isDeuce;
	}

	public void setDeuce(boolean isDeuce) {
		this.isDeuce = isDeuce;
	}

	public int chooseScoringPlayer() {
		return(Math.random() < HALF_A_SECOND ?  PLAYER_1 : PLAYER_2);
	}
	
	public void resetGamePointsPlayers() {
	this.players[0].setPoints(0);
	this.players[1].setPoints(0);
	}
	
	public boolean isTiebreak() {
		return isTiebreak;
	}

	public void setTiebreak(boolean isTiebreak) {
		this.isTiebreak = isTiebreak;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}
}
