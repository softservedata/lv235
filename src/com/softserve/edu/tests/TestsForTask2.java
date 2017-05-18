package com.softserve.edu.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.softserve.edu.task2.Properties;
import com.softserve.edu.task2.Task2;

/**
 * This class for JUnit tests for task2.
 * @author Volodymyr Zubchyns'kyi
 */
public class TestsForTask2 {

	private Task2 task2;

	/**
	 * Initialize new class before tests.
	 */
	@Before
	public void init() {
		task2 = new Task2();
	}

	/**
	 * Test equivalence partitioning.
	 */
	@Test
	public void testEquivalence() {
		List<Properties> expected = new ArrayList<>();
		expected.add(new Properties(120, 100, 16, 4, 0));
		List<Properties> actual = task2.findMatch(120);
        Assert.assertEquals(expected, actual);
	}

	/**
	 * Test boundary value.
	 */
	@Test
	public void testBoundary() {
		List<Properties> expected = new ArrayList<>();
		expected.add(new Properties(1, 1, 0, 0, 0));
		List<Properties> actual = task2.findMatch(1);
        Assert.assertEquals(expected, actual);
	}

	/**
	 * Test for 0.
	 * @throws NumberFormatException
	 */
	@Test (expected = NumberFormatException.class)
	public void testNumberFormat() throws NumberFormatException {
	 task2.findMatch(0);
	}

	/**
	 * Test for -1.
	 * @throws NumberFormatException
	 */
	@Test (expected = NumberFormatException.class)
	public void testNumberFormat2() throws NumberFormatException {
	 task2.findMatch(-1);
	}

	/**
	 * Test to find numbers, where we can`t calculate value.
	 * @throws ArithmeticException
	 */
	@Test (expected =  ArithmeticException.class)
	public void testArithmetic() throws ArithmeticException {
	task2.findMatch(1003);
	}
}