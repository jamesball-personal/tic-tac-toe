package com.jamesball.tictactoe;

import java.util.Arrays;
import java.util.List;

public final class Game {

    private final Board board = new Board();
    private final Player[] players;

    private Player currentPlayer;

    private GameStatus status = GameStatus.NOT_STARTED;

    public Game(Player[] players) {
        this.players = players;
    }

    public void play() {
        startGame();
        while (!isGameOver()) {
            takeTurn();
        }
        endGame();
    }

    private void startGame() {
        status = GameStatus.STARTED;
        board.print();
    }

    private void takeTurn() {
        setCurrentPlayer();
        PlayerTurn turn = new PlayerTurn(board, currentPlayer);
        turn.move();
        board.print();
        checkWin(turn.getMove());
    }

    private void setCurrentPlayer() {
        // Set the current player to X when on the first player turn
        if (currentPlayer == null) {
            currentPlayer = Arrays.stream(players)
                    .filter(player -> player.getMark().getPlayerNumber() == 1)
                    .findFirst()
                    .orElseThrow();
        }
        // Switch to the other player for subsequent turns
        else {
            currentPlayer = Arrays.stream(players)
                    .filter(player -> player.getMark() != currentPlayer.getMark())
                    .findFirst()
                    .orElseThrow();
        }

        System.out.println(currentPlayer.getMark().name() + " Turn");
    }

    private boolean isGameOver() {
        return status == GameStatus.WON || status == GameStatus.DRAWN;
    }

    private void checkWin(PlayerMove move) {
        // A list of the vectors of all possible rows on the board
        List<BoardVector> vectors = Arrays.asList(
                // Horizontal rows
                new BoardVector(0, 1),
                // Vertical rows
                new BoardVector(1, 0),
                // Top-left to bottom-right diagonal row
                new BoardVector(1, 1),
                // Bottom-left to top-right diagonal row
                new BoardVector(1, -1)
        );

        // Check each vector from the locus of the board space marked by the current player and update the status of
        // the game to WON if a complete row is found
        for (BoardVector vector : vectors) {
            if (isRowComplete(vector, move)) {
                status = GameStatus.WON;
                return;
            }
        }

        // Check if there any board spaces that have not been marked and update the status of the game to DRAWN if none
        // are found
        if (Arrays.stream(board.getBoardSpaces())
                .flatMap(Arrays::stream)
                .noneMatch(boardSpace -> boardSpace.getPlayerMark() == null)) {
            status = GameStatus.DRAWN;
        }
    }

    private boolean isRowComplete(BoardVector vector, PlayerMove move) {
        int nextRowNumber;
        int nextColumnNumber;
        int rowOffset = vector.getRowOffset();
        int columnOffset = vector.getColumnOffset();

        // The board space marked by the current player is included in the count of marked board spaces and therefore
        // is always at least 1
        int markedBoardSpacesInARow = 1;

        // Check the board spaces in the row to the right of the marked board space and increment the count of marked
        // board spaces for each board space that has a mark that matches that of the current player
        nextRowNumber = move.getRowNumber() + rowOffset;
        nextColumnNumber = move.getColumnNumber() + columnOffset;
        while (markedBoardSpacesInARow < board.getSize()) {
            try {
                if (board.getBoardSpace(nextRowNumber, nextColumnNumber).getPlayerMark() == currentPlayer.getMark()) {
                    markedBoardSpacesInARow++;
                    if (markedBoardSpacesInARow == board.getSize()) {
                        return true;
                    }
                    nextRowNumber = nextRowNumber + rowOffset;
                    nextColumnNumber = nextColumnNumber + columnOffset;
                } else {
                    break;
                }
            }
            catch (ArrayIndexOutOfBoundsException exception) {
                break;
            }
        }

        // Check the board spaces in the row to the left of the marked board space and increment the count of marked
        // board spaces for each board space that has a mark that matches that of the current player
        nextRowNumber = move.getRowNumber() - rowOffset;
        nextColumnNumber = move.getColumnNumber() - columnOffset;
        while (markedBoardSpacesInARow < board.getSize()) {
            try {
                if (board.getBoardSpace(nextRowNumber, nextColumnNumber).getPlayerMark() == currentPlayer.getMark()) {
                    markedBoardSpacesInARow++;
                    if (markedBoardSpacesInARow == board.getSize()) {
                        return true;
                    }
                    nextRowNumber = nextRowNumber - rowOffset;
                    nextColumnNumber = nextColumnNumber - columnOffset;
                } else {
                    break;
                }
            }
            catch (ArrayIndexOutOfBoundsException exception) {
                break;
            }
        }

        // The row is not complete
        return false;
    }

    private void endGame() {
        switch (status) {
            case WON -> System.out.println(currentPlayer.getMark().name() + " Win");
            case DRAWN -> System.out.println(players[0].getMark().name() + players[1].getMark().name() + " Draw");
        }
    }

}
