package entities;

import scorestates.ScoreState;

public class Set {
	private Player[] players;
	private Player player1;
	private Player player2;
	private Integer currentSetNumber;
	private ScoreState scoreState;
	private Game game;
	private boolean isEndOfSet;
	private Integer finalSetScore;
	
	public Set(Game game) {
		this.game = game;
		this.isEndOfSet = false;
		this.players = game.getPlayers();
		player1 = this.players[0];
		player2 = this.players[1];
		
	}
	public void gamesScored(Player player) {
		this.scoreState.pointScored(player);
	}
	
	
	public Player[] getPlayers() {
		return players;
	}
	public Player getPlayer1() {
		return player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public int getCurrentSetNumber() {
		return currentSetNumber;
	}

	public void setCurrentSetNumber(int currentSetNumber) {
		this.currentSetNumber = currentSetNumber;
	}
	
	public ScoreState getScoreState() {
		return scoreState;
	}
	public void setScoreState(ScoreState scoreState) {
		this.scoreState = scoreState;
	}
	
	public boolean isEndOfSet() {
		return isEndOfSet;
	}
	public void setEndOfSet(boolean isEndOfSet) {
		this.isEndOfSet = isEndOfSet;
	}
	
	public Integer getFinalSetScore() {
		return finalSetScore;
	}
	
	public void setFinalSetScore(Integer finalSetScore) {
		this.finalSetScore = finalSetScore;
	}
	
	public void printScoreInCurrentSet() {
		System.out.println("             " + player1.getPlayerName() + " " + player1.getGames() + " - " + player2.getPlayerName()  + " " + player2.getGames());
	}
	
	public void printFinalSetScore() {
		System.out.println();
		if(game.isTiebreak()) {
			System.out.println(player1.isTieBreakWinner() ? player1.getPlayerName() + " wins the tie break and the set 7 - 6" : player2.getPlayerName() + " wins the tie break and the set 7 - 6");
		}
		else if(this.isEndOfSet()) {
			System.out.println(player1.isSetWinner() ? player1.getPlayerName() + " wins the set " : player2.getPlayerName() + " wins the set ");
			System.out.println("Final set score is : "  + player1.getGames().toString() + " - " + player2.getGames().toString());
		}
	}

}
