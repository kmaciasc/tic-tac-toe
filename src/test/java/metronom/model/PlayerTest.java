package metronom.model;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

	@Test
	public void shouldCreateNewHumanPlayer () {
		Player playerTest = new Player('O', true);
		
		Assert.assertNotNull(playerTest);
		Assert.assertTrue(playerTest.isHuman());
	}
	
	@Test
	public void shouldCreateNewComputerPlayer () {
		Player playerTest = new Player('O', false);
		
		Assert.assertNotNull(playerTest);
		Assert.assertFalse(playerTest.isHuman());
	}
	
	@Test
	public void shouldNotBeSamePlayer () {
		Player playerTest1 = new Player('x', false);
		Player playerTest2 = new Player('X', false);
		
		Assert.assertFalse(playerTest1.equals(playerTest2));
	}
}
