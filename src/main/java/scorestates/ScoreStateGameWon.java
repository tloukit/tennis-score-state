package scorestates;

import entities.Game;
import entities.Player;

public class ScoreStateGameWon implements ScoreState {
	
	private Game game;
	
public ScoreStateGameWon(Game game) {
	this.game = game;	
	}
	
	public ScoreStateGameWon(ScoreState scoreState) {
	this.game = scoreState.getGame();
	}

	@Override
	public void pointScored(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChange(Player player) {
		// TODO Auto-generated method stub
		
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
