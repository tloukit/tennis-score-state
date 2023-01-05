package scorestates;

import entities.Game;
import entities.Player;
import entities.Set;
import entities.TieBreak;

public class ScoreStateGameWon implements ScoreState {
	
	private Game game;
	private TieBreak tieBreak;
	private static final Long SCORE_DELAY = 1000L;
	
	public ScoreStateGameWon(Game game) {
	this.game = game;	
	}
	
	public ScoreStateGameWon(ScoreState scoreState) {
	this.game = scoreState.getGame();
	this.tieBreak = new TieBreak(game);
	}

	@Override
	public void pointScored(Player player) {
		stateChange(player);
		
		try {
			Thread.sleep(SCORE_DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void stateChange(Player player) {
		Player[] players = game.getPlayers();
		int gamesPlayer1 = players[0].getGames();
		int gamesPlayer2 = players[1].getGames();
		
		//If a player reach the Set score of 6 and the other player has a Set score of 4 or lower, the player win the Set
		if( (gamesPlayer1 == 6  && gamesPlayer2 <= 4) || (gamesPlayer2 == 6  && gamesPlayer1 <= 4) ) {
			setWinner(gamesPlayer1, gamesPlayer2, players);
			setEndOfSet(game);
			
			game.setScoreState(new ScoreStateSetWon(this));
		}
		//If a player wins a Game and reach the Set score of 6 
		//and the other player has a Set score of 5, a new Game must be played and the first player who reach the score of 7 wins the match
		else if( (gamesPlayer1 == 6  && gamesPlayer2 == 5) || (gamesPlayer2 == 6  && gamesPlayer1 == 5) ) {
				game.resetGamePointsPlayers();
				game.setScoreState(new ScoreStateStandardPoints(game));
		}
		// when a player reaches 7 games he wins the set
		else if( (gamesPlayer1 == 7 && players[0].getGames() - players[1].getGames() == 2) 
						|| (gamesPlayer2 == 7) && players[1].getGames() - players[0].getGames() == 2){
			setWinner(gamesPlayer1, gamesPlayer2, players);
			setEndOfSet(game);
			game.setScoreState(new ScoreStateSetWon(this));
		}
		// 6 games to 6 leads to Tie break rule
		else if(gamesPlayer1 == 6  && gamesPlayer2 == 6) {
			game.resetGamePointsPlayers();
			game.setTiebreak(true);
			game.setScoreState(new ScoreStateTieBreak(this));
		}
		// regular games while set is not over	
		else {
			game.resetGamePointsPlayers();
			game.setScoreState(new ScoreStateStandardPoints(game));
		}
	}

	private void setEndOfSet(Game game) {
		game.resetGamePointsPlayers();
		game.getSet().setEndOfSet(true);
		
	}
	private void setWinner(int gamesPlayer1, int gamesPLayer2, Player[] players) {
		if(gamesPlayer1 == 6 || gamesPlayer1 == 7) {
			players[0].setSetWinner(true);
		}
		else {
			players[1].setSetWinner(true);
		}
	}
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public TieBreak getTieBreak() {
		return this.tieBreak;
	}
}
