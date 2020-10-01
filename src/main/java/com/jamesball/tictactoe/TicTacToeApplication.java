package com.jamesball.tictactoe;

import com.jamesball.tictactoe.controller.BoardController;
import com.jamesball.tictactoe.controller.PlayerController;
import com.jamesball.tictactoe.view.BoardView;
import com.jamesball.tictactoe.view.SelectMoveView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicTacToeApplication.class, args);

		PlayerController playerController = new PlayerController();
		playerController.selectPlayer();

		SelectMoveView selectMoveView = new SelectMoveView();
		BoardView boardView = new BoardView();

		BoardController boardController = new BoardController();

		boardController.printBoard();
		boardController.addMoveToBoard(playerController.getPlayerMark());
		boardController.printBoard();
	}

}
