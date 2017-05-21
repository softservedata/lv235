package com.softserve.edu.yarych.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.softserve.edu.yarych.Task325;

/**
 * JUnit test class for Task325.
 * @author Андрій
 */
public class Task325CalculateTest {
    /**
     * Target object for testing.
     */
    private Task325 target;
    /**
     * List of expected values.
     */
    private List<Integer> expected;

    /**
     * Method for initializing before each test case.
     */
    @Before
    public void init() {
        target = new Task325();
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
     * Testing calculate() method with non-natural number 0.
     */
    @Test
    public void testCalculate1() {
        List<Integer> actual = target.calculate(0);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Testing calculate() method with natural number 1.
     */
    @Test
    public void testCalculate2() {
        expected.add(1);
        List<Integer> actual = target.calculate(1);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Testing calculate() method with natural number 99.
     */
    @Test
    public void testCalculate3() {
        expected.add(1);
        expected.add(3);
        expected.add(11);
        List<Integer> actual = target.calculate(99);
        Assert.assertEquals(expected, actual);
    }
}
