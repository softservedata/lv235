
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
 * Class solves the problem task 331A and includes one method.
 *
 * @version 1.1 24.04.2017
 * @author Nazar
 *
 */
public final class Task331AB {

    /**
     * Fake constructor Task331AB documentation comment.
     */
    private Task331AB() {
    }

    /**
     * Method main documentation comment.
     *
     * @param args
     *            Parameters from Command Line.
     */
    public static void main(final String[] args) {
        int incomingNumber; /* incoming number */
        int chooseMethod; /*Enter number method;*/
        System.out.println("Enter integer: ");
        Scanner scanner = new Scanner(System.in);
        incomingNumber = scanner.nextInt();
        System.out.println("Choose action: (Enter number of function)");
        System.out.println(
                "1. Find one tiplet numbers of (" + incomingNumber + ");");
        System.out.println(
                "2. Find all tiplets numbers of (" + incomingNumber + ").");
        chooseMethod = scanner.nextInt();
        switch (chooseMethod) {
        case 1:
            findTiplet(incomingNumber);
            break;
        case 2:
            findAllTiplet(incomingNumber);
            break;
        default:
            System.out.println("Please enter correct number from list !");
            break;
        }
    }

    /**
     * Method logicTask331A solve the problem, if it possible note the pair
     * integers x, y, z for n = x^2 + y^2 + z^2 .
     *
     * @param incomingNumber
     *            Integer entered in console.
     *
     */
    public static void findTiplet(final int incomingNumber) {
        int x = 1; /* default x number */
        int y = 1; /* default y number */
        int z = 1; /* default y number */

        for (x = 1; x <= incomingNumber; x++) {
            for (y = 1; y <= x; y++) {
                for (z = 1; z <= y; z++) {
                    int tmp = (int) Math.pow(x, 2) + (int) Math.pow(y, 2)
                            + (int) Math.pow(z, 2);
                    if (tmp == incomingNumber) {
                        System.out
                                .println("x: " + x + "; y: " + y + "; z: " + z);
                        return;
                    } else if (incomingNumber == z) {
                        System.out.println("Sorry. It is impossible to expand "
                                + "a number \" " + incomingNumber
                                + " \" by formula n = x^2 + y^2 + z^2;");
                    }
                }
            }
        }
    }

    /**
     * Method logicTask331B solve the problem, if it possible note all triples
     * integers x, y, z for n = x^2 + y^2 + z^2 .
     *
     * @param incomingNumber
     *            Integer entered in console.
     *
     */
    public static void findAllTiplet(final int incomingNumber) {
        int x = 1; /* default x number */
        int y = 1; /* default y number */
        int z = 1; /* default z number */
        boolean isFindTiplet = false; /*
                                       * flag for "...impossible to expand..."
                                       */
        for (x = 1; x <= incomingNumber; x++) {
            for (y = 1; y <= x; y++) {
                for (z = 1; z <= y; z++) {
                    int tmp = (int) Math.pow(x, 2) + (int) Math.pow(y, 2)
                            + (int) Math.pow(z, 2);
                    if (tmp == incomingNumber) {
                        System.out
                                .println("x: " + x + "; y: " + y + "; z: " + z);
                        isFindTiplet = true;
                    } else if (incomingNumber == z && !isFindTiplet) {
                        System.out.println("Sorry. It is impossible to expand "
                                + "a number \" " + incomingNumber
                                + " \" by formula n = x^2 + y^2 + z^2;");
                    }
                }
            }
        }
    }
}


