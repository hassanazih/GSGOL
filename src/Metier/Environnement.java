package Metier;


public class Environnement {

		private Cell[][] cells;
		private int length;
		private int height;
		
		public Environnement(int length,int height)
		{
			cells=new Cell[height][length];
			for(int i=0;i<height;i++)
				for(int j=0;j<length;j++)
				{
					cells[i][j]=new Proie( i, j);
				}
			this.length=length;
			this.height=height;
		}
		
		public Environnement(Cell[][] cells,int length,int height)
		{
			cells=new Cell[height][length];
			this.length=length;
			this.height=height;
			
			
			for(int i=0;i<height;i++)
				for(int j=0;j<length;j++)
					this.cells[i][j]=cells[i][j];
			
			
		}
		
		public Cell getCellAt(int line,int column)
		{
			return cells[line][column];
		}
		
		public void setCellAt(int line,int column, Cell c)
		{
			cells[line][column]=c;
		}
		
		public int getActiveCellsNumber(Cell cel)
		{
			int nb=0;
		
			int line=cel.getLine();
			int column=cel.getColumn();
			
			if(line==0)
			{
				if(column==0)
				{
					
					if(cells[line][column+1] instanceof Predateur) nb++;
					if(cells[line+1][column+1] instanceof Predateur) nb++;
					if(cells[line+1][column] instanceof Predateur) nb++;
					if(cells[line+1][length-1] instanceof Predateur) nb++;
					if(cells[line][length-1] instanceof Predateur) nb++;
					if(cells[height-1][column] instanceof Predateur) nb++;
					if(cells[height-1][column+1] instanceof Predateur) nb++;
					if(cells[height-1][length-1] instanceof Predateur) nb++;
				}
				else if(column==length-1)
				{
					if(cells[line][column-1] instanceof Predateur) nb++;
					if(cells[line+1][column-1] instanceof Predateur) nb++;
					if(cells[line+1][column] instanceof Predateur) nb++;
					if(cells[line+1][0] instanceof Predateur) nb++;
					if(cells[line][0] instanceof Predateur) nb++;
					if(cells[height-1][column] instanceof Predateur) nb++;
					if(cells[height-1][column-1] instanceof Predateur) nb++;
					if(cells[height-1][0] instanceof Predateur) nb++;
				}
				else
				{
					if(cells[line][column+1] instanceof Predateur) nb++;
					if(cells[line+1][column+1] instanceof Predateur) nb++;
					if(cells[line+1][column-1] instanceof Predateur) nb++;
					if(cells[line+1][column] instanceof Predateur) nb++;
					if(cells[line][column-1] instanceof Predateur) nb++;
					if(cells[height-1][column] instanceof Predateur) nb++;
					if(cells[height-1][column+1] instanceof Predateur) nb++;
					if(cells[height-1][column-1] instanceof Predateur) nb++;
				}
			
			}
			else if(line==length-1)
			{
				if(column==0)
				{
					if(cells[line][column+1] instanceof Predateur) nb++;
					if(cells[line-1][column+1] instanceof Predateur) nb++;
					if(cells[line-1][column] instanceof Predateur) nb++;
					if(cells[line-1][length-1] instanceof Predateur) nb++;
					if(cells[line][length-1] instanceof Predateur) nb++;
					if(cells[0][column] instanceof Predateur) nb++;
					if(cells[0][column+1] instanceof Predateur) nb++;
					if(cells[0][length-1] instanceof Predateur) nb++;
				}
				else if(column==length-1)
				{
					if(cells[line][column-1] instanceof Predateur) nb++;
					if(cells[line-1][column-1] instanceof Predateur) nb++;
					if(cells[0][column-1] instanceof Predateur) nb++;
					if(cells[line-1][column] instanceof Predateur) nb++;
					if(cells[0][column] instanceof Predateur) nb++;
					if(cells[line-1][0] instanceof Predateur) nb++;
					if(cells[0][0] instanceof Predateur) nb++;
					if(cells[line][0] instanceof Predateur) nb++;
				}
				else
				{
					if(cells[line][column+1] instanceof Predateur) nb++;
					if(cells[line][column-1] instanceof Predateur) nb++;
					if(cells[line-1][column+1] instanceof Predateur) nb++;
					if(cells[line-1][column] instanceof Predateur) nb++;
					if(cells[line-1][column-1] instanceof Predateur) nb++;
					if(cells[0][column] instanceof Predateur) nb++;
					if(cells[0][column+1] instanceof Predateur) nb++;
					if(cells[0][column-1] instanceof Predateur) nb++;
				}
			
			}
			else
			{
				if(column==0)
				{
					if(cells[line][column+1] instanceof Predateur) nb++;
					if(cells[line+1][column+1] instanceof Predateur) nb++;
					if(cells[line+1][column] instanceof Predateur) nb++;
					if(cells[line-1][column] instanceof Predateur) nb++;
					if(cells[line-1][column+1] instanceof Predateur) nb++;
					if(cells[line-1][length-1] instanceof Predateur) nb++;
					if(cells[line][length-1] instanceof Predateur) nb++;
					if(cells[line+1][length-1] instanceof Predateur) nb++;
					
				}
				else if(column==length-1)
				{
					if(cells[line][column-1] instanceof Predateur) nb++;
					if(cells[line+1][column-1] instanceof Predateur) nb++;
					if(cells[line-1][column-1] instanceof Predateur) nb++;
					if(cells[line+1][column] instanceof Predateur) nb++;
					if(cells[line-1][column] instanceof Predateur) nb++;
					if(cells[line-1][0] instanceof Predateur) nb++;
					if(cells[line+1][0] instanceof Predateur) nb++;
					if(cells[line][0] instanceof Predateur) nb++;
				}
				else
				{
					if(cells[line][column+1] instanceof Predateur) nb++;
					if(cells[line][column-1] instanceof Predateur) nb++;
					if(cells[line-1][column+1] instanceof Predateur) nb++;
					if(cells[line+1][column+1] instanceof Predateur) nb++;
					if(cells[line-1][column-1] instanceof Predateur) nb++;
					if(cells[line+1][column-1] instanceof Predateur) nb++;
					if(cells[line-1][column] instanceof Predateur) nb++;
					if(cells[line+1][column] instanceof Predateur) nb++;
				}
			}
			return nb;
		}

		/**
		 * @return the cells
		 */
		public Cell[][] getCells() {
			return cells;
		}

		/**
		 * @param cells the cells to set
		 */
		public void setCells(Cell[][] cells) {
			for(int i=0;i<height;i++)
				for(int j=0;j<length;j++)
				{
					this.cells[i][j]=cells[i][j];
					//System.out.println("copie i="+i+" j="+j);
				}
		}

		/**
		 * @return the length
		 */
		public int getLength() {
			return length;
		}

		/**
		 * @param length the length to set
		 */
		public void setLength(int length) {
			this.length = length;
		}

		/**
		 * @return the height
		 */
		public int getHeight() {
			return height;
		}

		/**
		 * @param height the height to set
		 */
		public void setHeight(int height) {
			this.height = height;
		}
		
		
		
}

