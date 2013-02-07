import javax.swing.UnsupportedLookAndFeelException;

import Vue.GUI;


public class Main {

	/**
	 * @param args
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ClassNotFoundException {
		int dim=70;//Integer.parseInt(JOptionPane.showInputDialog("Veuillez saisir la dimension de la grille"));
		GUI graphic=new GUI(dim,dim);
		graphic.setVisible(true);
	}

}
