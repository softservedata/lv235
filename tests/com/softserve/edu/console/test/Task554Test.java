package com.softserve.edu.console.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.softserve.edu.dto.Task554Dto;
import com.softserve.edu.main.Task554;

/**
 * Task #554. Given a positive integer n. Get all the triples of natural
 * numbers, each of which does not exceed n. a^2+b^2=c^2 (a<=b<=c<=n)
 */
public class Task554Test {
	Task554 task554 = new Task554();

	@Test
	public void task554Test() {
		List<Task554Dto> actual = task554.compute(1);
		assertEquals(Collections.emptyList(), actual);
	}

	@Test
	public void task554Test2() {
		List<Task554Dto> expected = new ArrayList<>();
		expected.add(new Task554Dto(3, 4, 5));
		List<Task554Dto> actual = task554.compute(5);
		assertEquals(expected, actual);
	}

	@Test
	public void task554Test3() {
		List<Task554Dto> actual = task554.compute(0);
		assertEquals(Collections.emptyList(), actual);
	}

	@Test
	public void task554Test4() {
		int notNatural = 0;
	}

}
