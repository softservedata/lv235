/**
 * 
 */
package testUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import pyrogov.Task182;

/**
 * @author Andriy
 *
 */
public class TestTask182 {

	@Test
	public void testPrintCalculatedValues() {
		System.out.println("show result");
		int expected = 3480;
		int actual = Task182.printCalculatedValues(10, 10);
		assertEquals(expected, actual);

	}

	@Test
	public void testPrintCalculatedValues2() {
		System.out.println("show result");
		int expected = 26950;
		int actual = Task182.printCalculatedValues(25, 25);
		assertEquals(expected, actual);

	}

}
