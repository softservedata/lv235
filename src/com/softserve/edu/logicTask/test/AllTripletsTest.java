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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.softserve.edu.logicTask.task331AB.AllTriplets;
import com.softserve.edu.logicTask.task331AB.Triplet;

/**
 * Class to testing AllTriplets class (task 331b).
 *
 * @version 1.1. 24.04.2017
 * @author Nazar
 *
 * @see com.softserve.edu.logicTask.task331A.OneTriplet
 * @see com.softserve.edu.logicTask.AllTripletsTest.AllTriplets
 *      Testing AllTriplets (task 331b).
 */
public class AllTripletsTest {
    /**
     * Initialise instance FindCoupleTest class.
     */
    AllTriplets allTriplets = new AllTriplets();

    /**
     * positive test BVA tech test.
     */
    @Test
    public void test() {
        List<Triplet> actual = allTriplets.find(1);
        assertTrue(actual.isEmpty());
    }
    /**
     * positive test EP tech test.
     */
    @Test
    public void test2() {
        List<Triplet> expected2 = new ArrayList<Triplet>();
        expected2.add(new Triplet(9, 9, 5));
        expected2.add(new Triplet(13, 3, 3));
        List<Triplet> actual2 = allTriplets.find(187);
        assertEquals(expected2, actual2);
    }
    /**
     * negative test BVA tech test.
     * @throws NumberFormatException if incoming number less then 1.
     */
    @Test (expected = NumberFormatException.class)
    public void test3() {
        allTriplets.find(0);
    }
    /**
     * negative test EP tech test.
     * @throws NumberFormatException if incoming number less then 1.
     */
    @Test (expected = NumberFormatException.class)
    public void test4() {
        allTriplets.find(-1001);
    }
}
