package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

/**
 * Esta classe representa a peça de xadrez
 * 
 * @author Caique.Batista

 */
public abstract class ChessPiece extends Piece {
	
	private Color color;

	
	
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	
	
	//Apenas getColor, não podemos permitir que seja alterada a cor da peça.
	public Color getColor() {
		return color;
	}

	protected boolean isThereOpponentPiece(Position position) {
		// d.casting pra funcionar
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
		
	}
	
}
