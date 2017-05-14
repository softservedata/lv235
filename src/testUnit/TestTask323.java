/**
 * 
 */
package testUnit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pyrogov.Task323;

/**
 * @author Andriy
 *
 */
public class TestTask323 {

	/**
	 * Test method for {@link pyrogov.Task323#gcd(int, int)}.
	 */
	@Test
	public void testGcd() {
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(2);
		expected.add(3);
		expected.add(4);
		List<Integer> actual = Task323.getCoprimeIntegers(5);
		assertEquals(expected,actual);
		
	}

	@Test
	public void testGcd2() {
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(3);
		expected.add(7);
		expected.add(9);
		List<Integer> actual = Task323.getCoprimeIntegers(10);
		assertEquals(expected,actual);
}
}
