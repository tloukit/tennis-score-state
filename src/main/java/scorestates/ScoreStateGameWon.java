package scorestates;

import entities.Game;
import entities.Player;
import entities.Set;
import entities.TieBreak;

public class ScoreStateGameWon implements ScoreState {
	
	private Game game;
	private Set set;
	private static final Long SCORE_DELAY = 1000L;
	
	public ScoreStateGameWon(Game game) {
	this.game = game;	
	}
	
	public ScoreStateGameWon(ScoreState scoreState) {
	this.game = scoreState.getGame();
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
			player.setSetWinner(true);
			setEndOfSet(game);
			game.setScoreState(new ScoreStateSetWon(this));
		}
		//If a player wins a Game and reach the Set score of 6 
		//and the other player has a Set score of 5, a new Game must be played and the first player who reach the score of 7 wins the match
		else if( (gamesPlayer1 == 6  && gamesPlayer2 == 5) || (gamesPlayer2 == 6  && gamesPlayer1 == 5) ) {
				game.resetGamePointsPlayers();
				game.setScoreState(new ScoreStateStandardPoints(game));
		}
		else if( (gamesPlayer1 == 7 && players[0].getGames() - players[1].getGames() == 2) 
						|| (gamesPlayer2 == 7) && players[1].getGames() - players[0].getGames() == 2){
			player.setSetWinner(true);
			setEndOfSet(game);
			game.setScoreState(new ScoreStateSetWon(this));
		}
		else if(gamesPlayer1 == 6  && gamesPlayer2 == 6) {
			game.resetGamePointsPlayers();
			game.setScoreState(new ScoreStateTieBreak(this));
		}
		else {
			game.resetGamePointsPlayers();
			game.setScoreState(new ScoreStateStandardPoints(game));
		}
	}

	private void setEndOfSet(Game game) {
		game.resetGamePointsPlayers();
		game.getSet().setEndOfSet(true);
		
	}
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
