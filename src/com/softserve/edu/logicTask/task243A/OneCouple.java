/*@(#)Example.java 1.00 21/04/2017
 *
 * Copyright (c) 1993-2017 Softserve.academy, Inc.
 *
 * This software is the confidential and proprietary information of Softserve.
 */
/**
 *  Package for training.
 */
package com.softserve.edu.logicTask.task243A;

/**
 * Class solves the problem task 243A and includes one method.
 *
 * @version 1.1 24.04.2017
 * @author Nazar
 * @see com.softserve.edu.logicTask.ScannerSingleton
 */
public class OneCouple {

    /**
     * Method logicTask243A solve the problem, if it possible note the pair
     * integers x, y for n = x^2 + y^2 .
     *
     * @param incomingNumber
     *            Integer entered in console.
     * @return List<Couple> list of Couple.
     *
     * @throws NumberFormatException
     *            if entered not integer number or less then 1.

     */
    public Couple find(final int incomingNumber) {
        int x = 1; /* default x number */
        int y = 1; /* default y number */
        boolean isFindCouple = false;
        if (incomingNumber < 1) {
            throw new NumberFormatException();
        }
        Couple couple = new Couple();
        for (x = 1; x <= incomingNumber; x++) {
            for (y = 1; y <= x; y++) {
                int tmp = (int) Math.pow(x, 2) + (int) Math.pow(y, 2);
                if (!isFindCouple && tmp == incomingNumber) {
                    couple = new Couple(x, y);
                    isFindCouple = true;
                }
            }
        }
        return couple;
    }
}
