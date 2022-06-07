package chess;

import boardgame.Board;
import boardgame.Piece;

/**
 * Esta classe representa a peça de xadrez
 * 
 * @author Caique.Batista

 */
public class ChessPiece extends Piece {
	
	private Color color;

	
	
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	
	
	//Apenas getColor, não podemos permitir que seja alterada a cor da peça.
	public Color getColor() {
		return color;
	}

	
	
}
