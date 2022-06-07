package chess;

import boardgame.Board;
import boardgame.Piece;

/**
 * Esta classe representa a pe�a de xadrez
 * 
 * @author Caique.Batista

 */
public class ChessPiece extends Piece {
	
	private Color color;

	
	
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	
	
	//Apenas getColor, n�o podemos permitir que seja alterada a cor da pe�a.
	public Color getColor() {
		return color;
	}

	
	
}
