package com.jamesball.tictactoe;

import java.util.Arrays;

public final class Board {

    private final int BOARD_SIZE = 3;
    private final BoardSpace[][] boardSpaces = new BoardSpace[BOARD_SIZE][BOARD_SIZE];

    {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                boardSpaces[i][j] = new BoardSpace();
            }
        }
    }

    public Board() {
    }

    public int getBoardSize() {
        return BOARD_SIZE;
    }

    public BoardSpace getBoardSpace(int rowNumber, int columnNumber) {
        return boardSpaces[rowNumber][columnNumber];
    }

    public void printBoard() {
		System.out.print("   ");
		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.print(" " + i + "  ");
		}
		System.out.print("\n");
		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.println("  +" + "---+".repeat(BOARD_SIZE));
			System.out.print(i + " |");
			for (short j = 0; j < BOARD_SIZE; j++) {
				BoardSpace boardSpace = boardSpaces[i][j];
				String playerMark = (boardSpace.getPlayerMark() == null) ? " " : boardSpace.getPlayerMark().name();
				System.out.print(" " + playerMark + " |");
			}
			System.out.print("\n");
		}
		System.out.println("  +" + "---+".repeat(BOARD_SIZE));
	}

    @Override
    public String toString() {
        return "Board{" +
                "boardSpaces=" + Arrays.deepToString(boardSpaces) +
                "}";
    }

}
