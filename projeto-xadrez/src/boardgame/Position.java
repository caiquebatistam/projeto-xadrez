package boardgame;


/**
 * Esta classe � responsavel pela posi��o do tabuleiro
 * 
 * @author Caique.Batista
 */
public class Position {
	
	private int row;
	
	private int column;

	
	//Construtor
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}


	

	
	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getColumn() {
		return column;
	}


	public void setColumn(int column) {
		this.column = column;
	}
	
	
	public void setValues(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	@Override
	public String toString() {
		return row + "," + column;
	}
	
	
	

}
