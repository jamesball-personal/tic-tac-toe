package com.jamesball.tictactoe;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class GameState {

    private static class RowDirection {

        private final Integer rowOffset;
        private final Integer columnOffset;

        public RowDirection(Integer rowOffset, Integer columnOffset) {
            this.rowOffset = rowOffset;
            this.columnOffset = columnOffset;
        }

        public Integer getRowOffset() {
            return rowOffset;
        }

        public Integer getColumnOffset() {
            return columnOffset;
        }
    }

    public List<BoardPosition> getAvailableMoves(Board board) {
        return board.getSquares().stream()
                .filter(square -> square.getMark() == null)
                .map(square -> new BoardPosition(square.getRow(), square.getColumn()))
                .collect(Collectors.toList());
    }

    public Board nextState(Player player, PlayerMove move, Board board) {
        Board boardCopy = new Board();
        board.getSquares().forEach(square -> boardCopy.getSquare(square).setMark(square.getMark()));
        boardCopy.getSquare(move).setMark(player.getMark());
        return boardCopy;
    }

    public Boolean isGameOver(Board board) {
        if (isDraw(board)) {
            return true;
        }
        else {
            return isWin(board);
        }
    }

    private Boolean isDraw(Board board) {
        return !board.getSquares().contains(null);
    }

    private Boolean isWin(Board board) {
        final List<RowDirection> rowDirections = new ArrayList<>();
        rowDirections.add(new RowDirection(0, 1));
        rowDirections.add(new RowDirection(1, 0));
        rowDirections.add(new RowDirection(1, 1));
        rowDirections.add(new RowDirection(1, -1));

        final BoardPosition latestMove = getLatestMove(board);

        Integer squaresWithMarkInRow = 1;

        int nextRow;
        int nextColumn;

        for (RowDirection rowDirection : rowDirections) {
            nextRow = latestMove.getRow() + rowDirection.getRowOffset();
            nextColumn = latestMove.getColumn() + rowDirection.getColumnOffset();
            while (squaresWithMarkInRow < board.getSize()) {
                try {
                    if (board.getSquare(new BoardPosition(nextRow, nextColumn)).getMark() == board.getSquare(latestMove).getMark()) {
                        squaresWithMarkInRow++;
                        if (squaresWithMarkInRow.equals(board.getSize())) {
                            return true;
                        }
                        nextRow = nextRow + rowDirection.getRowOffset();
                        nextColumn = nextColumn + rowDirection.getColumnOffset();
                    }
                    else {
                        break;
                    }
                }
                catch (InvalidMoveException exception) {
                    break;
                }
            }
            nextRow = latestMove.getRow() - rowDirection.getRowOffset();
            nextColumn = latestMove.getColumn() - rowDirection.getColumnOffset();
            while (squaresWithMarkInRow < board.getSize()) {
                try {
                    if (board.getSquare(new BoardPosition(nextRow, nextColumn)).getMark() == board.getSquare(latestMove).getMark()) {
                        squaresWithMarkInRow++;
                        if (squaresWithMarkInRow.equals(board.getSize())) {
                            return true;
                        }
                        nextRow = nextRow - rowDirection.getRowOffset();
                        nextColumn = nextColumn - rowDirection.getColumnOffset();
                    }
                    else {
                        break;
                    }
                }
                catch (InvalidMoveException exception) {
                    break;
                }
            }
        }
        return false;
    }

    private BoardPosition getLatestMove(Board board) {
        return board.getSquares().stream()
                .filter(square -> square.getMarkedAt() == board.getSquares().stream()
                        .map(BoardSquare::getMarkedAt)
                        .max(LocalDateTime::compareTo)
                        .orElseThrow()
                )
                .findFirst()
                .orElseThrow();
    }

}
