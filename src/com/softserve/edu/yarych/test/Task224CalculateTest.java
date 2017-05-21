package com.softserve.edu.yarych.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.softserve.edu.yarych.Task224;

/**
 * JUnit test clas for Task224.
 * @author Андрій
 */
public class Task224CalculateTest {
    /**
     * Target object for testing.
     */
    private Task224 target;
    /**
     * List of expected values.
     */
    private List<Integer> expected;

    /**
     * Method for initializing before each test case.
     */
    @Before
    public void init() {
        target = new Task224();
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
     * Testing calculate() method with natural number 9.
     */
    @Test
    public void testCalculate1() {
        expected.add(1);
        expected.add(3);
        expected.add(9);
        List<Integer> actual = target.calculate(9);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Testing calculate() method with natural number 36.
     */
    @Test
    public void testCalculate2() {
        expected = new LinkedList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(6);
        expected.add(9);
        expected.add(12);
        expected.add(18);
        expected.add(36);
        List<Integer> actual = target.calculate(36);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Testing calculate() method with non-natural number 0.
     */
    @Test
    public void testCalculate3() {
        List<Integer> actual = target.calculate(0);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Testing calculate() method with natural number 1.
     */
    @Test
    public void testCalculate4() {
        expected.add(1);
        List<Integer> actual = target.calculate(1);
        Assert.assertEquals(expected, actual);
    }

}
