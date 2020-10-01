package com.jamesball.tictactoe.model;

import com.jamesball.tictactoe.exception.InvalidBoardPositionException;
import com.jamesball.tictactoe.exception.InvalidMoveException;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<List<BoardSquare>> boardSquares;

    {
        boardSquares = new ArrayList<>();
        int size = 3;
        for (int i = 0; i < size; i++) {
            List<BoardSquare> boardRow = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                BoardSquare boardSquare = new BoardSquare();
                boardSquare.setRow(i);
                boardSquare.setColumn(j);
                boardRow.add(boardSquare);
            }
            boardSquares.add(boardRow);
        }
    }

    public List<List<BoardSquare>> getBoardSquares() {
        List<List<BoardSquare>> boardSquaresCopy = new ArrayList<>();
        for (List<BoardSquare> boardRow : boardSquares) {
            List<BoardSquare> boardRowCopy = new ArrayList<>();
            for (BoardSquare boardSquare : boardRow) {
                boardRowCopy.add(boardSquare.clone());
            }
            boardSquaresCopy.add(boardRowCopy);
        }
        return boardSquaresCopy;
    }

    public void addMoveToBoard(Move move) throws InvalidMoveException {
        try {
            BoardSquare boardSquare = getBoardSquare(move);
            boardSquare.setPlayerMark(move.getPlayerMark());
        }
        catch (InvalidBoardPositionException exception) {
            throw new InvalidMoveException();
        }
    }

    private BoardSquare getBoardSquare(BoardPosition boardPosition) throws InvalidBoardPositionException {
        return boardSquares.stream()
                .flatMap(List::stream)
                .filter(boardSquare -> boardSquare.getRow().equals(boardPosition.getRow()) && boardSquare.getColumn().equals(boardPosition.getColumn()))
                .findFirst()
                .orElseThrow(InvalidBoardPositionException::new);
    }
}
