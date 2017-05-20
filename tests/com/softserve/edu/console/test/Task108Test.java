package com.softserve.edu.console.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.softserve.edu.dto.Task108Dto;
import com.softserve.edu.main.IsNotNaturalNumberException;
import com.softserve.edu.main.Task108;

public class Task108Test {
	Task108 task108 = new Task108();

	@Test
	public void task108Test() throws IsNotNaturalNumberException {
		Task108Dto expected = new Task108Dto(4);
		Task108Dto actual = task108.compute(2);
		assertEquals(expected, actual);
	}

	@Test(expected = IsNotNaturalNumberException.class)
	public void task108Test2() throws IsNotNaturalNumberException {
		int notNatural = 0;
		task108.compute(notNatural);
	}

	@Test
	public void task108Test3() throws IsNotNaturalNumberException {
		Task108Dto expected = new Task108Dto(2);
		Task108Dto actual = task108.compute(1);
		assertEquals(expected, actual);
	}

	@Test
	public void task108Test4() throws IsNotNaturalNumberException {
		Task108Dto expected = new Task108Dto(2048);
		Task108Dto actual = task108.compute(1024);
		assertEquals(expected, actual);
	}

	@Test(expected = IsNotNaturalNumberException.class)
	public void task108Test5() throws IsNotNaturalNumberException {
		int notNatural = -1;
		task108.compute(notNatural);
	}

	@Test
	public void task108Test6() throws IsNotNaturalNumberException {
		Task108Dto expected = new Task108Dto(2147483647);
		Task108Dto actual = task108.compute(Integer.MAX_VALUE - 1);
		assertEquals(expected, actual);
	}

}
