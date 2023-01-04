import entities.Game;
import entities.Player;
import entities.Set;
import scorestates.ScoreState;
import scorestates.ScoreStateGameWon;
import scorestates.ScoreStateSetWon;
import scorestates.ScoreStateStandardPoints;
import util.ScoreTennis;

public class Main {
	
	public static void main(String[] args) {
		
		Game game = new Game();
		//Set scoreInSets = new Set(game);
		Player[] players = game.getPlayers();
		Player player1 = players[0];
		Player player2 = players[1];
		
		System.out.println("Welcome to the tennis Game: ");
		System.out.println();
		
				
		while(!game.getScoreState().getClass().equals(ScoreStateSetWon.class)) {
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
		
		Player gameWinner = player1.isGameWinner() ? player1 : player2;
		System.out.println();
		//System.out.println( gameWinner.getPlayerName() + " Won the game");
		//System.out.println("Current score in the "  + scoreInSets.printScoreInCurrentSet());
	}
	
	

}
