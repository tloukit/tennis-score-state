package scorestates;

import entities.Game;
import entities.Player;

public interface ScoreState {
	
	public Game getGame();
	
	public void pointScored(Player player);
	
	public void stateChange(Player player);

}
