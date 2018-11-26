package metronom.controller;


import java.util.Collections;
import java.util.List;

import metronom.model.Board;
import metronom.model.Cell;
import metronom.model.Player;
import metronom.util.Util;
import metronom.view.TicTacToeView;

public class TicTacToeGame {

	private TicTacToeView view;
	private SetupController setUpController;
	private PlayerController playerController;
	private Board board;
	private List<Player> players;

	public TicTacToeGame() {
		view = new TicTacToeView();
		setUpController = new SetupController();
		playerController = new PlayerController();

	}

	public static void main(String[] args) {
		new TicTacToeGame().playTicTacToe();
	}

	public void playTicTacToe () {
		view.displayMessage("*************\n Tic-tac-toe \n*************");
		boolean isOver = false;

		board = setUpController.loadBoard();
		players = setUpController.loadPlayers();
		Collections.shuffle(players);

		while(!isOver) {
			Cell randomCell;
			String playerInput;
			for (Player player : players) {
				if (player.isHuman()) {
					boolean isValidInput = false;
					playerInput = null;

					while (!isValidInput) {
						view.displayMessage(String.format("\nPlayer %s, please enter your selection. Format: <<row,column>> Selection must be between 1 and %s ", player.getMarker(), board.getCols()));
						playerInput = view.readFromInput();

						if(!Util.isValidInput(playerInput)) {
							isValidInput = false;
							view.displayMessage("Invalid input. Try again... (e.g. 3,1)");
							continue;
						}
						if(!Util.isMovementInRange(playerInput, board.getRows(), board.getCols())) {
							isValidInput = false;
							view.displayMessage("The input is out of the board. Try again...");
							continue;
						}
						if (!board.isCellAvailable(Util.getRowValue(playerInput), Util.getColumnValue(playerInput))) {
							isValidInput = false;
							view.displayMessage("The selection is already in use. Try again...");
							continue;
						}
						isValidInput = true;

					}
					board.submitMove(Util.getRowValue(playerInput), Util.getColumnValue(playerInput), player);


				} else {
					view.displayMessage(String.format("Computer player %s is next", player.getMarker()));
					randomCell = playerController.pickRandomCell(board);
					playerInput = randomCell.toString();
					view.displayMessage("Computer input: "+ randomCell.toString());
					board.submitMove(Util.getRowValue(playerInput), Util.getColumnValue(playerInput), player);

				}
				view.printBoard(board);
				if(board.hasWinner(Util.getRowValue(playerInput), Util.getColumnValue(playerInput))) {
					view.displayMessage(String.format("\nYay!, player %s is the WINNER", player.getMarker()));
					isOver = true;
					break;

				}
				if(board.isFull()) {
					isOver = true;
					view.displayMessage("\nSorry, board is full. Game is over.");
					break;
				}

			}
		}

	}
}
