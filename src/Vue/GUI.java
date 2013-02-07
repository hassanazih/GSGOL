package Vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

import Controlleurs.GridActionListener;
import Metier.Rules;
import Metier.Predateur;
import Modeles.GenerationsTable;


public class GUI extends JFrame{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel gridPanel;
	private JPanel btnPanel;
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnTemp;
	private JButton btnGenAleatoire;
	private JLabel lblCycles;
	private static JTextField txtCycles;
	private JMenuBar menuBar;
	private JMenu menu;
	private JLabel lblLog;
	private JPanel panelNbCycles;
	private JPanel panelLog;
	private JPanel panelTemp;
	private JPanel panelChart;
	private JScrollPane scrollTable;
	private JTable tableGenerations;
	private Chart chart;
	private static ArrayList<JButton> btnList;
	private static Rules theGame;
	private static int rows;
	private static int cols;
	
	/**
	 * @return the tableGenerations
	 */
	public JTable getTableGenerations() {
		return tableGenerations;
	}


	/**
	 * @param tableGenerations the tableGenerations to set
	 */
	public void setTableGenerations(JTable tableGenerations) {
		this.tableGenerations = tableGenerations;
	}


	
	
	
	public GUI(int inRows,int inCols) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		
		setDefaultLookAndFeelDecorated(true);
		rows=inRows;
		cols=inCols;
		menuBar=new JMenuBar();
		scrollTable=new JScrollPane();
		panelLog=new JPanel();
		panelTemp=new JPanel();
		panelChart=new JPanel();

		tableGenerations=new JTable(new GenerationsTable());
		
		tableGenerations.setMaximumSize(new Dimension(700, 100));
	    scrollTable.setViewportView(tableGenerations);
	    scrollTable.setMaximumSize(new Dimension(700, 100));
		
		
		panelNbCycles=new JPanel();
			
		menu=new JMenu("Fichier");
		menuBar.add(menu);
		
		menu=new JMenu("Structures");
		menuBar.add(menu);
		
		menu=new JMenu("Options");
		menuBar.add(menu);
		
		menu=new JMenu("Aide");
		menuBar.add(menu);
		
		lblLog=new JLabel("Log de générations");
		txtCycles=new JTextField(10);
		lblCycles=new JLabel("Nombre de cycles : ");

		btnList=new ArrayList<JButton>();
		theGame=new Rules(rows, cols,this);
		gridPanel=new JPanel(new GridLayout(rows, cols));
		btnPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnStart=new JButton("Start");
		btnStop=new JButton("Stop");
		btnGenAleatoire=new JButton("Générer");
		btnStart.addActionListener(new GridActionListener());
		btnStop.addActionListener(new GridActionListener());
		btnGenAleatoire.addActionListener(new GridActionListener());
		tableGenerations.getColumnModel().getColumn(0).setMinWidth(40);
		tableGenerations.getColumnModel().getColumn(0).setMaxWidth(40);
		
		
		
		for(int i=0;i<cols*rows;i++)
		{
			btnTemp=new JButton();
			btnTemp.setBackground(Color.BLACK);
			btnTemp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			btnList.add(btnTemp);
			btnTemp.addActionListener(new GridActionListener());
			gridPanel.add(btnTemp);
		}
		
		setLayout(new BorderLayout(5,5));
		setTitle("Game Of Life : Created by Hassan NAZIH");
		setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		
		panelNbCycles.add(lblCycles);
		panelNbCycles.add(txtCycles);
		
		btnPanel.add(btnGenAleatoire);
		btnPanel.add(btnStart);
		btnPanel.add(btnStop);
		
		panelTemp.setLayout(new GridLayout(0,1));
		panelTemp.add(panelNbCycles);
		panelTemp.add(btnPanel);
		

		chart=new Chart(panelChart);
		
		panelLog.setLayout(new BorderLayout());
		panelLog.add(lblLog,BorderLayout.NORTH);
		
		panelLog.add(scrollTable,BorderLayout.CENTER);
		panelLog.add(panelChart,BorderLayout.SOUTH);

		add(menuBar,BorderLayout.NORTH);
		add(gridPanel,BorderLayout.CENTER);
		add(panelTemp,BorderLayout.SOUTH);
		add(panelLog,BorderLayout.EAST);
		

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}


	/**
	 * @return the btnList
	 */
	public static ArrayList<JButton> getBtnList() {
		return btnList;
	}


	/**
	 * @param btnList the btnList to set
	 */
	public static void setBtnList(ArrayList<JButton> btnList) {
		GUI.btnList = btnList;
	}


	/**
	 * @return the theGame
	 */
	public static Rules getTheGame() {
		return theGame;
	}


	/**
	 * @param theGame the theGame to set
	 */
	public static void setTheGame(Rules theGame) {
		GUI.theGame = theGame;
	}


	public static int getCols() {
	
		return cols;
	}
	
	public static int getRows() {
		
		return rows;
	}
	public static void AfficherGrilleTexte()
	{
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
				if(theGame.getEnv().getCellAt(i, j) instanceof Predateur)
					System.out.print("* ");
				else System.out.print("  ");
			System.out.println(" ");
		}
	}
	
	
	public static void AfficherGrille()
	{
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
				if(theGame.getEnv().getCellAt(i, j)instanceof Predateur)
					btnList.get(i*rows+j%cols).setBackground(Color.WHITE);
				else
					btnList.get((i*rows)+(j%cols)).setBackground(Color.BLACK);
		}
		
	}
	
	public static void iterer(int nbCycles)
	{
		theGame.iterer(nbCycles);
	}
	
	/**
	 * @return the gridPanel
	 */
	public JPanel getGridPanel() {
		return gridPanel;
	}


	/**
	 * @param gridPanel the gridPanel to set
	 */
	public void setGridPanel(JPanel gridPanel) {
		this.gridPanel = gridPanel;
	}


	/**
	 * @return the txtCycles
	 */
	public static JTextField getTxtCycles() {
		return txtCycles;
	}


	/**
	 * @param txtCycles the txtCycles to set
	 */
	public static void setTxtCycles(JTextField txtCycles) {
		GUI.txtCycles = txtCycles;
	}
	
	

	
	public Chart getChart()
	{
		return chart;
	}
	
	
	
	
}
