package com.softserve.edu.tests.task2;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import com.softserve.edu.task2.Task2;



/**
 * @author IRudyk
 * Class contains tests to Task2.
 */
public class TestToTask2 {

    /**
     * object to Task2.
     */
    private Task2 task2 = new Task2();

    /**
     * test for resalts is found.
     */
    @Test
    public void testResultIsFound() {
      List<Integer> expected = DataForTestToTask2.
              DATA_TO_RESULT_IS_FOUND.getExpectedResult();
      List<Integer> actual = task2.getCommonMultiples(
              DataForTestToTask2.DATA_TO_RESULT_IS_FOUND.getParameterN(),
              DataForTestToTask2.DATA_TO_RESULT_IS_FOUND.getParameterM());
      assertEquals(expected, actual);
    }


   /**
    * test for resalts is found.
    */
   @Test
   public void testResultIsNotFound() {
     List<Integer> expected = DataForTestToTask2.
             DATA_TO_RESULT_IS_NOT_FOUND.getExpectedResult();
     List<Integer> actual = task2.getCommonMultiples(
             DataForTestToTask2.DATA_TO_RESULT_IS_NOT_FOUND.getParameterN(),
             DataForTestToTask2.DATA_TO_RESULT_IS_NOT_FOUND.getParameterM());
     assertEquals(expected, actual);
   }


    /**
     * test for n < 0.
     */
    @Test(expected = NumberFormatException.class)
    public void testIsNotNaturalN() {
        task2.getCommonMultiples(
                DataForTestToTask2.DATA_TO_IS_NOT_NATURAL_N.getParameterN(),
                DataForTestToTask2.DATA_TO_IS_NOT_NATURAL_N.getParameterM());
    }

    /**
     * test for m < 0.
     */
    @Test(expected = NumberFormatException.class)
    public void testIsNotNaturalM() {
        task2.getCommonMultiples(
                DataForTestToTask2.DATA_TO_IS_NOT_NATURAL_M.getParameterN(),
                DataForTestToTask2.DATA_TO_IS_NOT_NATURAL_M.getParameterM());
    }
}
