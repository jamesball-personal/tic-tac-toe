package com.jamesball.tictactoe;

public final class PlayerMove {

    private final int rowNumber;
    private final int columnNumber;

    public PlayerMove(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    @Override
    public String toString() {
        return "PlayerMove{" +
                "rowNumber=" + rowNumber +
                ", columnNumber=" + columnNumber +
                "}";
    }

}
