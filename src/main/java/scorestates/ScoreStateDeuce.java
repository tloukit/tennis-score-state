package scorestates;

import entities.Game;
import entities.Player;

public class ScoreStateDeuce implements ScoreState{
	
	private Game game;
	
	public ScoreStateDeuce(Game game) {
		this.game = game;
	}
	
	public ScoreStateDeuce (ScoreState scoreState) {
		this.game = scoreState.getGame();
	}
	
	@Override
	public Game getGame() {
		return this.game;
	}

	@Override
	public void pointScored(Player player) {
		Player[] players = game.getPlayers();
		if(player.equals(players[0])) {
			players[0].setAdvantage(true);
			players[1].setAdvantage(false);
		}
		else {
			players[1].setAdvantage(true);
			players[0].setAdvantage(false);
		}
		stateChange(player);
	}

	@Override
	public void stateChange(Player player) {
		game.setDeuce(false);
		game.setScoreState(new ScoreStateAdvantage(this));
	}

}
