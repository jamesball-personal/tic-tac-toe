package com.jamesball.tictactoe;

import java.util.Arrays;

public final class Board {

    private static final int BOARD_SIZE = 3;
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
        return this.boardSpaces[rowNumber][columnNumber];
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardSpaces=" + Arrays.deepToString(this.boardSpaces) +
                "}";
    }

}
