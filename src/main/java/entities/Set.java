package entities;

import scorestates.ScoreState;

public class Set {
	private Player[] players;
	private Integer[][] scoreInSets;
	private Integer currentSetNumber;
	private ScoreState scoreState;
	private Game game;
	private boolean isEndOfSet;
	
	public Set(Game game) {
		// initialize the tennis set format. Possibly 3 sets match with 3 values in each set 
		// => eg. : [ [6-3], [3-6] , [7-6] ]; or [ [6-3], [6-4] , [null-null] ];
		this.currentSetNumber = 1;
		this.game = game;
		this.isEndOfSet = false;
	}
	public void gamesScored(Player player) {
		this.scoreState.pointScored(player);
		//displayScore();
	}
	
	
	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
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
	public String printScoreInCurrentSet() {
		StringBuilder sb = new StringBuilder();
		//sb.append(printCurrentSet());
		players = game.getPlayers();
		Player player1 = players[0];
		Player player2 = players[1];
		sb.append( player1.getPlayerName() + " " + player1.getGames() + " - " + player2.getPlayerName()  + " " + player2.getGames());
		
		return sb.toString();
	}
	
	private String printCurrentSet() {
		switch (this.currentSetNumber) {
			case 1 : return "1st set:  ";
			default:
				return "";
		}
		
	}

}
