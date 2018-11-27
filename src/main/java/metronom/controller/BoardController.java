package metronom.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import metronom.model.Board;
import metronom.model.Cell;

public class BoardController {

	public BoardController() {

	}

	public Cell pickRandomCell (Board board) {
		List<Cell> availableCells = new ArrayList<>();
		Cell cell;
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				cell = board.getGameBoard()[i][j];
				if (!cell.isPlayerAssigned()) {
					availableCells.add(cell);
				}
			}
		}
		Collections.shuffle(availableCells);

		return availableCells.get(0);
	}
}
