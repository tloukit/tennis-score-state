package scorestates;

import entities.Game;
import entities.Player;
import entities.TieBreak;
import util.Score;

public class ScoreStateTieBreak implements ScoreState{
	private Game game;
	private TieBreak tieBreak;


	public ScoreStateTieBreak(TieBreak tieBreak) {
		this.tieBreak = tieBreak;
	}
	
	public ScoreStateTieBreak (ScoreState scoreState) {
		game = scoreState.getGame();
		return;
	}
	

	@Override
	public void pointScored(Player player) {
		int points = player.getPoints() + Score.ONE;
		player.setPoints(points);
		stateChange(player);
	}

	@Override
	public void stateChange(Player player) {
		Player[] players = tieBreak.getPlayers();
		Player player1 = players[0];
		Player player2 = players[1];
		
		if(player1.equals(player) && player.getPoints() >= Score.SEVEN 
				&& player1.getPoints() - player2.getPoints() >= Score.TWO) {
			
				tieBreak.getPlayers()[0].setTieBreakWinner(true);
				tieBreak.setScoreState(new ScoreStateSetWon(this));
		}
		else if(player2.getPoints() >= Score.SEVEN && player2.getPoints() - player1.getPoints() >= Score.TWO){
			
				tieBreak.getPlayers()[1].setTieBreakWinner(true);
				tieBreak.setScoreState(new ScoreStateSetWon(this));
		}
		else {
				tieBreak.setScoreState(new ScoreStateTieBreak(tieBreak));
		}
	}

	@Override
	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	@Override
	public TieBreak getTieBreak() {
		return tieBreak;
	}
}
