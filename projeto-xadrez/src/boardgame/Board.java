package boardgame;

/**
 * Esta classe representa nosso tabuleiro de xadrez
 * 
 * @author Caique.Batista
 *
 */
public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
		
	}


	public int getRows() {
		return rows;
	}


	public void setRow(int rows) {
		this.rows = rows;
	}


	public int getColumns() {
		return columns;
	}


	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	
	/**
	 * M�todo responsavel por setar a pe�a na linha e coluna
	 * 
	 * @param row 
	 * @param column
	 * @return {pieces} retorna a pe�a com linha e coluna
	 */
	public Piece piece( int row, int column) {
		return pieces[row][column];
		
	}
	
	/**
	 * Retorna a pe�a pela posi��o
	 * 
	 * Sobrecarga do m�todo Piece
	 * @param position
	 * @return
	 */
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}

	
	

}
