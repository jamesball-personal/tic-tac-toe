package com.jamesball.tictactoe;

import java.util.Arrays;

public class Board {

    private static final short BOARD_SIZE = 3;
    private final BoardSpace[][] boardSpaces = new BoardSpace[BOARD_SIZE][BOARD_SIZE];

    {
        for (short i = 0; i < BOARD_SIZE; i++) {
            for (short j = 0; j < BOARD_SIZE; j++) {
                boardSpaces[i][j] = new BoardSpace();
            }
        }
    }

    public Board() {
    }

    public short getBoardSize() {
        return BOARD_SIZE;
    }

    public BoardSpace getBoardSpace(short rowNumber, short columnNumber) {
        return this.boardSpaces[rowNumber][columnNumber];
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardSpaces=" + Arrays.deepToString(this.boardSpaces) +
                "}";
    }

}
