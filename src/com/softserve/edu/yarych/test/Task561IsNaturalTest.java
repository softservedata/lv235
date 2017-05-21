package com.softserve.edu.yarych.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.softserve.edu.yarych.Task561;

/**
 * JUnit test class for Task561.
 * @author Андрій
 */
public class Task561IsNaturalTest {
    /**
     * Target object for testing.
     */
    private Task561 target;
    /**
     * List of expected values.
     */
    private List<Integer> expected;

    /**
     * Method for initializing before each test case.
     */
    @Before
    public void init() {
        target = new Task561();
        expected = new LinkedList<Integer>();
    }

    /**
     * Method for initializing after each test case.
     */
    @After
    public void tearDown() {
        target = null;
    }

    /**
     * Testing isNatural() method with non-natural number -1.
     */
    @Test
    public void testNatural1() {
        boolean actual = target.isNatural(-1);
        Assert.assertFalse(actual);
    }

    /**
     * Testing isNatural() method with non-natural number 0.
     */
    @Test
    public void testNatural2() {
        boolean actual = target.isNatural(0);
        Assert.assertFalse(actual);
    }

    /**
     * Testing isNatural() method with natural number 1.
     */
    @Test
    public void testNatural3() {
        boolean actual = target.isNatural(1);
        Assert.assertTrue(actual);
    }

}
