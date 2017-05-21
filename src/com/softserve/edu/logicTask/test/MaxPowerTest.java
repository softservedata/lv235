/*@(#)Example.java 1.00 21/04/2017
 *
 * Copyright (c) 1993-2017 Softserve.academy, Inc.
 *
 * This software is the confidential and proprietary information of Softserve.
 */
/**
 *  Package for training.
 */
package com.softserve.edu.logicTask.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.softserve.edu.logicTask.task107.MaxPower;

/**
 * Class to testing MaxPower class (task 107).
 *
 * @version 1.1. 24.04.2017
 * @author Nazar
 *
 * @see com.softserve.edu.logicTask.task107.MaxPower
 *
 * Testing MaxPower (task 107).
 */
public class MaxPowerTest {

    /**
     * Create instance MaxPower.
     */
    private MaxPower maxPower = new MaxPower();

    /**
     * First positive test BVA tech test.
     */
    @Test
    public void test1() {
        int actual = maxPower.calculate(2);
        int expected = 0;
        assertEquals(expected, actual);
    }
    /**
     * Second positive test EP tech test.
     */
    @Test
    public void test2() {
        int actual2 = maxPower.calculate(1070);
        int expected2 = 5;
        assertEquals(expected2, actual2);
    }

    /**
     * Third negative test BVA tech test.
     */
    @Test(expected = NumberFormatException.class)
    public void test3() {
        maxPower.calculate(1);
    }

    /**
     * Fourth negative test EP tech test.
     */
    @Test(expected = NumberFormatException.class)
    public void test4() {
        maxPower.calculate(-1001);
    }
}
