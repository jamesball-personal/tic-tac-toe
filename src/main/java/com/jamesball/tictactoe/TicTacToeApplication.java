package com.jamesball.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToeApplication {

	private static final Board board = new Board();
	private static final Player[] players = new Player[PlayerMark.values().length];
	private static final Turn TURN = new Turn();

	private static Player currentPlayer;

	static {
		for (PlayerMark playerMark : PlayerMark.values()) {
			players[playerMark.getPlayerNumber() - 1] = new Player(playerMark);
		}
	}

	static {
		currentPlayer = players[0];
	}

	public static void main(String[] args) {
		SpringApplication.run(TicTacToeApplication.class, args);
		printBoard();
		TURN.takeTurn(currentPlayer, board);
		printBoard();
	}

	private static void printBoard() {
		int boardSize = board.getBoardSize();
		System.out.print("   ");
		for (int i = 0; i < boardSize; i++) {
			System.out.print(" " + i + "  ");
		}
		System.out.print("\n");
		for (int i = 0; i < boardSize; i++) {
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
