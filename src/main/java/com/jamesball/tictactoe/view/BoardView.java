package com.jamesball.tictactoe.view;

import com.jamesball.tictactoe.model.BoardSquare;

import java.util.List;

public class BoardView {

    public void printBoard(List<List<BoardSquare>> boardSquares) {
        final int boardSize = boardSquares.size();

        // Print the number of each column above the board
        System.out.print("   ");
        for (int i = 0; i < boardSize; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.print("\n");

        // Print the each row
        for (int i = 0; i < boardSize; i++) {

            // Print the upper row divider
            System.out.println("  +" + "---+".repeat(boardSize));

            // Print the row number
            System.out.print(i + " |");

            // Print the mark of each board space in the row
            for (short j = 0; j < boardSize; j++) {
                // Get player mark and use blank space when null
                String playerMark = boardSquares.get(i).get(j).getPlayerMark() == null ? " " : boardSquares.get(i).get(j).getPlayerMark().name();

                System.out.print(" " + playerMark + " |");
            }
            System.out.print("\n");
        }

        // Print the lower row divider of the last row
        System.out.println("  +" + "---+".repeat(boardSize));
    }
}
