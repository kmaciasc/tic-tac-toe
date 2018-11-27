package metronom.util;

import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

	@Test
	public void shouldValidateIfIsNumber() {
		Assert.assertTrue(Util.isNumber("3"));
		Assert.assertTrue(Util.isNumber("0"));
		Assert.assertTrue(Util.isNumber("5"));
		Assert.assertFalse(Util.isNumber("X"));
	}
	
	@Test
	public void shouldValidateAnInput() {
		Assert.assertTrue(Util.isValidInput("3,0"));
		Assert.assertTrue(Util.isValidInput("2,1"));
		Assert.assertFalse(Util.isValidInput(",0"));
		Assert.assertFalse(Util.isValidInput("4,"));
		Assert.assertFalse(Util.isValidInput("3, 6"));
	}
	
	@Test
	public void shouldReturnColumnValue() {
		Assert.assertSame(Util.getColumnValue("2,3"), 3);
		Assert.assertSame(Util.getColumnValue("3,2"), 2);
	}
	
	@Test
	public void shouldReturnRowValue() {
		Assert.assertSame(Util.getRowValue("4,5"), 4);
		Assert.assertSame(Util.getRowValue("5,4"), 5);
	}
	
	@Test
	public void shouldValidateBoardSize() {
		Assert.assertTrue(Util.isValidBoardSize(3));
		Assert.assertFalse(Util.isValidBoardSize(1));
		Assert.assertFalse(Util.isValidBoardSize(15));
	}

	
}
