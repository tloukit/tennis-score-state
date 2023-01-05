package entities;

import util.Score;

public class Player {
	
	private String playerName;
	private int points;
	private boolean isAdvantage;
	private Integer games;
	private boolean isGameWinner;
	private boolean isTieBreakWinner;
	private boolean isSetWinner;
	
	public Player(String playerName) {
		this.playerName = playerName;
		this.points = Score.ZERO;
		this.isAdvantage = false;
		this.games = Score.ZERO;
		this.isGameWinner = false;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public boolean isAdvantage() {
		return isAdvantage;
	}

	public void setAdvantage(boolean isAdvantage) {
		this.isAdvantage = isAdvantage;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Integer getGames() {
		return games;
	}

	public void setGames(Integer games) {
		this.games = games;
	}
	
	public Integer printGames() {
		return this.games;
	}

	public boolean isGameWinner() {
		return isGameWinner;
	}

	public void setGameWinner(boolean isGameWinner) {
		this.isGameWinner = isGameWinner;
	}

	public boolean isTieBreakWinner() {
		return isTieBreakWinner;
	}

	public void setTieBreakWinner(boolean isTieBreakWinner) {
		this.isTieBreakWinner = isTieBreakWinner;
	}

	public boolean isSetWinner() {
		return isSetWinner;
	}

	public void setSetWinner(boolean isSetWinner) {
		this.isSetWinner = isSetWinner;
	}
	
	@Override
	public String toString() {
		return this.playerName;
	}
	
}
