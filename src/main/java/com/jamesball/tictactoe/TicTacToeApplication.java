package com.jamesball.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToeApplication {

	private static final Player[] players = new Player[PlayerMark.values().length];

	static {
		for (PlayerMark playerMark : PlayerMark.values()) {
			Player newPlayer = new Player(playerMark);
			players[playerMark.getPlayerNumber() - 1] = newPlayer;
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(TicTacToeApplication.class, args);
		Game game = new Game(players);
		game.play();
	}

}
