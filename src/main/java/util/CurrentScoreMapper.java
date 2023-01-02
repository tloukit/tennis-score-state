package util;

public class CurrentScoreMapper {
	
	 public String mapScore(int score) {
	        switch (score) {
	            case 0: return "Love";
	            case 1: return "Fifteen";
	            case 2: return "Thirty";
	            case 3: return "Forty";
	            case 4 : return "Win";
	        }
	        throw new IllegalArgumentException("<Score: " + score + ">");
	    }

}
