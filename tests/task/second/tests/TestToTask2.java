package task.second.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.softserve.edu.task2.Task2;



/**
 * @author IRudyk
 *
 */
public class TestToTask2 {

    /**
     * object to Task1.
     */
    private Task2 task2 = new Task2();

    /**
     * test on null value two operands.
     */
    @Test
    public void testOnNull() {
        List<Integer> expected = new ArrayList();
        List<Integer> actual = task2.getCommonMultiples(0, 0);
        assertEquals(expected, actual);
    }

    /**
     * test on null value first operand.
     */
    @Test
    public void testFirstElementNull() {
        List<Integer> expected = new ArrayList();
        List<Integer> actual = task2.getCommonMultiples(0, 5);
        assertEquals(expected, actual);
    }

    /**
    * test on null value second operand.
    */
   @Test
   public void testSecondElementNull() {
       List<Integer> expected = new ArrayList();
       List<Integer> actual = task2.getCommonMultiples(5, 0);
       assertEquals(expected, actual);
   }

  /**
  * test on big value first operand.
  */
 @Test
 public void testFirstEllementMoreBigger() {
     int [] arr = {12000, 24000, 36000, 48000};
     List<Integer> expected = new ArrayList();
     for (int i = 0; i < arr.length; i++) {
         expected.add(arr[i]);
     }
     List<Integer> actual = task2.getCommonMultiples(12000, 5);
     assertEquals(expected, actual);
 }

 /**
 * test on big value second operand.
 */
@Test
public void testSecondEllementMoreBigger() {
    int [] arr = {12000, 24000, 36000, 48000};
    List<Integer> expected = new ArrayList();
    for (int i = 0; i < arr.length; i++) {
        expected.add(arr[i]);
    }
    List<Integer> actual = task2.getCommonMultiples(5, 12000);
    assertEquals(expected, actual);
}

/**
* test on first element is 1.
*/
@Test
public void testFirstEllementIsOne() {
   List<Integer> expected = new ArrayList();
   expected.add(1300);
   List<Integer> actual = task2.getCommonMultiples(1, 1300);
   assertTrue(expected != actual);
}

/**
 * test on ArithmeticException.
 */
@Test(expected = NumberFormatException.class)
public void secondException() {
    task2.getCommonMultiples(-2, -2);
}


}
