package metronom.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Board {

	public int rows;
	public int cols;
	public Cell [][] gameBoard;

	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.gameBoard = new Cell[rows][cols];
		this.initBoard();
	}

	public Cell[][] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Cell[][] gameBoard) {
		this.gameBoard = gameBoard;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public boolean isCellAvailable(int row, int column) {
		Cell currentPosition = gameBoard[row-1][column-1];
		return !currentPosition.isPlayerAssigned();
	}


	public void submitMove(int row, int column, Player player) {
		if (isCellAvailable(row, column)) {
			gameBoard[row-1][column-1].setAssignedPlayer(player);
		}
	}

	private void initBoard () {
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				gameBoard[i][j] = new Cell(i, j);
			}
		}
	}

	private boolean checkColumn(int currentColumn) {
		List<Character> columnPath = new ArrayList<>();
		for (int i = 0; i < getRows(); i++) {
			columnPath.add(gameBoard[i][currentColumn].getValue());
		}

		return (new HashSet<Character>(columnPath).size() <= 1);
	}

	private boolean checkRow(int currentRow) {
		List<Character> rowPath = new ArrayList<>();
		for(int j = 0; j< getCols(); j++) {
			rowPath.add(gameBoard[currentRow][j].getValue());
		}

		return (new HashSet<Character>(rowPath).size() <= 1);
	}

	private boolean checkCrossed() {
		List<Character> crossedPath = new ArrayList<>();
		boolean result;
		for(int j = 0; j< getRows(); j++) {
			crossedPath.add(gameBoard[j][j].getValue());
		}
		if (crossedPath.contains(' ')) {
			result = false;
		}
		else {
			result = new HashSet<Character>(crossedPath).size() <= 1;
		}
		return result;
	}

	private boolean checkInverseCrossed() {
		List<Character> inverseCrossedPath = new ArrayList<>();
		int count = 0;
		boolean result;
		for(int j = getRows()-1; j>= 0 ; j--) {
			inverseCrossedPath.add(gameBoard[j][count].getValue());
			count++;
		}
		if (inverseCrossedPath.contains(' ')) {
			result = false;
		}
		else {
			result = new HashSet<Character>(inverseCrossedPath).size() <= 1;
		}

		return (result);
	}

	public boolean isFull() {
		boolean isFull = true;
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				if (!gameBoard[i][j].isPlayerAssigned()) {
					isFull = false;
					break;
				}
			}
		}
		return isFull;
	}

	public boolean hasWinner(int row, int column) {
		return checkColumn(column-1) || checkRow(row-1)
				|| checkCrossed() || checkInverseCrossed();
	}




}
