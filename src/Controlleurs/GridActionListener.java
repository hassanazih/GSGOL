package Controlleurs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Metier.Predateur;
import Metier.Proie;
import Metier.Reconstruct;
import Vue.GUI;


public class GridActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("Start"))
		{
			if(Reconstruct.demarre==0)
			{
				if(!GUI.getTxtCycles().getText().equals("")) 
					GUI.iterer(Integer.parseInt(GUI.getTxtCycles().getText()));
				else
					GUI.iterer(0);
			}
		}
		else if(e.getActionCommand().equals("Stop"))
		{
			
			if(Reconstruct.demarre==1)
			{
				Reconstruct.demarre=0;
			}
		}
		else if(e.getActionCommand().equals("Générer"))
		{
			for(int i=0;i<GUI.getRows();i++)
				for(int j=0;j<GUI.getCols();j++)
				{
					
					if(MyRand())
					{
						GUI.getTheGame().getEnv().setCellAt(i, j,new Predateur(i,j));
						GUI.getBtnList().get(i*GUI.getCols()+j).setBackground(Color.WHITE);
					}
					
				}	
		}
		else
		{
			JButton temp=(JButton)e.getSource();
			int position=GUI.getBtnList().indexOf(temp);
			if(temp.getBackground()==Color.WHITE)
			{
				GUI.getTheGame().getEnv().setCellAt(position/GUI.getCols(), position%GUI.getRows(),new Proie(position/GUI.getCols(),position%GUI.getRows()));
				//GUI.getTheGame().getEnv().setCellAt(position/GUI.getCols(), position%GUI.getRows(), false);
				temp.setBackground(Color.BLACK);
			}
			else
			{
				GUI.getTheGame().getEnv().setCellAt(position/GUI.getCols(), position%GUI.getRows(),new Predateur(position/GUI.getCols(),position%GUI.getRows()));
				//GUI.getTheGame().getEnv().setCellAt(position/GUI.getCols(), position%GUI.getRows(), true);
				temp.setBackground(Color.WHITE);
			}
				
		}
	}
	
	public boolean MyRand()
	{
		return (Math.random()<0.5)?true:false;
	}
	

}
