/*@(#)Example.java 1.00 21/04/2017
 *
 * Copyright (c) 1993-2017 Softserve.academy, Inc.
 *
 * This software is the confidential and proprietary information of Softserve.
 */
/**
 *  Package for training.
 */
package com.softserve.edu.logicTask.task331AB;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.softserve.edu.logicTask.task331AB.OneTiplet;
import com.softserve.edu.logicTask.task331AB.Triplet;

/**
 * Class to testing OneTriplet class (task 331a).
 *
 * @version 1.1. 24.04.2017
 * @author Nazar
 *
 * @see com.softserve.edu.logicTask.task331A.OneTriplet
 * @see com.softserve.edu.logicTask.AllTripletsTest.AllTriplets
 *      Testing OneTriplet (task 331a).
 */
public class OneTripletTest {

    /**
     * Initialise instance FindCoupleTest class.
     */
    private OneTiplet oneTriplet = new OneTiplet();

    /**
     * positive test BVA tech test.
     */
    @Test
    public void test() {
        List<Triplet> actual = oneTriplet.find(1);
        assertTrue(actual.isEmpty());
    }
    /**
     * positive test EP tech test.
     */
    @Test
    public void test2() {
        List<Triplet> expected2 = new ArrayList<Triplet>();
        expected2.add(new Triplet(12, 9, 6));
        List<Triplet> actual2 = oneTriplet.find(261);
        assertEquals(expected2, actual2);
    }
    /**
     * negative test BVA tech test.
     * @throws NumberFormatException if incoming number less then 1.
     */
    @Test (expected = NumberFormatException.class)
    public void test3() {
        oneTriplet.find(0);
    }
    /**
     * negative test EP tech test.
     * @throws NumberFormatException if incoming number less then 1.
     */
    @Test (expected = NumberFormatException.class)
    public void test4() {
        oneTriplet.find(-1001);
    }
}
