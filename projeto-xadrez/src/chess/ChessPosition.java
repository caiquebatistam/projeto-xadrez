package chess;

import boardgame.Position;

public class ChessPosition {

	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Erro ao instanciar ChessPosition, valores aceitaveis s�o:"
					+ "de a1 at� h8");
		}
		this.column = column;
		this.row = row;
	}
	
	
	
	
	
	public char getColumn() {
		return column;
	}



	public int getRow() {
		return row;
	}

	/**
	 * Este m�todo implementa uma l�gica meio chatinha para
	 * posicionar as pe�as, basicamente eu preciso ensinar
	 * o sistema para que a posi��o no tabuleiro seja igual
	 * ao da matrix que estamos utilizando para criar o tabuleiro.
	 * Sem a explica��o do professor, com a parte visual do calculo
	 * deve ficar bem esquisito para quem esta tentando entender o m�todo...
	 * 
	 * Minha recomenda��o, s� chora e aceita ! 
	 * 
	 * @return Lagrimas!
	 */
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
		
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition ((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
	
}
