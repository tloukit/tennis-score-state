package scorestates;

import entities.Game;
import entities.Player;
import entities.TieBreak;
import util.Score;
import util.ScoreTennisPoints;

public class ScoreStateStandardPoints implements ScoreState{

	private Game game;
	
	public ScoreStateStandardPoints(Game game) {
		this.game = game;
	}

	@Override
	public void pointScored(Player player) {
		int points = player.getPoints() + Score.ONE;
		player.setPoints(points);
		stateChange(player);
	}
	
	@Override
	public void stateChange(Player player) {
		// we map the player's points to the tennis score
		if(ScoreTennisPoints.values()[player.getPoints()].equals(ScoreTennisPoints.Win)){
			int games = player.getGames() + Score.ONE;
			player.setGames(games);
			player.setGameWinner(true);
			game.setScoreState(new ScoreStateGameWon(this));
		}
		
		Player[] players = game.getPlayers();
		Player player1 = players[0];
		Player player2 = players[1];
		
		if(ScoreTennisPoints.values()[player1.getPoints()].equals(ScoreTennisPoints.Forty) 
					&& ScoreTennisPoints.values()[player2.getPoints()].equals(ScoreTennisPoints.Forty)) {
			game.setDeuce(true);
			game.setScoreState(new ScoreStateDeuce(this));
		}
	}

	@Override
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public TieBreak getTieBreak() {
		// TODO Auto-generated method stub
		return null;
	}

}
