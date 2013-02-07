package Metier;


public abstract class Cell {

		private int line;
		private int column;
		
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
		
		public Cell(int line,int column)
		{
			this.line=line;
			this.column=column;
		}
		
		
}
