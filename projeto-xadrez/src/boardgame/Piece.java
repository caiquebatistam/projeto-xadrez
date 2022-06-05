package boardgame;

/**
 * Esta classe representa a pe�a do nosso tabuleiro
 * 
 * @author Caique.Batista
 */
public class Piece {
	
	protected Position position;
	
	private Board board;

	
	/**
	 * Em tese eu n�o preciso declarar o valor de null a posi��o,
	 * porem para que fique um pouco mais didatico, eu j� coloquei.
	 * A posi��o precisa ser nula, pois a primeira jogada ela � = 0
	 * 
	 * @param board
	 */
	public Piece(Board board) {
		this.board = board;
		position = null;
	}


	
	/**
	 * S� vamos usar o get, para n�o ser possivel alterar o tabuleiro.
	 * 
	 * @return board
	 */
	protected Board getBoard() {
		return board;
	}

	
	
	

}
