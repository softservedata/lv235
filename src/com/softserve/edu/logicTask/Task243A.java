
/*@(#)Example.java 1.00 21/04/2017
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
 * Class solves the problem task 243A and includes one method.
 *
 * @version 1.1 24.04.2017
 * @author Nazar
 *
 */
public final class Task243A {

    /**
     * Fake constructor Task243A documentation comment.
     */
    private Task243A() {
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
        findCouple(incomingNumber);
    }

    /**
     * Method logicTask243A solve the problem,
     *            if it possible note the pair integers x, y for n = x^2 + y^2.
     *
     * @param incomingNumber
     *            Integer entered in console.
     *
     */
    public static void findCouple(final int incomingNumber) {
        int x = 1; /* default x number */
        int y = 1; /* default y number */

        for (int j = 1; j <= incomingNumber; j++) {
            for (int i = 1; i <= j; i++) {
                int tmp = (int) Math.pow(j, 2) + (int) Math.pow(i, 2);
                if (tmp == incomingNumber) {
                    System.out.println("x: " + j + " y: " + i);
                    return;
                } else if (incomingNumber == i) {
                    System.out.println("Sorry. It is impossible to expand "
                            + "a number \" " + incomingNumber
                            + " \" by formula n = x^2 + y^2;");
                }
            }
        }

    }
}
