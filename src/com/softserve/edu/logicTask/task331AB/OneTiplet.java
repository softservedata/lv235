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
 * Class solves the problem task 331A.
 *
 * @version 1.1 24.04.2017
 * @author Nazar
 */
public class OneTiplet {

    /**
     * Default constructor OneTriplet.
     */
    public OneTiplet() {
    }

    /**
     * Method find, if it possible Couple
     *            integers x, y, z for n = x^2 + y^2 + z^2.
     *
     * @param incomingNumber
     *            Integer entered in console.
     * @return List<Couple> list of Couple.

     * @throws NumberFormatException
     *            if entered not integer number or less then 1.
     */
    public List<Triplet> find(final int incomingNumber) {
        if (incomingNumber < 1) {
            throw new NumberFormatException();
        }
        boolean isFindTiplet = false;
        List<Triplet> results = new ArrayList<>();
        for (int x = 1; x <= incomingNumber; x++) {
            for (int y = 1; y <= x; y++) {
                for (int z = 1; z <= y; z++) {
                    int tmp = (int) Math.pow(x, 2) + (int) Math.pow(y, 2)
                            + (int) Math.pow(z, 2);
                    if (!isFindTiplet && tmp == incomingNumber) {
                         results.add(new Triplet(x, y, z));
                         isFindTiplet = true;
                    }
                }
            }
        }
        return results;
    }
}
