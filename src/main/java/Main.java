import entities.Game;
import entities.Player;
import entities.Set;
import entities.TieBreak;
import scorestates.ScoreState;
import scorestates.ScoreStateGameWon;
import scorestates.ScoreStateSetWon;
import scorestates.ScoreStateStandardPoints;
import scorestates.ScoreStateTieBreak;
import util.ScoreTennis;

public class Main {
	
	public static void main(String[] args) {
		
		Game game = new Game();
		Player[] players = game.getPlayers();
		Player player1 = players[0];
		Player player2 = players[1];
		
		System.out.println("Welcome to the tennis Game: ");
		System.out.println();
		
		TieBreak tieBreak = new TieBreak(game);
		Player[] playersTieBreak = tieBreak.getPlayers();
		Player playerTieBreak1 = playersTieBreak[0];
		Player playerTieBreak2 = playersTieBreak[1];
				
		while(!game.getScoreState().getClass().equals(ScoreStateSetWon.class)  && !tieBreak.getScoreState().getClass().equals(ScoreStateSetWon.class)) {
			
			while(!game.getScoreState().getClass().equals(ScoreStateSetWon.class) && !game.getScoreState().getClass().equals(ScoreStateTieBreak.class)) {
				
				int scoringPlayer = game.chooseScoringPlayer();
				switch(scoringPlayer) 
				{
				case 1:
					game.pointScored(player1);
					break;
					
				case 2:
					game.pointScored(player2);
					break;
					
				default:
					throw new IllegalArgumentException("not a valid value");
				}
			}
				if(game.isTiebreak()) {
					int scoringPlayer = tieBreak.chooseScoringPlayer();
					
					switch(scoringPlayer) 
					{
					case 1:
						tieBreak.pointScored(playerTieBreak1);
						break;
						
					case 2:
						tieBreak.pointScored(playerTieBreak2);
						break;
						
					default:
						throw new IllegalArgumentException("not a valid value");
					}
					
				}
		}
		game.getSet().printFinalSetScore();
	}
	
	

}
