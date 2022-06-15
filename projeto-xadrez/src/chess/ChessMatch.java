package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

/**
 * Esta classe representa a partida de xadrez
 * � praticamente o cora��o do nosso projeto,
 * responsavel por todas as regras do jogo.
 * 
 * @author Caique.Batista
 */
public class ChessMatch {
	
	private Board board;
	
	
	
	/** 
	 * Neste construtor acontece as seguintes a��es
	 * Quando for iniciada a partida, � criado um tabuleiro 8/8
	 * e sera colocado as pe�as atrav�s do m�todo initialSetup
	 */
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
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
	
	
	public boolean [][] possibleMoves(ChessPosition sourcePosition) {
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		//origem
		Position source = sourcePosition.toPosition();
		//destino
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece)capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("N�o h� pe�a na posi��o da fonte");
		}
		if (board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("N�o existe movimentos para a pe�a escolhida");
			
		}
	}
	
	private void validateTargetPosition (Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("A pe�a escolhida n�o pode mover para a posi��o de destino");
		}
	}
	
	
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		
		
		return capturedPiece;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	/**
	 * M�todo responsavel por iniciar a partida de xadrez
	 * colocando as pe�as no tabuleiro
	 * @author Caique.Batista
	 */
	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.WHITE));
	}
	
	
}
