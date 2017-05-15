package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import task1.Task1;

public class TestsForTask1 {

	private Task1 task1;

	@Before
	public void init() {
		task1 = new Task1();
	}

	@Test
	public void testEquivalence() {
		int expected = 5;
		int actual = task1.findDigits(20000);
        Assert.assertEquals(expected, actual);
	}

	@Test
	public void test() {
		int expected = 1;
		int actual = task1.findDigits(1);
        Assert.assertEquals(expected, actual);
	}

	@Test (expected = NumberFormatException.class)
	public void testBoundary() throws NumberFormatException {
		task1.findDigits(0);
	}

	@Test (expected = NumberFormatException.class)
	public void testNegative() throws NumberFormatException {
		task1.findDigits(-1);
	}



}
