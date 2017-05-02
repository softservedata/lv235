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
    Task1 task1 = new Task1();
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
     * n>m integer.
     */
    @Test
    public void testPositive() {
        int expected = 13;
        int actual = task1.compute(7484153, 4);
        assertTrue(expected == actual);
    }

    /**
     * n=m integer.
     */
    @Test
    public void testPositive2() {
        int expected = 23;
        int actual = task1.compute(32273254, 6);
        assertTrue(expected == actual);
    }

    /**
     * n=m integer.
     */
    @Test
    public void testPositive3() {
        int expected = 5;
        int actual = task1.compute(10001005, 3);
        assertTrue(expected == actual);
    }

    /**
     * n>0 integer m=0.
     */
    @Test
    public void testNull1() {
        int expected = 0;
        int actual = task1.compute(32273254, 0);
        assertTrue(expected == actual);
    }
}
