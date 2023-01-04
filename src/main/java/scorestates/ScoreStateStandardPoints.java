package scorestates;

import entities.Game;
import entities.Player;
import util.ScoreTennis;

public class ScoreStateStandardPoints implements ScoreState{

	private Game game;
	private final static Long SCORE_DELAY = 1000L;
	
	public ScoreStateStandardPoints(Game game) {
		this.game = game;
	}

	@Override
	public void pointScored(Player player) {
		int points = player.getPoints() + 1;
		player.setPoints(points);
		stateChange(player);
	}
	
	@Override
	public void stateChange(Player player) {
		// we map the player's points to the tennis score
		if(ScoreTennis.values()[player.getPoints()].equals(ScoreTennis.Win)){
			int games = player.getGames() + 1;
			player.setGames(games);
			player.setGameWinner(true);
			game.setScoreState(new ScoreStateGameWon(this));
		}
		
		Player[] players = game.getPlayers();
		Player player1 = players[0];
		Player player2 = players[1];
		
		if(ScoreTennis.values()[player1.getPoints()].equals(ScoreTennis.Forty) && ScoreTennis.values()[player2.getPoints()].equals(ScoreTennis.Forty)) {
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

}
