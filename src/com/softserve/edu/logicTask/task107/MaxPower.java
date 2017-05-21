/*@(#)Example.java 1.00 21/04/2017
 *
 * Copyright (c) 1993-2017 Softserve.academy, Inc.
 *
 * This software is the confidential and proprietary information of Softserve.
 */

/**
 *  Package for training.
 */
package com.softserve.edu.logicTask.task107;

/**
 * Class solves the problem task 107 and includes one method.
 *
 * @version 1.1. 24.04.2017
 * @author Nazar
 *
 */
public class MaxPower {
    /**
     * Default constructor MaxPower.
     */
    public MaxPower() {
    }
    /**
     * int constant for the particular case the algorithm program.
     */
    private static final int TWO = 2;
    /**
     * int constant for the particular case the algorithm program.
     */
    private static final int FOUR = 4;

    /**
     * Method MaxPower to find maximum k, if (4^k < m), and integer m > 1.
     *
     * @param incomingNumber
     *            incoming integer.
     * @return result
     *         integer.
     * @throws NumberFormatException
     *            if entered not integer number or less then 2.
     */
    public int calculate(final int incomingNumber) {
        if (incomingNumber < TWO) {
            throw new NumberFormatException();
        }
        if (incomingNumber <= FOUR) {
            return 0;
        }
        int result = 1; /* result - max power of number 4 */
        while ((int) Math.pow(FOUR, result + 1) < incomingNumber) {
            result++;
        }
        return result;
    }
}
