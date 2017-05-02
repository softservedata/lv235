package com.softserve.edu.console.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.main.IsNotNaturalNumberException;
import com.softserve.edu.main.Task108Ver2;

public class Task108Ver2Test {
	private Task108Ver2 task108Ver2 = new Task108Ver2();

	@BeforeClass
	public static void initClass() {
		System.out.println("Welcome!");
	}

	@Before
	public void init() {
		System.out.println("Before ");
	}

	@Test
	public void task108Test() throws IsNotNaturalNumberException {
		int expected = 4;
		int actual = task108Ver2.task108(2);
		assertEquals(expected, actual);
	}

	@Test(expected = IsNotNaturalNumberException.class)
	public void task108Test2() throws IsNotNaturalNumberException {
		int notNatural = 0;
		task108Ver2.task108(notNatural);
	}

	@After
	public void destroy() {
		System.out.println("After ");
	}

	@AfterClass
	public static void destroyClass() {
		System.out.println("Bye bye!");
	}
}
