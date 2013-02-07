package Modeles;

public class InfoTable {
	
	private int numGen;
	private int nbPredateurs;
	private int nbProies;
	private float tempsCalcul;
	
	public InfoTable(int numGen, int nbPredateurs, int nbProies , float tempsCalcul) {
		super();
		this.numGen = numGen;
		this.nbProies=nbProies;
		this.nbPredateurs=nbPredateurs;
		this.tempsCalcul = tempsCalcul;
	}

	/**
	 * @return the numGen
	 */
	public int getNumGen() {
		return numGen;
	}

	/**
	 * @param numGen the numGen to set
	 */
	public void setNumGen(int numGen) {
		this.numGen = numGen;
	}

		/**
	 * @return the tempsCalcul
	 */
	public float getTempsCalcul() {
		return tempsCalcul;
	}

	/**
	 * @param tempsCalcul the tempsCalcul to set
	 */
	public void setTempsCalcul(float tempsCalcul) {
		this.tempsCalcul = tempsCalcul;
	}

	public int getNbPredateurs() {
		// TODO Auto-generated method stub
		return nbPredateurs;
	}

	public int getNbProies() {
		// TODO Auto-generated method stub
		return nbProies;
	}
	
	
}	
