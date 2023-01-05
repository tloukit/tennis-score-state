package util;

public enum ScoreTennisPoints {

	Love(0), Fifteen(1), Thirty(2), Forty(3), Win(4);
	
	  private final int valeur;

	  private ScoreTennisPoints(int valeur) {
	    this.valeur = valeur;
	  }

	  public int getValeur() {
	    return this.valeur;
	  }
}
