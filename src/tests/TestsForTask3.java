package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import task3.Task3;

public class TestsForTask3 {

	private Task3 task3;

	@Before
	public void init() {
		task3 = new Task3();
	}

	@Test
	public void testEquivalence() {
		List<Integer> expected = new ArrayList<>();
		expected.add(12);
		expected.add(18);
		List<Integer> actual = task3.countMultipleAliquant(10, 10);
        Assert.assertEquals(expected, actual);
	}

	@Test (expected = NoSuchElementException.class)
	public void testNoElements() throws NoSuchElementException {
		task3.countMultipleAliquant(1, 1);
	}

	@Test (expected = NumberFormatException.class)
	public void testNumberFormat() throws NumberFormatException {
		task3.countMultipleAliquant(0, 0);
	}

	@Test
	public void test() {
		List<Integer> expected = new ArrayList<>();
		expected.add(3);
		List<Integer> actual = task3.countMultipleAliquant(1, 3);
		Assert.assertEquals(expected, actual);
	}

}
