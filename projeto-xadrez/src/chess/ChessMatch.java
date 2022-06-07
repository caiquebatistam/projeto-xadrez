package chess;

import java.util.Iterator;

import boardgame.Board;

/**
 * Esta classe representa a partida de xadrez
 * � praticamente o cora��o do nosso projeto,
 * responsavel por todas as regras do jogo.
 * 
 * @author Caique.Batista
 */
public class ChessMatch {
	
	private Board board;
	
	
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
	
	/**
	 * Matriz de pe�as da partida de xadrez
	 *
	 *@author Caique.Batista
	 *@return retorna matriz de pe�as 
	 */
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i < board.getRows(); i ++) {
			for (int j=0; j< board.getColumns(); j++) {
				mat [i][j] = (ChessPiece) board.piece(i,j);
			}
		}
		return mat;	
	}
	
	
}
