package Metier;

import java.awt.Color;

import javax.swing.JButton;

public class Behaviour extends Agent{

	public Behaviour(int line, int column, int nourriture, int tempsVie) {
		super(line, column, nourriture, tempsVie);
		this.setCouleur(Color.GREEN);
	}

	@Override
	public void seDeplacer(int line, int column) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seNourrir(int nb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seDessiner(JButton e) {
		// TODO Auto-generated method stub
		e.setBackground(this.getCouleur());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	

}
