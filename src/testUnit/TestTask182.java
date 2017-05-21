/**
 * 
 */
package testUnit;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import task182.Task182;

/**
 * @author Andriy
 *
 */
public class TestTask182 {
	Task182 task182 = new Task182();
	@Test
	public void getNumberAmountOfMemberSequence1() throws Exception {
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(10);
		expected.add(10);
		ArrayList<Integer> actual = Task182.getNumberAmountOfMemberSequence(3480, 8);
		
		Assert.assertEquals(expected, actual);

	}

	@Test(expected = Exception.class)
	public void getNumberAmountOfMemberSequence2() throws Exception {
		Task182.getNumberAmountOfMemberSequence(0, 0);
	}

}


//@Test
//public void testPrintCalculatedValues() throws Exception {
//	System.out.println("show result1");
//	int[] expected = new int[] { 3480, 8 };
//	int[] actual = Task182.getNumberAmountOfMemberSequence(10, 10);
//	assertArrayEquals(expected, actual);
//}