/*
 * @(#)Example.java 1.00 21/04/2017.
 *
 * Copyright (c) 1993-2017 Softserve.academy, Inc.
 *
 * This software is the confidential and proprietary information of Softserve.
 */

/**
 *  Package for training.
 */
package com.softserve.edu.logicTask;

import java.util.Scanner;

/**
 * Class solves the problem task 107 and includes one method.
 *
 * @version 1.1 24.04.2017
 * @author Nazar
 *
 */
public final class Task107 {

    /**
     * constant for the particular case the algorithm program.
     */
    private static final int TWO = 2;

    /**
     * constant for the particular case the algorithm program.
     */
    private static final int THREE = 3;

    /**
     * constant for the particular case the algorithm program.
     */
    private static final int FOUR = 4;

    /**
     * Fake constructor Task107 documentation comment.
     */
    private Task107() {
    }

    /**
     * Method main documentation comment.
     *
     * @param args
     *            Parameters from Command Line.
     */

    public static void main(final String[] args) {

        Scanner scanner = new Scanner(System.in);
        int incomingNumber = scanner.nextInt(); /* incoming number */

        if (logicTask107(incomingNumber) != -1) {
            System.out.println(logicTask107(incomingNumber));
        } else {
            System.out.println("Attention!!! Number \"m\" must be "
                    + "an integer and greater than 1.");
        }
    }

    /**
     * Method logicTask107 solve the problem, to find maximum k,
     *            4^k < m, if integer m > 1.
     *
     * @param incomingNumber
     *            Parameter entered in console.
     *
     * @return -1 if enter incorrect numbers less then 2 or not integer. 0 in
     *         part case, if incoming number 2 or 3. k integer if incomingNumber
     *         4 or greater.
     */
    public static int logicTask107(final int incomingNumber) {
        int result = 1; /* result - max power of number 4 */
        if (incomingNumber == TWO) {
            return 0;
        } else if (incomingNumber == THREE) {
            return 0;
        } else if (incomingNumber == FOUR) {
        return 0;
        } else if (incomingNumber > FOUR) {
            while ((int) Math.pow(FOUR, result + 1) < incomingNumber) {
                result++;
            }
            return result;
        } else {
            return -1;
        }
    }
}
