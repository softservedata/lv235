package com.softserve.edu.console.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.softserve.edu.main.IsNotNaturalNumberException;
import com.softserve.edu.main.Task554;

public class Task554Test {
	Task554 task554 = new Task554();

	@Test
	public void task554Test() throws IsNotNaturalNumberException {
		String expected = "[]";
		String actual = task554.task554(1);
		assertEquals(expected, actual);
	}

	@Test
	public void task554Test2() throws IsNotNaturalNumberException {
		String expected = "[a=3 b=4 c=5\n]";
		String actual = task554.task554(5);
		assertEquals(expected, actual);
	}

	@Test(expected = IsNotNaturalNumberException.class)
	// test with exception
	public void task554Test3() throws IsNotNaturalNumberException {
		int notNatural = 0;
		task554.task554(notNatural);
	}

	@Test()
	// test with exception ver 2
	public void task554Test4() throws IsNotNaturalNumberException {
		int notNatural = 0;
		try {
			task554.task554(notNatural);
			assert false;
		} catch (IsNotNaturalNumberException e) {
			assert true;
		}
	}

}
