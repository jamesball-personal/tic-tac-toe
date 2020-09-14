package com.jamesball.tictactoe;

public class BoardVector {

    private int rowOffset;
    private int columnOffset;

    public BoardVector(int rowOffset, int columnOffset) {
        this.rowOffset = rowOffset;
        this.columnOffset = columnOffset;
    }

    public int getRowOffset() {
        return rowOffset;
    }

    public int getColumnOffset() {
        return columnOffset;
    }

    @Override
    public String toString() {
        return "BoardVector{" +
                "rowOffset=" + rowOffset +
                ", columnOffset=" + columnOffset +
                "}";
    }

}
