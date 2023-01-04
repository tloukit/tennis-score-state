package scorestates;

import entities.Game;
import entities.Player;
import entities.TieBreak;

public class ScoreStateSetWon implements ScoreState{
	private Game game;
	
	public ScoreStateSetWon(ScoreState scoreState) {
		this.game = scoreState.getGame();
		}
	
	@Override
	public Game getGame() {
		return this.game;
	}

	@Override
	public void pointScored(Player player) {
		return;
	}

	@Override
	public void stateChange(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TieBreak getTieBreak() {
		// TODO Auto-generated method stub
		return null;
	}

}
