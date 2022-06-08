package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

/**
 * Esta classe representa a peça Rei do jogo de xadrez
 * @author Caique.Batista
 */
public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}
	
	
	@Override
	public String toString() {
		return "k";
	}


}
