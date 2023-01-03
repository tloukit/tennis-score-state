package scorestates;

import entities.Game;
import entities.Player;
import entities.Set;

public class ScoreStateGameWon implements ScoreState {
	
	private Game game;
	private Set set;
	
	public ScoreStateGameWon(Game game) {
	this.game = game;	
	}
	
	public ScoreStateGameWon(ScoreState scoreState) {
	this.game = scoreState.getGame();
	}

	@Override
	public void pointScored(Player player) {
	int games = player.getGames() + 1;
	player.setGames(games);
	stateChange(player);
	
	}

	@Override
	public void stateChange(Player player) {
		
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	private void incrementGamesInSet() {
		
	}
}
