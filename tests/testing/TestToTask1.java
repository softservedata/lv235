package testing;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.softserve.edu.task1.Task1;


/**
 * Class test to task1.
 * @author Ivan
 *
 */
public class TestToTask1 {

    /**
     * object Task1.
     */
    private Task1 task1;

    /**
     *
     * @throws Exception execute Exception.
     */
    @Before
    public void setUp() throws Exception {
        task1 = new Task1();
    }

    /**
     *
     * @throws Exception execute Exception.
     */
    @After
    public void tearDown() throws Exception {
        task1 = null;
    }

    /**
     * n=m=0 integer.
     */
    @Test
    public void testTrueNull() {
        int expected = 0;
        int actual = task1.getSumDigitsOfNumber(0, 0);
        Assert.assertEquals(expected, actual);
    }

    /**
     * n>0, m=0 integer.
     */
    @Test
    public void testNTrueNull() {
        int expected = 0;
        int actual = task1.getSumDigitsOfNumber(32273, 0);
        Assert.assertEquals(expected, actual);
    }

    /**
     * n>0 m>0 n>m integer.
     */
    @Test
    public void testTrue1() {
        int expected = 5;
        int actual = task1.getSumDigitsOfNumber(10001005, 3);
        Assert.assertEquals(expected, actual);
    }

    /**
     * n>0 m>0 n=m integer.
     */
    @Test
    public void testTrue2() {
        int expected = 14;
        int actual = task1.getSumDigitsOfNumber(3227, 4);
        Assert.assertEquals(expected, actual);
    }

    /**
     * n>0 m>0 n>m integer.
     */
    @Test
    public void testFalse1() {
        int expected = 10;
        int actual = task1.getSumDigitsOfNumber(3417, 3);
        Assert.assertNotEquals(expected, actual);
    }

    /**
     * n>0 m>0 n=m integer.
     */
    @Test
    public void testFalse2() {
        int expected = 13;
        int actual = task1.getSumDigitsOfNumber(3227, 4);
        Assert.assertNotEquals(expected, actual);
    }

    /**
     * test on NumberFormatException.
     */
    @Test(expected = NumberFormatException.class)
    public void firstException() {
        task1.getSumDigitsOfNumber(-1, -2);
    }

    /**
     * test on ArithmeticException.
     */
    @Test(expected = ArithmeticException.class)
    public void secondException() {
        task1.getSumDigitsOfNumber(548644, 8);
    }
}
