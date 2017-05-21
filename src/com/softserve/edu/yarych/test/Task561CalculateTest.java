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
public class Task561CalculateTest {
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
     * Testing calculate() method with natural number 25.
     */
    @Test
    public void testCalculate3() {
        expected.add(1);
        expected.add(5);
        expected.add(6);
        expected.add(25);
        List<Integer> actual = target.calculate(25);
        Assert.assertEquals(expected, actual);
    }

}
