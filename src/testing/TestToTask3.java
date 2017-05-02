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
    *
    */
   @Test
   public void testNBigg() {
       Task3 task3 = new Task3();
       int [] arr = {2, 7, 11, 13, 17, 19, 23, 29};
       ArrayList<Integer> expected = new ArrayList();
       for (int i = 0; i < arr.length; i++) {
           expected.add(arr[i]);
       }
       ArrayList<Integer> actual = task3.compute(1000000000);
       assertEquals(expected, actual);
   }

   /**
   *
   */
  @Test
  public void testNSmall() {
      Task3 task3 = new Task3();
      int [] arr = {2};
      ArrayList<Integer> expected = new ArrayList();
      for (int i = 0; i < arr.length; i++) {
          expected.add(arr[i]);
      }
      ArrayList<Integer> actual = task3.compute(25);
      assertEquals(expected, actual);
  }

  /**
  *
  */
 @Test
 public void testNNull() {
     Task3 task3 = new Task3();
     ArrayList<Integer> expected = new ArrayList();
     ArrayList<Integer> actual = task3.compute(0);
     assertEquals(expected, actual);
 }
}
