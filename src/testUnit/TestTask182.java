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
	public void testPrintCalculatedValues() throws Exception {
		System.out.println("show result1");
		int[] expected = new int[] { 3480, 8 };
		int[] actual = Task182.printCalculatedValues(10, 10);
		assertArrayEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void testPrintCalculatedValues2() throws Exception {
		Task182.printCalculatedValues(0, 0);
	}

}
