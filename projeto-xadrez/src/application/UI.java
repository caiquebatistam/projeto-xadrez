package application;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

/**
 * Classe responsavel por montar nosso tabuleiro no console
 * 
 * @author Caique.Batista
 */
public class UI {
	
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	/**
	 * Método responsavel por limpar o console,
	 * desta forma não fica poluida a cada jogada
	 * 
	 * @author Caique.Batista
	 */
	public static void clearScreen() {
		System.out.print("\033[H\033[23");
		System.out.flush();
	}
	
	
	/**
	 * Método responsavel por ler a posição que o usuario digitar
	 * 
	 * @param sc recebe o scanner do nosso programa principal 'main'
	 * @exception {e} esta exception refere-se a entradas do usuario 
	 * 				que estiver fora do permitido...Dito isso houve uma programação 
	 * 				defensiva neste método.
	 * @return {ChessPosition} 
	 */
	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new ChessPosition(column, row);
		}
		catch(RuntimeException e) {
			throw new InputMismatchException("Erro na leitura da posição do xadrez"
					+ "valores validos é de a1 até h8..."
					+ "PRESTA ATENÇÃO PARÇA");
		}
	}
	
	public static void printMatch (ChessMatch chessMatch, List<ChessPiece> captured ) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println();
		System.out.println("Turn : " + chessMatch.getTurn());
		System.out.println("Waiting player : " + chessMatch.getCurrentPlayer());
		
	}
	
	
	public static void printBoard(ChessPiece[][] pieces) {
		for (int i=0; i<pieces.length; i++) {
			System.out.print((8 - i)+ " ");
			for (int j=0; j<pieces.length; j++) {
				printPiece(pieces[i][j], false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
		
	}
	
	/**
	 * Com a lógica deste método, vai marcar as posições possiveis
	 * da peça selecionada... 
	 * obs... Ainda tentando entender a lógica do professor kkkk
	 * @param pieces
	 * @param possibleMoves
	 */
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves ) {
		for (int i=0; i<pieces.length; i++) {
			System.out.print((8 - i)+ " ");
			for (int j=0; j<pieces.length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
		
	}

	
	/**
	 * Lógica para montar nosso tabuleiro no console
	 *
	 *@author Caique.Batista
	 */
	private static void printPiece(ChessPiece piece, boolean background) {
		if (background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
    	if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
	}
	
	/**
	 * Lógica para imprimir as listas na tela
	 * @param captured
	 */
	private static void printCapturedPieces(List<ChessPiece> captured) {
		List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		System.out.println("Captured pieces: ");
		System.out.print("White: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(white.toArray())); // jeito padrão de imprimir lista de arrays no java, famoso pulin do gato
		System.out.print(ANSI_RESET);
		System.out.print("Black: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(black.toArray())); // jeito padrão de imprimir lista de arrays no java, famoso pulin do gato
		System.out.print(ANSI_RESET);
	
	
	}
}
