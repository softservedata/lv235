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
import java.util.InputMismatchException;
import java.util.List;

import com.softserve.edu.logicTask.ScannerSingleton;

/**
 * Class create console menu for task 331A and 331B.
 *
 * @version 1.1 24.04.2017
 * @author Nazar
 * 
 * @see com.softserve.edu.logicTask.ScannerSingleton
 * @see com.softserve.edu.logicTask.task331AB.Triplet
 */
public class TaskStarter {

    /**
     * Constant for print message.
     */
    private static final String ENTER = "Enter your integer: ";
    /**
     * Constant for print message.
     */
    private static final String ACTION = "Choose action: (Enter number of function)%n";
    /**
     * Constant for print message.
     */
    private static final String FINDONE = "1. Find one triplet number of (%d);%n";
    /**
     * Constant for print message.
     */
    private static final String FINDALL = "2. Find all triplets number of (%d);%n";
    /**
     * Constant for print message.
     */
    private static final String FROMLIST = "Please enter correct number from list!";
    /**
     * Constant for print message.
     */
    private static final String ATTENTION = "Attention!!! Number \"m\" must be "
            + "a positive integer.";
    /**
     * Constant for print message.
     */
    private static final String SORRY = "Sorry. It is impossible to expand "
            + "a number \"%d\" by formula n = x^2 + y^2 + z^2;";

    /**
     * Class field used in this class.
     */
    private OneTiplet oneTriplet;
    /**
     * Class field used in this class.
     */
    private AllTriplets allTriplets;
    /**
     * @return incomingNumber int.
     */
    public int read() {
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
    public void print(final String message) {
        System.out.printf(message);
    }
    /**
     * @param triplet
     *            parse triplet toString and print to console.
     */
    public void print(final Triplet triplet) {
        print(triplet.toString() + "%n");
    }
    /**
     * @param message
     *            print message to console.
     * @param incomingNumber
     *            print incomingNumber to console.
     */
    private void print(final String message, final int incomingNumber) {
        System.out.printf(message, incomingNumber);
    }
    /**
     * @param results
     *            incoming list triplets.
     * @param incomingNumber
     *            number entered user.
     */
    public final void print(final List<Triplet> results,
            final int incomingNumber) {
        if (results.isEmpty()) {
            print(SORRY, incomingNumber);
        } else {
            for (Triplet triplet : results) {
                print(triplet);
            }
        }
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
        List<Triplet> results = new ArrayList<>();
        print(ENTER);
        try {
            int incomingNumber = read(); /* incoming number */
            if (incomingNumber < 1) {
                printRed(ATTENTION);
                return;
            }
            print(ACTION);
            print(FINDONE, incomingNumber);
            print(FINDALL, incomingNumber);

            int chooseMethod = read();  /* Enter number method; */
            switch (chooseMethod) {
            case 1:
                oneTriplet = new OneTiplet();
                results = oneTriplet.find(incomingNumber);
                print(results, incomingNumber);
                break;
            case 2:
                allTriplets = new AllTriplets();
                results = allTriplets.find(incomingNumber);
                print(results, incomingNumber);
                break;
            default:
                print(FROMLIST);
                break;
            }
        } catch (InputMismatchException e) {
            printRed(ATTENTION);
            return;
        }
    }
}
