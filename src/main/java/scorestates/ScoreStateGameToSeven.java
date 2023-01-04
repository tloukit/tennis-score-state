package scorestates;

import entities.Game;
import entities.Player;

public class ScoreStateGameToSeven implements ScoreState{

	private Game game;
	
	public ScoreStateGameToSeven(Game game) {
		this.game = game;
	}
	
	public ScoreStateGameToSeven (ScoreState scoreState) {
		this.game = scoreState.getGame();
	}
	
	@Override
	public Game getGame() {
		return this.game;
	}

	@Override
	public void pointScored(Player player) {
		int games = player.getGames() + 1;
		player.setGames(games);
		stateChange(player);
		
	}

	@Override
	public void stateChange(Player player) {
		if(player.getGames().intValue() == 7) {
			game.resetGamePointsPlayers();
			game.setScoreState(new ScoreStateSetWon(this));
		}
	}

}
