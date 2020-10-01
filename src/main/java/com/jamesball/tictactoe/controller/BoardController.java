package com.jamesball.tictactoe.controller;

import com.jamesball.tictactoe.exception.InvalidMoveException;
import com.jamesball.tictactoe.model.Board;
import com.jamesball.tictactoe.model.Move;
import com.jamesball.tictactoe.model.PlayerMark;
import com.jamesball.tictactoe.view.BoardView;
import com.jamesball.tictactoe.view.SelectMoveView;

import java.util.regex.Pattern;

public class BoardController {

    private Board board = new Board();
    private BoardView boardView = new BoardView();
    private SelectMoveView selectMoveView = new SelectMoveView();

    public void addMoveToBoard(PlayerMark playerMark) throws InvalidMoveException {
        while (true) {
            try {
                String playerInput = selectMoveView.inputMove();
                Move move = parsePlayerInput(playerInput);
                move.setPlayerMark(playerMark);
                board.addMoveToBoard(move);
                break;
            }
            catch (InvalidMoveException exception) {
                System.out.println("Invalid move");
            }
        }
    }

    public void printBoard() {
        boardView.printBoard(board.getBoardSquares());
    }

    private Move parsePlayerInput(String playerInput) throws InvalidMoveException {
        // The player input must be two undelimited numbers
        // The first number is the row number, the second number is the column number
        final Pattern requiredInputPattern = Pattern.compile("[0-9]{2}");
        if (requiredInputPattern.matcher(playerInput).matches()) {
            String[] coordinates = playerInput.split("");
            Move move = new Move();
            move.setRow(Integer.valueOf(coordinates[0]));
            move.setColumn(Integer.valueOf(coordinates[1]));
            return move;
        }
        throw new InvalidMoveException();
    }
}
