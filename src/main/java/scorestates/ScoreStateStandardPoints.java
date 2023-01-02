package scorestates;

import entities.Game;
import entities.Player;
import util.ScoreTennis;

public class ScoreStateStandardPoints implements ScoreState{

	private Game game;
	private final static Long SCORE_DELAY = 2000L;
	
	public ScoreStateStandardPoints(Game game) {
		this.game = game;
	}

	@Override
	public void pointScored(Player player) {
		int points = player.getPoints() + 1;
		player.setPoints(points);
		stateChange(player);
		
		try {
			Thread.sleep(SCORE_DELAY);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void stateChange(Player player) {
		// we map the player's points to the tennis score
		if(ScoreTennis.values()[player.getPoints()].equals(ScoreTennis.Win)){
			game.setScoreState(new ScoreStateGameWon(this));
			return;
		}
	}

	@Override
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
