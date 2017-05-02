package com.softserve.edu.console.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.softserve.edu.main.IsNotNaturalNumberException;
import com.softserve.edu.main.Task331a;

public class Task331aTest {
	Task331a task331a = new Task331a();

	@Test
	public void task331aTest() throws IsNotNaturalNumberException {
		String expected = "[2, 2, 2]";
		String actual = task331a.task331a(12);
		assertEquals(expected, actual);
	}

	@Test(expected = IsNotNaturalNumberException.class)
	public void task331aTest2() throws IsNotNaturalNumberException {
		int notNatural = 0;
		task331a.task331a(notNatural);
	}

	@Test
	public void task331aTest3() throws IsNotNaturalNumberException {
		String expected = "Impossible to represent a number\n";
		String actual = task331a.task331a(31);
		assertEquals(expected, actual);
	}
}
