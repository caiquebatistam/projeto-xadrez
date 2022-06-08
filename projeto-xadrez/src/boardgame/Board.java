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
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro Criando tabuleiro "
					+ "� necessario que exista pelo menos"
					+ "uma linha e uma coluna ");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
		
	}


	public int getRows() {
		return rows;
	}



	public int getColumns() {
		return columns;
	}


	/**
	 * M�todo responsavel por setar a pe�a na linha e coluna
	 * 
	 * @param row 
	 * @param column
	 * @return {pieces} retorna a pe�a com linha e coluna
	 */
	public Piece piece( int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Posi��o n�o esta no tabuleiro");
		}
		
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
		if(!positionExists(position)) {
			throw new BoardException("Posi��o n�o esta no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	
	/**
	 * Este m�todo � responsavel por colocar a pe�a na posi��o do tabuleiro
	 * 
	 * @param piece
	 * @param position
	 * @author Caique.Batista
	 */
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("J� existe uma pe�a nessa posi��o meu paceeeru!!!");
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	
	
	/**
	 * M�todo auxiliar pra verificar se a posi��o existe
	 * 
	 * @param row
	 * @param column
	 * @return retorna a posi��o
	 */
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	/**
	 * M�todo criado pra verificar se existe uma pe�a 
	 * na posi��o escolhida.
	 * @param position
	 */
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posi��o n�o esta no tabuleiro");
		}
		return piece(position) != null;
	}

}
