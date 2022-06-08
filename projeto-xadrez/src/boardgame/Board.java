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
					+ "é necessario que exista pelo menos"
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
	 * Método responsavel por setar a peça na linha e coluna
	 * 
	 * @param row 
	 * @param column
	 * @return {pieces} retorna a peça com linha e coluna
	 */
	public Piece piece( int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Posição não esta no tabuleiro");
		}
		
		return pieces[row][column];
		
	}
	
	/**
	 * Retorna a peça pela posição
	 * 
	 * Sobrecarga do método Piece
	 * @param position
	 * @return
	 */
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição não esta no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	
	/**
	 * Este método é responsavel por colocar a peça na posição do tabuleiro
	 * 
	 * @param piece
	 * @param position
	 * @author Caique.Batista
	 */
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peça nessa posição meu paceeeru!!!");
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	
	
	/**
	 * Método auxiliar pra verificar se a posição existe
	 * 
	 * @param row
	 * @param column
	 * @return retorna a posição
	 */
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	/**
	 * Método criado pra verificar se existe uma peça 
	 * na posição escolhida.
	 * @param position
	 */
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição não esta no tabuleiro");
		}
		return piece(position) != null;
	}

}
