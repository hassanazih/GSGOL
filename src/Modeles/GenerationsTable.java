package Modeles;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class GenerationsTable extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<InfoTable> listeInfos;
	private ArrayList<String> columnNames;
	
	public GenerationsTable()
	{
		columnNames=new ArrayList<String>();
		listeInfos=new ArrayList<InfoTable>();
		initColumnsNames();
	}
	
	void initColumnsNames()
	{
		columnNames.add("Num");
		columnNames.add("Nombre de predateurs");
		columnNames.add("Nombre de proies");
		columnNames.add("Temps de calcul");
		
	}
	
	public String getColumnName(int columnIndex) {
        String colName="";
        if (columnIndex<=getColumnCount())
         colName=(String)columnNames.get(columnIndex);
        return colName;
       }
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeInfos.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1)
		{
		case 0:return listeInfos.get(arg0).getNumGen();
		case 1:return listeInfos.get(arg0).getNbPredateurs();
		case 2:return listeInfos.get(arg0).getNbProies();
		case 3:return listeInfos.get(arg0).getTempsCalcul();
		}
		return 0;
	}
	
	public void addRow(InfoTable i)
	{
		listeInfos.add(i);
		fireTableRowsInserted(0, getRowCount());
	}

	public  ArrayList<InfoTable> getListeInfos() {
		return listeInfos;
	}

	

}
