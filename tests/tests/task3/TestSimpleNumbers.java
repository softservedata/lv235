package tests.task3;

import org.junit.Assert;
import org.junit.Test;

import com.softserve.edu.task3.Task3;
/**
 * Class contains tests for testing is neumber simple.
 * @author Ivan
 */
public class TestSimpleNumbers {
    /**
     * Number 4.
     */
    public static final int NUMBER_FOUR = 4;

    /**
     * Number 5.
     */
    public static final int NUMBER_FIVE = 5;

    /**
     * Number 29.
     */
    public static final int NUMBER_TWENTY_NINE = 29;

    /**
     * Number 5.
     */
    public static final int NUMBER_FIFTEEN = 15;

    /**
     * object Task3.
     */
    private Task3 task3 = new Task3();

    /**
     * Number is simle > 5.
     */
    @Test
    public void simpleMoreFive() {
        Assert.assertTrue(task3.isSimpleNumber(NUMBER_TWENTY_NINE));
    }

    /**
     * Number is not simle > 5.
     */
    @Test
    public void notSimpleMoreFive() {
        Assert.assertFalse(task3.isSimpleNumber(NUMBER_FIFTEEN));
    }

    /**
     * Number is simle < 6.
     */
    @Test
    public void simpleLessSix() {
        Assert.assertTrue(task3.isSimpleNumber(NUMBER_FIVE));
    }

    /**
     * Number is simle < 6.
     */
    @Test
    public void notSimleLessSix() {
        Assert.assertFalse(task3.isSimpleNumber(NUMBER_FOUR));
    }

    /**
     * Number is simle = 2.
     */
    @Test
    public void simleTwo() {
        Assert.assertTrue(task3.isSimpleNumber(2));
    }

    /**
     * Number is not simle < 2.
     */
    @Test
    public void notSimleLessTwo() {
        Assert.assertFalse(task3.isSimpleNumber(1));
    }

  /**
   * Number is not natural.
   */
   @Test (expected = NumberFormatException.class)
   public void notNaturalNumber() {
       task3.isSimpleNumber(-1);
   }



}
