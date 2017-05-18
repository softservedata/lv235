package com.softserve.edu.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.softserve.edu.task1.Task1;

/**
 * This class for JUnit tests for task1.
 * @author Volodymyr Zubchyns'kyi
 */
public class TestsForTask1 {

	private Task1 task1;

	/**
	 * Initialize new class before tests.
	 */
	@Before
	public void init() {
		task1 = new Task1();
	}

	/**
	 * Test equivalence partitioning.
	 */
	@Test
	public void testEquivalence() {
		int expected = 5;
		int actual = task1.findDigits(20000);
        Assert.assertEquals(expected, actual);
	}

	/**
	 * Test boundary value.
	 */
	@Test
	public void testBoundary() {
		int expected = 1;
		int actual = task1.findDigits(1);
        Assert.assertEquals(expected, actual);
	}

	/**
	 * Test for 0.
	 * @throws NumberFormatException
	 */
	@Test (expected = NumberFormatException.class)
	public void testNumberFormat() throws NumberFormatException {
		task1.findDigits(0);
	}

	/**
	 * Test for -1.
	 * @throws NumberFormatException
	 */
	@Test (expected = NumberFormatException.class)
	public void testNegative() throws NumberFormatException {
		task1.findDigits(-1);
	}



}
