package scorestates;

import entities.Game;
import entities.Player;
import entities.TieBreak;

public interface ScoreState {
	
	public Game getGame();
	
	public TieBreak getTieBreak();
	
	public void pointScored(Player player);
	
	public void stateChange(Player player);
	
}
