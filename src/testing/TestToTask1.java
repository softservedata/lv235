package testing;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.task1.Task1;



/**
 * Class test to task1.
 * @author Ivan
 *
 */
public class TestToTask1 {
    /**
     *
     */
    private Task1 task1 = new Task1();
    /**
     * method setUpBeforeClass().
     * @throws Exception execute Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * method tearDownAfterClass().
     * @throws Exception execute Exception.
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     *
     * @throws Exception execute Exception.
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     *
     * @throws Exception execute Exception.
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * n=m=0 integer.
     */
    @Test
    public void testTrueNull() {
        int expected = 0;
        int actual = task1.compute(0, 0);
        assertEquals(expected, actual);
    }

    /**
     * n>0, m=0 integer.
     */
    @Test
    public void testNTrueNull() {
        int expected = 0;
        int actual = task1.compute(32273, 0);
        assertEquals(expected, actual);
    }

    /**
     * n>0 m>0 n>m integer.
     */
    @Test
    public void testTrue1() {
        int expected = 5;
        int actual = task1.compute(10001005, 3);
        assertEquals(expected, actual);
    }

    /**
     * n>0 m>0 n=m integer.
     */
    @Test
    public void testTrue2() {
        int expected = 14;
        int actual = task1.compute(3227, 4);
        assertEquals(expected, actual);
    }

    /**
     * n>0 m>0 n>m integer.
     */
    @Test
    public void testFalse1() {
        int expected = 10;
        int actual = task1.compute(3417, 3);
        assertNotEquals(expected, actual);
    }

    /**
     * n>0 m>0 n=m integer.
     */
    @Test
    public void testFalse2() {
        int expected = 13;
        int actual = task1.compute(3227, 4);
        assertNotEquals(expected, actual);
    }
}
