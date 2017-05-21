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

import java.util.ArrayList;
import java.util.List;

/**
 * Class solves the problem task 331B.
 *
 * @version 1.1 24.04.2017
 * @author Nazar
 *
 */
public class AllTriplets {


    /**
     * Fake constructor Task331B documentation comment.
     */
    public AllTriplets() {
    }

    /**
     * Method logicTask331B solve the problem, if it possible note all triples
     * integers x, y, z for n = x^2 + y^2 + z^2 .
     *
     * @param incomingNumber
     *            Integer entered in console.
     *
     * @return List<Triplet> list of Triplet.
     */
    public List<Triplet> find(final int incomingNumber) {
        int x = 1; /* default x number */
        int y = 1; /* default y number */
        int z = 1; /* default z number */

        if (incomingNumber < 1) {
            throw new NumberFormatException();
        }
        List<Triplet> results = new ArrayList<>();
        for (x = 1; x <= incomingNumber; x++) {
            for (y = 1; y <= x; y++) {
                for (z = 1; z <= y; z++) {
                    int tmp = (int) Math.pow(x, 2) + (int) Math.pow(y, 2)
                            + (int) Math.pow(z, 2);
                    if (tmp == incomingNumber) {
                        results.add(new Triplet(x, y, z));
                    }
                }
            }
        }
    return results;
    }
}
