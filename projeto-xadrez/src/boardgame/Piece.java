package boardgame;

/**
 * Esta classe representa a pe�a do nosso tabuleiro
 * 
 * @author Caique.Batista
 */
public abstract class Piece {
	
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

	public abstract boolean[][] possibleMoves();
	
	/**
	 * Isso aqui foi novidade kkkk
	 * chamado de hookmethods...
	 * M�todo responsavel por setar os possiveis movimentos da pe�a
	 * @param 'position' posi��o da pe�a
	 * @return {possibleMoves}
	 */
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
		
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i = 0; i < mat.length ; i++) {
			for(int j=0 ; j< mat.length; j ++ ) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
		
	}
	
	

}
