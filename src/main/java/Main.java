import entities.Game;
import entities.Player;
import scorestates.ScoreState;
import scorestates.ScoreStateGameWon;
import scorestates.ScoreStateStandardPoints;
import util.ScoreTennis;

public class Main {
	
	public static void main(String[] args) {
		
		Game game = new Game();
		Player[] players = game.getPlayers();
		Player player1 = players[0];
		Player player2 = players[1];
		
		System.out.println("Welcome to the tennis Game: ");
		
		 //System.out.println(game.getScoreState().getClass().equals(ScoreStateGameWon.class));
		while(!game.getScoreState().getClass().equals(ScoreStateGameWon.class)) {
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
		Player gameWinner = ScoreTennis.values()[player1.getPoints()].equals(ScoreTennis.Win)? player1 : player2;
		System.out.println( gameWinner.getPlayerName() + "Game Won the game");
	}
	
	

}
