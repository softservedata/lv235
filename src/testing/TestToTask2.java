
package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import com.softserve.edu.task2.Task2;



/**
 * @author Ivan
 *
 */
public class TestToTask2 {
    /**
     *
     */
    @Test
    public void testOnNull() {
        Task2 task2 = new Task2();
        ArrayList<Integer> expected = new ArrayList();
        ArrayList<Integer> actual = task2.compute(0, 0);
        assertEquals(expected, actual);
    }

    /**
     *
     */
    @Test
    public void testFirstElementNull() {
        Task2 task2 = new Task2();
        ArrayList<Integer> expected = new ArrayList();
        ArrayList<Integer> actual = task2.compute(0, 5);
        assertEquals(expected, actual);
    }

    /**
    *
    */
   @Test
   public void testSecondElementNull() {
       Task2 task2 = new Task2();
       ArrayList<Integer> expected = new ArrayList();
       ArrayList<Integer> actual = task2.compute(5, 0);
       assertEquals(expected, actual);
   }

   /**
   *
   */
  @Test
  public void testTheSameEllement() {
      Task2 task2 = new Task2();
      int [] arr = {13, 26, 39, 52, 65, 78, 91, 104, 117, 130, 143, 156};
      ArrayList<Integer> expected = new ArrayList();
      for (int i = 0; i < arr.length; i++) {
          expected.add(arr[i]);
      }
      ArrayList<Integer> actual = task2.compute(13, 13);
      assertEquals(expected, actual);
  }

  /**
  *
  */
 @Test
 public void testFirstEllementMoreBigger() {
     Task2 task2 = new Task2();
     int [] arr = {12000, 24000, 36000, 48000};
     ArrayList<Integer> expected = new ArrayList();
     for (int i = 0; i < arr.length; i++) {
         expected.add(arr[i]);
     }
     ArrayList<Integer> actual = task2.compute(12000, 5);
     assertEquals(expected, actual);
 }

 /**
 *
 */
@Test
public void testSecondEllementMoreBigger() {
    Task2 task2 = new Task2();
    int [] arr = {12000, 24000, 36000, 48000};
    ArrayList<Integer> expected = new ArrayList();
    for (int i = 0; i < arr.length; i++) {
        expected.add(arr[i]);
    }
    ArrayList<Integer> actual = task2.compute(5, 12000);
    assertEquals(expected, actual);
}

/**
*
*/
@Test
public void testFirstEllementIsOne() {
   Task2 task2 = new Task2();
   ArrayList<Integer> expected = new ArrayList();
   expected.add(1300);
   ArrayList<Integer> actual = task2.compute(1, 1300);
   assertTrue(expected != actual);
}
}
