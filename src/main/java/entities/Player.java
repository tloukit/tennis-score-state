package entities;

public class Player {
	
	private String playerName;
	//private Score score;
	private boolean isAdvantage;
	private Integer games;
	private int points;
	
	public Player(String playerName) {
		this.playerName = playerName;
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
}
