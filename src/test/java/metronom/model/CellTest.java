package metronom.model;

import org.junit.Assert;
import org.junit.Test;

public class CellTest {

	@Test
	public void shouldNotAssignPlayer() {
		Cell cellTest = new Cell(1, 2);
		
		Assert.assertFalse(cellTest.isPlayerAssigned());
		Assert.assertNull(cellTest.getAssignedPlayer());
	}

	@Test
	public void shouldAssignPlayer() {
		Cell cellTest = new Cell(2, 2);
		Player playerTest = new Player('O', true);
		cellTest.setAssignedPlayer(playerTest);
		
		Assert.assertTrue(cellTest.getAssignedPlayer()!=null);
		Assert.assertTrue(cellTest.isPlayerAssigned());
	}

	@Test
	public void shouldReturnEmptyValue() {
		Cell cellTest = new Cell(3, 2);
		
		Assert.assertSame(cellTest.getValue(), ' ');
	}

	@Test
	public void shouldReturnValue() {
		Cell cellTest = new Cell(1, 3);
		Player playerTest = new Player('X', false);
		cellTest.setAssignedPlayer(playerTest);
		
		Assert.assertSame(cellTest.getValue(), 'X');
	}

	@Test
	public void shouldReturnStringPosition() {
		Cell cellTest = new Cell(2, 1);
		
		Assert.assertTrue(cellTest.toString().equals("3,2"));
	}
}
