package com.jamesball.tictactoe;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Turn {

    private final static Scanner scanner = new Scanner(System.in);
    private final static Pattern movePattern = Pattern.compile("[0-9]{2}");

    public Turn() {
    }

    private static class Move {

        private final int rowNumber;
        private final int columnNumber;

        public Move(int rowNumber, int columnNumber) {
            this.rowNumber = rowNumber;
            this.columnNumber = columnNumber;
        }

        public int getRowNumber() {
            return this.rowNumber;
        }

        public int getColumnNumber() {
            return this.columnNumber;
        }

    }

    public void takeTurn(Player player, Board board) {
        Move move = enterMove();
        placeMoveOnBoard(player, board, move);
    }

    private Move enterMove() {
        while (true) {
            System.out.print("Enter move: ");
            String playerInput = scanner.next();
            Matcher moveMatcher = movePattern.matcher(playerInput);
            if (moveMatcher.matches()) {
                String[] coordinates = playerInput.split("");
                int rowNumber = Integer.parseInt(coordinates[0]);
                int columnNumber = Integer.parseInt(coordinates[1]);
                return new Move(rowNumber, columnNumber);
            }
            else {
                System.out.println("Invalid move.");
            }
        }
    }

    private void placeMoveOnBoard(Player player, Board board, Move move) {
        BoardSpace boardSpace = board.getBoardSpace(move.getRowNumber(), move.getColumnNumber());
        boardSpace.setPlayerMark(player.getPlayerMark());
    }

}
