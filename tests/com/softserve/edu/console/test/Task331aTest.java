package com.softserve.edu.console.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import com.softserve.edu.dto.Task331aDto;
import com.softserve.edu.main.Task331a;

/**
 * Test for task #331a.
 */
public class Task331aTest {
	/**
	 * Task331a instance
	 */
	private Task331a task331a = new Task331a();

	/**
	 * Boundary Value lowest input.
	 */
	@Test
	public void getListOfEqualSquareTrippleTest() {
		List<Task331aDto> actual = task331a.getListOfEqualSquareTripple(1);
		Assert.assertEquals(Collections.emptyList(), actual);
	}

	/**
	 * Boundary Value highest input.
	 */
	@Test
	public void getListOfEqualSquareTrippleTest1() {
		List<Task331aDto> expected = new ArrayList<>();
		expected.add(new Task331aDto(1, 1, 46341));
		List<Task331aDto> actual = task331a
				.getListOfEqualSquareTripple(Integer.MAX_VALUE);
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Test with zero.
	 */
	@Test
	public void getListOfEqualSquareTrippleTest2() {
		List<Task331aDto> actual = task331a.getListOfEqualSquareTripple(0);
		Assert.assertEquals(Collections.emptyList(), actual);
	}

	/**
	 * Test with negative number.
	 */
	@Test
	public void getListOfEqualSquareTrippleTest3() {
		List<Task331aDto> actual = task331a.getListOfEqualSquareTripple(-1);
		Assert.assertEquals(Collections.emptyList(), actual);
	}

	/**
	 * Test with negative number.
	 */
	@Test
	public void getListOfEqualSquareTrippleTest4() {
		List<Task331aDto> actual = task331a.getListOfEqualSquareTripple(-1999);
		Assert.assertEquals(Collections.emptyList(), actual);
	}

	/**
	 * Test with 31.
	 */
	@Test
	public void getListOfEqualSquareTrippleTest5() {
		List<Task331aDto> actual = task331a.getListOfEqualSquareTripple(31);
		Assert.assertEquals(Collections.emptyList(), actual);
	}

	/**
	 * Test with 1000.
	 */
	@Test
	public void getListOfEqualSquareTrippleTest6() {
		List<Task331aDto> expected = new ArrayList<>();
		expected.add(new Task331aDto(6, 8, 30));
		List<Task331aDto> actual = task331a.getListOfEqualSquareTripple(1000);
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Test with 4568.
	 */
	@Test
	public void getListOfEqualSquareTrippleTest7() {
		List<Task331aDto> expected = new ArrayList<>();
		expected.add(new Task331aDto(4, 14, 66));
		List<Task331aDto> actual = task331a.getListOfEqualSquareTripple(4568);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void getListOfEqualSquareTrippleTest8() {
		List<Task331aDto> expected = new ArrayList<>();
		expected.add(new Task331aDto(4, 77, 80));
		List<Task331aDto> actual = task331a.getListOfEqualSquareTripple(12345);
		Assert.assertEquals(expected, actual);
	}

}
