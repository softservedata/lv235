package com.softserve.edu.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.softserve.edu.task3.Task3;

/**
 * This class for JUnit tests for task3.
 * @author Volodymyr Zubchyns'kyi
 */
public class TestsForTask3 {

	private Task3 task3;

	/**
	 * Initialize new class before tests.
	 */
	@Before
	public void init() {
		task3 = new Task3();
	}

	/**
	 * Test equivalence partitioning.
	 */
	@Test
	public void testEquivalence() {
		List<Integer> expected = new ArrayList<>();
		expected.add(12);
		expected.add(18);
		List<Integer> actual = task3.countMultipleAliquant(10, 10);
        Assert.assertEquals(expected, actual);
	}

	/**
	 * Test when we can`t find elements.
	 * @throws NoSuchElementException
	 */
	@Test (expected = NoSuchElementException.class)
	public void testNoElements() throws NoSuchElementException {
		task3.countMultipleAliquant(1, 1);
	}

	/**
	 * Test for 0.
	 * @throws NumberFormatException
	 */
	@Test (expected = NumberFormatException.class)
	public void testNumberFormat() throws NumberFormatException {
		task3.countMultipleAliquant(0, 0);
	}

	/**
	 * Test equivalence partitioning.
	 */
	@Test
	public void test() {
		List<Integer> expected = new ArrayList<>();
		expected.add(3);
		List<Integer> actual = task3.countMultipleAliquant(1, 3);
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Test for -1 for n.
	 */
	@Test (expected = NumberFormatException.class)
	public void testNumberFormat2() throws NumberFormatException {
		task3.countMultipleAliquant(-1, 10);
	}
	/**
	 * Test for -1 for a.
	 */
	@Test (expected = NumberFormatException.class)
	public void testNumberFormat3() throws NumberFormatException {
		task3.countMultipleAliquant(10, -1);
	}

	/**
	 * Test for -1 for n and a.
	 */
	@Test (expected = NumberFormatException.class)
	public void testNumberFormat4() throws NumberFormatException {
		task3.countMultipleAliquant(-1, -1);
	}
}
