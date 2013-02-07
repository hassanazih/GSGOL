package Metier;

import java.awt.Color;

import javax.swing.JButton;


public abstract class Agent extends Thread{

		private int line;
		private int column;
		private int nourriture;
		private Color couleur;
		private Environnement env;
		private boolean enVie;
		/**
		 * @return the enVie
		 */
		public boolean isEnVie() {
			return enVie;
		}

		/**
		 * @param enVie the enVie to set
		 */
		public void setEnVie(boolean enVie) {
			this.enVie = enVie;
		}

		/**
		 * @return the env
		 */
		public Environnement getEnv() {
			return env;
		}

		/**
		 * @param env the env to set
		 */
		public void setEnv(Environnement env) {
			this.env = env;
		}

		/**
		 * @return the couleur
		 */
		public Color getCouleur() {
			return couleur;
		}

		/**
		 * @param couleur the couleur to set
		 */
		public void setCouleur(Color couleur) {
			this.couleur = couleur;
		}

		/**
		 * @return the nourriture
		 */
		public int getNourriture() {
			return nourriture;
		}

		/**
		 * @param nourriture the nourriture to set
		 */
		public void setNourriture(int nourriture) {
			this.nourriture = nourriture;
		}
		private int tempsVie;
		
		/**
		 * @return the tempsVie
		 */
		public int getTempsVie() {
			return tempsVie;
		}

		/**
		 * @param tempsVie the tempsVie to set
		 */
		public void setTempsVie(int tempsVie) {
			this.tempsVie = tempsVie;
		}

		/**
		 * @return the line
		 */
		public int getLine() {
			return line;
		}

		/**
		 * @param line the line to set
		 */
		public void setLine(int line) {
			this.line = line;
		}

		/**
		 * @return the column
		 */
		public int getColumn() {
			return column;
		}

		/**
		 * @param column the column to set
		 */
		public void setColumn(int column) {
			this.column = column;
		}
		
		public Agent(int line,int column,int nourriture,int tempsVie)
		{
			this.tempsVie=tempsVie;
			this.nourriture=nourriture;
			this.line=line;
			this.column=column;
			enVie=true;
		}
		
		//abstract void mourir();
		public abstract void seDeplacer(int line,int column);
		public abstract void seNourrir(int nb);
		public abstract void seDessiner(JButton e);
				
}
