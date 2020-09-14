package com.jamesball.tictactoe;

import java.util.Arrays;

public final class Board {

    // TODO Change to be a configurable parameter
    private final int SIZE = 3;
    private final BoardSpace[][] boardSpaces = new BoardSpace[SIZE][SIZE];


    // Initialise boardSpaces
    {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                boardSpaces[i][j] = new BoardSpace();
            }
        }
    }

    public Board() {
    }

    public int getSize() {
        return SIZE;
    }

    public BoardSpace[][] getBoardSpaces() {
        return boardSpaces;
    }

    public BoardSpace getBoardSpace(int rowNumber, int columnNumber) {
        return boardSpaces[rowNumber][columnNumber];
    }

    public void print() {
        // Print the number of each column above the board
		System.out.print("   ");
		for (int i = 0; i < SIZE; i++) {
			System.out.print(" " + i + "  ");
		}
		System.out.print("\n");

		// Print the each row
		for (int i = 0; i < SIZE; i++) {

		    // Print the upper row divider
			System.out.println("  +" + "---+".repeat(SIZE));

			// Print the row number
			System.out.print(i + " |");

			// Print the mark of each board space in the row
			for (short j = 0; j < SIZE; j++) {
				BoardSpace boardSpace = boardSpaces[i][j];
				String playerMark = (boardSpace.getPlayerMark() == null) ? " " : boardSpace.getPlayerMark().name();
				System.out.print(" " + playerMark + " |");
			}
			System.out.print("\n");
		}

		// Print the lower row divider of the last row
		System.out.println("  +" + "---+".repeat(SIZE));
	}

    @Override
    public String toString() {
        return "Board{" +
                "boardSpaces=" + Arrays.deepToString(boardSpaces) +
                "}";
    }

}
