package com.jamesball.tictactoe;

import java.util.Scanner;
import java.util.regex.Pattern;

public final class PlayerTurn {

    public PlayerTurn() {
    }

    public void move(Board board, Player player) {
        PlayerMove move = chooseMove(board);
        addMoveToBoard(board, player, move);
    }

    private void addMoveToBoard(Board board, Player player, PlayerMove move) {
        board.getBoardSpace(move.getRowNumber(), move.getColumnNumber()).setPlayerMark(player.getPlayerMark());
    }

    private PlayerMove chooseMove(Board board) throws InvalidPlayerMoveException {
        while (true) {
            try {
                String playerInput = inputMove();
                PlayerMove move = parseMove(playerInput);
                validateMove(board, move);
                return move;
            }
            catch (InvalidPlayerMoveException exception) {
                System.out.println("Invalid move.");
            }
        }

    }

    private String inputMove() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter move: ");
        return scanner.next();
    }

    private PlayerMove parseMove(String playerInput) {
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
        if (
                !(move.getRowNumber() < board.getBoardSize())
                || !(move.getColumnNumber() < board.getBoardSize())
                || !(board.getBoardSpace(move.getRowNumber(), move.getColumnNumber()).getPlayerMark() == null)
        ) {
            throw new InvalidPlayerMoveException();
        }
    }

}
