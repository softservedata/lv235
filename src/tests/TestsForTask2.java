package tests;

import org.junit.Assert;
import org.junit.Test;

import task2.Task2;

public class TestsForTask2 {


	@Test
	public void testTask21() {
		int[] expected = {120, 100, 16, 4, 0 };
		Task2 task2 = new Task2();
		int[] actual = task2.findMatch(120);
        Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testTask22() {
		int[] expected = {0, 0, 0, 0, 0 };
		Task2 task2 = new Task2();
		int[] actual = task2.findMatch(0);
        Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testTask23() {
		int[] expected = {100, 100, 0, 0, 0 };
		Task2 task2 = new Task2();
		int[] actual = task2.findMatch(100);
        Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testTask24() {
		int[] expected = {7, 4, 1, 1, 1 };
		Task2 task2 = new Task2();
		int[] actual = task2.findMatch(7);
        Assert.assertArrayEquals(expected, actual);
	}
}
