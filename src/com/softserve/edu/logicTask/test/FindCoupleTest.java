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
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.softserve.edu.logicTask.task243A.Couple;
import com.softserve.edu.logicTask.task243A.OneCouple;

/**
 * Class to testing FindCouple class (task 243a).
 *
 * @version 1.1. 24.04.2017
 * @author Nazar
 *
 * @see com.softserve.edu.logicTask.task243A.OneCouple
 * @see com.softserve.edu.logicTask.task243A.Couple
 *      Testing MaxPower (task 243a).
 */
public class FindCoupleTest {

    /**
     * Create instance OneCouple class.
     */
    private OneCouple oneCouple = new OneCouple();

    /**
     * positive test BVA tech test.
     */
    @Test
    public void test() {
        OneCouple findCouple = new OneCouple();
        Couple actual = findCouple.find(1);
        assertTrue(actual.isEmpty());
    }

    /**
     * positive test EP tech test.
     */
    @Test
    public void test2() {
        OneCouple findCouple = new OneCouple();
        Couple actual2 = findCouple.find(17);
        Couple expected2 = new Couple(4, 1);
        assertEquals(expected2, actual2);
    }

    /**
     * negative test BVA tech test.
     * @throws NumberFormatException if incoming number less then 1.
     */
    @Test(expected = NumberFormatException.class)
    public void test3() {
        oneCouple.find(0);
    }
    /**
     * negative test EP tech test.
     * @throws NumberFormatException if incoming number less then 1.
     */
    @Test(expected = NumberFormatException.class)
    public void test4() {
        oneCouple.find(-1001);
    }
}
