package entities;

import scorestates.ScoreState;
import scorestates.ScoreStateTieBreak;

public class TieBreak {

	private ScoreState scoreState;
	
	private Integer points;
	private Player player1;
	private Player player2;
	private Player[] players;
	private Player tieBreakWinner;
	private Game game;
	
	private static final double HALF_A_SECOND = 0.5;
	private static final int PLAYER_1 = 1;
	private static final int PLAYER_2 = 2;
	
	public TieBreak(Game game) {
		this.game = game;
		this.scoreState = new ScoreStateTieBreak(this);
		this.players = new Player[] {game.getPlayers()[0], game.getPlayers()[1]};
	}
	
	public void pointScored(Player player) {
		this.scoreState.pointScored(player);
		displayScore();
	}
	
	public void displayScore() {
		System.out.println("Tie Break : " + players[0].getPlayerName() + " "+ players[0].getPoints());
		System.out.println("Tie Break : " + players[1].getPlayerName() + " "+ players[1].getPoints());
		
	}
	
	
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public Player getTieBreakWinner() {
		return tieBreakWinner;
	}
	public void setTieBreakWinner(Player tieBreakWinner) {
		this.tieBreakWinner = tieBreakWinner;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public ScoreState getScoreState() {
		return scoreState;
	}

	public void setScoreState(ScoreState scoreState) {
		this.scoreState = scoreState;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public int chooseScoringPlayer() {
		return(Math.random() < HALF_A_SECOND ?  PLAYER_1 : PLAYER_2);
	}
}
