package com.jamesball.tictactoe;

import java.util.Arrays;

public final class Game {

    private final Board board = new Board();

    private final Player[] players;
    private Player currentPlayer;

    private GameStatus status = GameStatus.NOT_STARTED;

    public Game(Player[] players) {
        this.players = players;
    }

    private void startGame() {
        status = GameStatus.STARTED;
    }

    private void setCurrentPlayer() {
        if (currentPlayer == null) {
            currentPlayer = Arrays.stream(players)
                    .filter(player -> player.getPlayerMark().getPlayerNumber() == 1)
                    .findFirst()
                    .orElseThrow();
        }
        else {
            currentPlayer = Arrays.stream(players)
                    .filter(player -> player.getPlayerMark() != currentPlayer.getPlayerMark())
                    .findFirst()
                    .orElseThrow();
        }
    }

    private void takeTurn() {
        setCurrentPlayer();
        PlayerTurn turn = new PlayerTurn();
        turn.move(board, currentPlayer);
    }

    private void endGame() {
        status = GameStatus.ENDED;
    }

    private boolean is_gameover() {
        return status == GameStatus.ENDED;
    }

    public void play() {
        startGame();
        while (!is_gameover()) {
            board.printBoard();
            takeTurn();
        }
    }

}
