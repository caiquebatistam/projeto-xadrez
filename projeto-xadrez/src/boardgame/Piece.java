package boardgame;

/**
 * Esta classe representa a peça do nosso tabuleiro
 * 
 * @author Caique.Batista
 */
public abstract class Piece {
	
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

	public abstract boolean[][] possibleMoves();
	
	/**
	 * Isso aqui foi novidade kkkk
	 * chamado de hookmethods...
	 * Método responsavel por setar os possiveis movimentos da peça
	 * @param 'position' posição da peça
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
