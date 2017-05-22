package tests.task1;



import org.junit.Assert;
import org.junit.Test;

import com.softserve.edu.task1.Task1;

/**
 * Class test to task1.
 * @author IRudyk
 *
 */
public class TestToTask1 {

    /**
     * object Task1.
     */
    private Task1 task1 = new Task1();

    /**
     * n, m natural n diits(n) > m.
     */
    @Test
    public void testIsPositiveResult1() {
        int expected = DataForTestToTask1.
                DATA_TO_POSITIVE_RESULT_1.getExpectedResult();
        int actual = task1.getSumDigitsOfNumber(DataForTestToTask1.
                DATA_TO_POSITIVE_RESULT_1.getParameterN(), DataForTestToTask1.
                DATA_TO_POSITIVE_RESULT_1.getParameterM());
        Assert.assertEquals(expected, actual);
    }

    /**
     * n, m natural n diits(n) = m.
     */
    @Test
    public void testIsPositiveResult2() {
        int expected = DataForTestToTask1.
                DATA_TO_POSITIVE_RESULT_2.getExpectedResult();
        int actual = task1.getSumDigitsOfNumber(DataForTestToTask1.
                DATA_TO_POSITIVE_RESULT_2.getParameterN(), DataForTestToTask1.
                DATA_TO_POSITIVE_RESULT_2.getParameterM());
        Assert.assertEquals(expected, actual);
    }

    /**
     * n, m natural n diits(n) < m.
     */
    @Test(expected = ArithmeticException.class)
    public void testMTooBig() {
        task1.getSumDigitsOfNumber(
                DataForTestToTask1.DATA_TO_TEST_M_TOO_BIG.getParameterN(),
                DataForTestToTask1.DATA_TO_TEST_M_TOO_BIG.getParameterM());
    }

    /**
     * n is not natural.
     */
    @Test(expected = NumberFormatException.class)
    public void testIsNNotNatural() {
        task1.getSumDigitsOfNumber(
                DataForTestToTask1.DATA_TO_N_NOT_NATURAL.getParameterN(),
                DataForTestToTask1.DATA_TO_N_NOT_NATURAL.getParameterM());
    }

    /**
     * m is not natural.
     */
    @Test(expected = NumberFormatException.class)
    public void testIsMNotNatural() {
        task1.getSumDigitsOfNumber(
                DataForTestToTask1.DATA_TO_M_NOT_NATURAL.getParameterN(),
                DataForTestToTask1.DATA_TO_M_NOT_NATURAL.getParameterM());
    }
}
