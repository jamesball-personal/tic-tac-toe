package com.jamesball.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicTacToeApplication.class, args);
		final Board board = new Board();
		printBoard(board);
	}

	private static void printBoard(Board board) {
		short boardSize = board.getBoardSize();
		System.out.print("   ");
		for (short i = 0; i < boardSize; i++) {
			System.out.print(" " + i + "  ");
		}
		System.out.print("\n");
		for (short i = 0; i < boardSize; i++) {
			System.out.println("  +" + "---+".repeat(boardSize));
			System.out.print(i + " |");
			for (short j = 0; j < boardSize; j++) {
				BoardSpace boardSpace = board.getBoardSpace(i, j);
				String playerMark = (boardSpace.getPlayerMark() == null) ? " " : boardSpace.getPlayerMark().name();
				System.out.print(" " + playerMark + " |");
			}
			System.out.print("\n");
		}
		System.out.println("  +" + "---+".repeat(boardSize));
	}

}
