package com.jamesball.tictactoe;

import java.util.Scanner;
import java.util.regex.Pattern;

public final class PlayerTurn {

    private final Scanner scanner = new Scanner(System.in);

    private final Board board;
    private final Player player;
    private PlayerMove move;

    public PlayerTurn(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    public void move() {
        chooseMove();
        addMoveToBoard();
    }

    public PlayerMove getMove() {
        return move;
    }

    private void addMoveToBoard() {
        board.getBoardSpace(move.getRowNumber(), move.getColumnNumber()).setPlayerMark(player.getMark());
    }

    private void chooseMove() throws InvalidPlayerMoveException {
        while (true) {
            try {
                String playerInput = inputMove();
                move = parseMove(playerInput);
                validateMove(board, move);
                break;
            }
            catch (InvalidPlayerMoveException exception) {
                System.out.println("Invalid Move");
            }
        }
    }

    private String inputMove() {
        System.out.print("Enter Move: ");
        return scanner.next();
    }

    private PlayerMove parseMove(String playerInput) {
        // The player input must be two undelimited numbers
        // The first number is the row number, the second number is the column number
        final Pattern inputPattern = Pattern.compile("[0-9]{2}");
        if (inputPattern.matcher(playerInput).matches()) {
            String[] coordinates = playerInput.split("");
            return new PlayerMove(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
        }
        else {
            throw new InvalidPlayerMoveException();
        }
    }

    private void validateMove(Board board, PlayerMove move) throws InvalidPlayerMoveException {
        // The move must reference a valid board space that has not been marked
        if (!(move.getRowNumber() < board.getSize())
                || !(move.getColumnNumber() < board.getSize())
                || !(board.getBoardSpace(move.getRowNumber(), move.getColumnNumber()).getPlayerMark() == null)
        ) {
            throw new InvalidPlayerMoveException();
        }
    }

}
