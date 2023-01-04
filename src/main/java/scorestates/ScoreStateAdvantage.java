package scorestates;

import entities.Game;
import entities.Player;

public class ScoreStateAdvantage implements  ScoreState{

	private Game game;
	private boolean isGameWon;
	
	public ScoreStateAdvantage(Game game) {
		this.game = game;
	}
	
	public ScoreStateAdvantage (ScoreState scoreState) {
		this.game = scoreState.getGame();
	}
	
	@Override
	public Game getGame() {
		// TODO Auto-generated method stub
		return this.game;
	}

	@Override
	public void pointScored(Player player) {	
		//Player[] players = game.getPlayers();
		// case when the player who has just scored a point and had already the "advantage"
		if(player.isAdvantage()) {
			int games = player.getGames() + 1;
			player.setGames(games);
			player.setGameWinner(true);
			stateChange(player);
		}
		else {
			stateChange(player);
		}
	}

	@Override
	public void stateChange(Player player) {
		Player[] players = game.getPlayers();
		players[0].setAdvantage(false);
		players[1].setAdvantage(false);
		if(player.isGameWinner()) {
			game.setScoreState(new ScoreStateGameWon(this));
		}
		else {
		game.setDeuce(true);
			game.setScoreState(new ScoreStateDeuce(this));
			
		}
	}

	public boolean isGameWon() {
		return isGameWon;
	}

	public void setGameWon(boolean isGameWon) {
		this.isGameWon = isGameWon;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
