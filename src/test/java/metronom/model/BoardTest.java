package metronom.model;

import org.junit.Assert;
import org.junit.Test;

public class BoardTest {
	
	@Test
	public void shouldCreateANewEmptyBoard() {
		Board boardTest = new Board(2, 2);
		
		Assert.assertSame(boardTest.getCols(), 2);
		Assert.assertSame(boardTest.getRows(), 2);
		Assert.assertNotNull(boardTest.getGameBoard());
		Assert.assertTrue(boardTest.getGameBoard().length == 2);
		Assert.assertNotNull(boardTest.getGameBoard()[0][0]);
		Assert.assertNotNull(boardTest.getGameBoard()[0][1]);
		Assert.assertNotNull(boardTest.getGameBoard()[1][0]);
		Assert.assertNotNull(boardTest.getGameBoard()[1][1]);
	}
	
	@Test
	public void shouldAllCellsBeAvailable() {
		Board boardTest = new Board(2, 2);
		
		Assert.assertTrue(boardTest.isCellAvailable(1, 1));
		Assert.assertTrue(boardTest.isCellAvailable(1, 2));
		Assert.assertTrue(boardTest.isCellAvailable(2, 1));
		Assert.assertTrue(boardTest.isCellAvailable(2, 2));
	}
	
	@Test
	public void shouldAllBoardBeFull() {
		Board boardTest = new Board(2, 2);
		for (int i = 0; i < boardTest.getRows(); i++) {
			for (int j = 0; j < boardTest.getCols(); j++) { 
				boardTest.getGameBoard()[i][j].setAssignedPlayer(new Player('A', true));
			}
		}
		
		Assert.assertTrue(boardTest.isFull());
	}
	
	@Test
	public void shouldAssignPlayerToCell() {
		Board boardTest = new Board(2, 2);
		Player playerTest = new Player('Z', true);
		boardTest.submitMove(2, 1, playerTest);
		
		Assert.assertTrue(boardTest.getGameBoard()[1][0].isPlayerAssigned());
		Assert.assertFalse(boardTest.getGameBoard()[0][0].isPlayerAssigned());
		Assert.assertFalse(boardTest.getGameBoard()[0][1].isPlayerAssigned());
		Assert.assertFalse(boardTest.getGameBoard()[1][1].isPlayerAssigned());
	}
	
	@Test
	public void shouldValidateMovementInRange() {
		Board boardTest = new Board(3, 3);
		
		Assert.assertFalse(boardTest.isMovementInRange(4, 0));
		Assert.assertFalse(boardTest.isMovementInRange(5, 5));
		Assert.assertTrue(boardTest.isMovementInRange(3, 3));
		Assert.assertTrue(boardTest.isMovementInRange(1, 2));
	}
	
	@Test
	public void shouldFindAWinnerInRow() {
		Board boardTest = new Board(3, 3);
		Player playerTest1 = new Player('A', true);
		Player playerTest2 = new Player('X', true);
		boardTest.getGameBoard()[0][1].setAssignedPlayer(playerTest2);
		boardTest.getGameBoard()[1][0].setAssignedPlayer(playerTest1);
		boardTest.getGameBoard()[2][2].setAssignedPlayer(playerTest2);
		boardTest.getGameBoard()[1][1].setAssignedPlayer(playerTest1);
		boardTest.getGameBoard()[1][2].setAssignedPlayer(playerTest1);
		
		Assert.assertTrue(boardTest.hasWinner(2, 3));
	}
	
	@Test
	public void shouldFindAWinnerInColumn() {
		Board boardTest = new Board(3, 3);
		Player playerTest1 = new Player('B', true);
		Player playerTest2 = new Player('C', true);
		boardTest.getGameBoard()[2][1].setAssignedPlayer(playerTest2);
		boardTest.getGameBoard()[1][0].setAssignedPlayer(playerTest1);
		boardTest.getGameBoard()[2][2].setAssignedPlayer(playerTest2);
		boardTest.getGameBoard()[0][0].setAssignedPlayer(playerTest1);
		boardTest.getGameBoard()[2][0].setAssignedPlayer(playerTest1);
		
		Assert.assertTrue(boardTest.hasWinner(3, 1));
	}
	
	@Test
	public void shouldFindAWinnerInCross() {
		Board boardTest = new Board(3, 3);
		Player playerTest1 = new Player('D', true);
		Player playerTest2 = new Player('E', true);
		boardTest.getGameBoard()[0][0].setAssignedPlayer(playerTest2);
		boardTest.getGameBoard()[1][0].setAssignedPlayer(playerTest1);
		boardTest.getGameBoard()[2][2].setAssignedPlayer(playerTest2);
		boardTest.getGameBoard()[2][0].setAssignedPlayer(playerTest1);
		boardTest.getGameBoard()[1][1].setAssignedPlayer(playerTest2);
		
		Assert.assertTrue(boardTest.hasWinner(2, 2));
	}
	
	@Test
	public void shouldFindAWinnerInReversedCross() {
		Board boardTest = new Board(3, 3);
		Player playerTest1 = new Player('X', true);
		Player playerTest2 = new Player('Y', true);
		boardTest.getGameBoard()[0][2].setAssignedPlayer(playerTest1);
		boardTest.getGameBoard()[0][0].setAssignedPlayer(playerTest2);
		boardTest.getGameBoard()[1][1].setAssignedPlayer(playerTest1);
		boardTest.getGameBoard()[1][0].setAssignedPlayer(playerTest2);
		boardTest.getGameBoard()[2][0].setAssignedPlayer(playerTest1);
		
		Assert.assertTrue(boardTest.hasWinner(3, 1));
	}
}
