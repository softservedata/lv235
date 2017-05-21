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

import java.util.InputMismatchException;

import com.softserve.edu.logicTask.ScannerSingleton;

/**
 * Class create console menu for task 243A.
 * @version 1.1 24.04.2017
 * @author Nazar
 * @see com.softserve.edu.logicTask.ScannerSingleton
 * @see com.softserve.edu.logicTask.task243A.Couple
 */
public class TaskStarter {
    /**
     * Constant for print message "Enter your integer".
     */
    private static final String ENTER = "Enter your integer: ";
    /**
     * Constant for print message "impossible to expand number".
     */
    private static final String SORRY = "Sorry. It is impossible to expand "
            + "a number \"%d\" by formula n = x^2 + y^2;%n";
    /**
     * Constant for NumberFormatException message.
     */
    private static final String ATTENTION = "Attention!!! Number \"m\" must be "
            + "a positive integer.";

    /**
     * Class field used in this class.
     */
    private OneCouple oneCouple = new OneCouple();

    /**
     * @return incomingNumber int.
     */
    private int read() {
       return ScannerSingleton.readInt();
    }
    /**
     * @param message
     *             print String red color to console.
     */
    private void printRed(final String message) {
        System.err.printf(message + "%n%n");
    }
    /**
     * @param message
     *            print String to console.
     */
    private void print(final String message) {
        System.out.println(message);
    }
    /**
     * @param couple
     *            parse Couple toString and print to console.
     */
    private void print(final Couple couple) {
        print(couple.toString());
    }

    /**
     * @param message
     *            print message to console.
     * @param incomingNumber
     *            print incomingNumber to console.
     */
    private void print(final String message, final int incomingNumber) {
        System.out.printf(
                message, incomingNumber);
    }
    /**
     * Method main.
     * @param args
     *            String args.
     */
    public static void main(final String[] args) {
        TaskStarter taskStarter = new TaskStarter();
        taskStarter.start();
    }
    /**
     * Method to start TaskStarter.
     */
    private void start() {
        print(ENTER);
        try {
            int incomingNumber = read(); /* incoming number */
            Couple couple = oneCouple.find(incomingNumber);
            if (couple.isEmpty()) {
                print(SORRY, incomingNumber);
            } else {
                print(couple);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            printRed(ATTENTION);
        }
    }
}
