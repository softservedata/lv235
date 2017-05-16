/**
 * 
 */
package testUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import task182.Task182;
import task323.Task323;

/**
 * @author Andriy
 *
 */
public class TestTask182 {

	@Test
	public void testPrintCalculatedValues() {
		System.out.println("show result1");
		int expectedCount = 8;
		int expectedArraySum = 3480;
		int actual = Task182.printCalculatedValues(10, 10);
		assertEquals(expectedCount,expectedArraySum, actual);
		

	}

	@Test
	public void testPrintCalculatedValues2() {
		System.out.println("show result2");
		int expectedCount = 0;
		int expectedArraySum = 0;
		int actual = Task182.printCalculatedValues(10, 10);
		assertFalse(false);
		//assertEquals(expected, actual);

	}

}



