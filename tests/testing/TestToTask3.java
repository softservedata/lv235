/**
 * 
 */
package testing;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.softserve.edu.task3.Task3;

/**
 * @author Ivan
 *
 */
public class TestToTask3 {

    /**
     * object to Task3.
     */
    private Task3 task3 = new Task3();

    /**
    * test on big value n.
    */
   @Test
   public void testNBigg() {
       int [] arr = {2, 7, 11, 13, 17, 19, 23, 29};
       ArrayList<Integer> expected = new ArrayList();
       for (int i = 0; i < arr.length; i++) {
           expected.add(arr[i]);
       }
       ArrayList<Integer> actual = task3.getMarsenNumbers(1000000000);
       assertEquals(expected, actual);
   }

   /**
   *test on small value n.
   */
  @Test
  public void testNSmall() {
      int [] arr = {2};
      ArrayList<Integer> expected = new ArrayList();
      for (int i = 0; i < arr.length; i++) {
          expected.add(arr[i]);
      }
      ArrayList<Integer> actual = task3.getMarsenNumbers(25);
      assertEquals(expected, actual);
  }

  /**
  *test on null value n.
  */
 @Test
 public void testNNull() {
     ArrayList<Integer> expected = new ArrayList();
     ArrayList<Integer> actual = task3.getMarsenNumbers(0);
     assertEquals(expected, actual);
 }

/**
  *test on NumberFormatException.
  */
 @Test(expected = NumberFormatException.class)
 public void exceptionFirst() {
     task3.getMarsenNumbers(-2);
 }

}
