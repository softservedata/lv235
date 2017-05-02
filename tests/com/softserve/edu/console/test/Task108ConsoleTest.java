package com.softserve.edu.console.test;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.softserve.edu.console.Task108Console;

public class Task108ConsoleTest {

	private Task108Console t = new Task108Console();

	@BeforeClass
	public static void initClass() {
		System.out.println("Welcome!"); 
	}

	@Before
	public void init() {
		System.out.println("Before ");
	}

	@After
	public void destroy() {
		System.out.println("After ");
	}

	@Test
	public void task108Test() {
		int expected = 4;
		int actual = t.task108(2);
		assertEquals(expected, actual);
	}

	@Test
	public void stringToIntTest() {
		int expected = 9;
		int actual = t.stringToInt("9");
		assertEquals(expected, actual);
	}

	@Test
	public void toConsoleTest() { // test with syso
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		System.out.print(t.toConsole(12));
		String actual = outContent.toString();
		String expected = t.toConsole(12);
		assertEquals(expected, actual);
	}

	@Test
	public void enterNaturalNumberTest() { // test with scanner
		String input = "5";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		assertEquals("5", t.enterNaturalNumber());
		String input2 = "0";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		assertNotEquals("0", t.enterNaturalNumber());
	}

	@Test
	public void isNaturalTest() {
		assertFalse(t.isNatural(0));
	}

	@Test
	public void isNaturalTest2() {
		assertTrue(t.isNatural(13));
	}

	@AfterClass
	public static void destroyClass() {
		System.out.println("Bye bye!");
	}
}
