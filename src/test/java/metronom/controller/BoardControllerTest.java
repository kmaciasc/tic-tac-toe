package metronom.controller;

import org.junit.Assert;
import org.junit.Test;

import metronom.model.Board;
import metronom.model.Player;

public class BoardControllerTest {

	@Test
	public void shouldReturnAvailableCell() {
		BoardController boardControllerTest = new BoardController();
		Board boardTest = new Board(2, 2);
		Player playerTest = new Player('X', true);
		boardTest.getGameBoard()[0][0].setAssignedPlayer(playerTest);
		boardTest.getGameBoard()[0][1].setAssignedPlayer(playerTest);
		boardTest.getGameBoard()[1][0].setAssignedPlayer(playerTest);
		
		Assert.assertSame(boardControllerTest.pickRandomCell(boardTest).getColumn(),1);
		Assert.assertSame(boardControllerTest.pickRandomCell(boardTest).getRow(), 1);
	}
}
