package Metier;
import java.util.Calendar;
import java.util.GregorianCalendar;
import Modeles.GenerationsTable;
import Modeles.InfoTable;
import Vue.GUI;


public class Reconstruct extends Thread{

	
	private Environnement env;
	public static int demarre; 
	private GUI theUI;
	private int nbCycles;
	private InfoTable inf;
	private int nbPredateurs;
	private int nbProies;
	
	
	public Reconstruct(Environnement env,GUI theUI, int nbCycles) {
		super();
		demarre=0;
		this.env = env;
		this.theUI=theUI;
		this.nbCycles = nbCycles;
	}
	
	@Override
	public void run() {
		int i=0;
		Calendar start;
		Calendar end;
		
		demarre=1;
		if(nbCycles==0)
		{
			while(demarre!=0) 
			{
				start=new GregorianCalendar();
				faireUnCycle();
				end=new GregorianCalendar();
				GUI.AfficherGrille();
				getCellsInfos();
				inf=new InfoTable(i++, nbPredateurs, nbProies, end.getTimeInMillis()-start.getTimeInMillis());
				((GenerationsTable)theUI.getTableGenerations().getModel()).addRow(inf);
				theUI.getChart().actualiser(nbPredateurs,nbProies);
				start=end=null;

				
				theUI.getGridPanel().repaint();
				try {
					synchronized(this)
					{
						wait(100);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else
		{
			while(nbCycles!=0 && demarre!=0) 
			{
				start=new GregorianCalendar();
				faireUnCycle();
				end=new GregorianCalendar();
				nbCycles--;
				GUI.AfficherGrille();
				theUI.getGridPanel().repaint();
				getCellsInfos();
				inf=new InfoTable(i++, nbPredateurs, nbProies, end.getTimeInMillis()-start.getTimeInMillis());
				theUI.getChart().actualiser((double)nbPredateurs,(double)nbProies);
				start=end=null;
				
				((GenerationsTable)theUI.getTableGenerations().getModel()).addRow(inf);
				try {
					synchronized(this)
					{
						wait(100);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		demarre=0;
		
	}
	
	

	void faireUnCycle()
	{
		Cell temp[][]=new Cell[env.getHeight()][env.getLength()];
		for(int i =0;i<env.getHeight();i++)
			for(int j=0;j<env.getLength();j++)
			{
				
				if(env.getCellAt(i, j)instanceof Predateur)
				{
					temp[i][j]=new Predateur( i, j);
					if(env.getActiveCellsNumber(env.getCellAt(i, j))>3 || env.getActiveCellsNumber(env.getCellAt(i, j))<2)
						temp[i][j]=new Proie(i,j);
				}
				else
				{
					temp[i][j]=new Proie( i, j);
					if(env.getActiveCellsNumber(env.getCellAt(i, j))==3 )
						temp[i][j]=new Predateur(i,j);
				}
				
			}
		env.setCells(temp);
		
	}
	
	public void getCellsInfos()
	{
		nbPredateurs=0;
		nbProies=0;
		
		for(int i=0;i<GUI.getRows();i++)
			for(int j=0;j<GUI.getCols();j++)
			{
				if(GUI.getTheGame().getEnv().getCellAt(i, j) instanceof Predateur)		nbPredateurs++;
				else nbProies++;
			}
				
	}
	
	public int getNbProies() {
		return nbProies;
	}

	public void setNbProies(int nbProies) {
		this.nbProies = nbProies;
	}

	public int getNbPredateurs() {
		return nbPredateurs;
	}

	public void setNbPredateurs(int nbPredateurs) {
		this.nbPredateurs = nbPredateurs;
	}
	
	

}
