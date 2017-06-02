
package com.softserve.edu.tests.task3;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import com.softserve.edu.task3.Task3;

/**
 * @author Ivan
 */
public class TestToTask3 {

    /**
     * object to Task3.
     */
    private Task3 task3 = new Task3();

    /**
     * test for resalts is found.
     */
    @Test
    public void testResultIsFound() {
      List<Integer> expected = DataForTestToTask3.
              RESULTS_IS_FOUND.getExpectedResult();
      List<Integer> actual = task3.getMarsenNumbers(
              DataForTestToTask3.RESULTS_IS_FOUND.getParameterN());
      Assert.assertEquals(expected, actual);
    }

    /**
     * test for resalts is not.
     */
    @Test
    public void testResultIsNotFound() {
      List<Integer> expected = DataForTestToTask3.
              RESULTS_IS_NOT_FOUND.getExpectedResult();
      List<Integer> actual = task3.getMarsenNumbers(
              DataForTestToTask3.RESULTS_IS_NOT_FOUND.getParameterN());
      Assert.assertEquals(expected, actual);
    }

    /**
     * test number is not natural.
     */
    @Test (expected = NumberFormatException.class)
    public void testIsNotNaturalNumber() {
        task3.getMarsenNumbers(-1);
    }
}
