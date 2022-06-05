package boardgame;

/**
 * Esta classe representa a peça do nosso tabuleiro
 * 
 * @author Caique.Batista
 */
public class Piece {
	
	protected Position position;
	
	private Board board;

	
	/**
	 * Em tese eu não preciso declarar o valor de null a posição,
	 * porem para que fique um pouco mais didatico, eu já coloquei.
	 * A posição precisa ser nula, pois a primeira jogada ela é = 0
	 * 
	 * @param board
	 */
	public Piece(Board board) {
		this.board = board;
		position = null;
	}


	
	/**
	 * Só vamos usar o get, para não ser possivel alterar o tabuleiro.
	 * 
	 * @return board
	 */
	protected Board getBoard() {
		return board;
	}

	
	
	

}
