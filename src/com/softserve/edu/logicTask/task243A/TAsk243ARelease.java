
package com.softserve.edu.logicTask.task243A;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class solves create console menu for task 331A and 331B.
 *
 * @version 1.1 24.04.2017
 * @author Nazar
 *
 */
public class TAsk243ARelease extends Task243A {

    /**
     * @return incomingNumber int.
     */
    public int read() {
        Scanner scanner = new Scanner(System.in);
        int incomingNumber = scanner.nextInt(); /* incoming number */
        return incomingNumber;
    }

    /**
     *
     * @param list
     *            incoming list triplets.
     * @param incomingNumber
     *            number entered user.
     */
    public final void print(
            final ArrayList<Couple> list,
            final int incomingNumber) {
        if (list.isEmpty()) {
            System.out.println(
                    "Sorry. It is impossible to expand " + "a number \" "
                            + incomingNumber + " \" by formula n = x^2 + y^2;");
        } else {
            for (Couple couples : list) {
                System.out.println(couples);
            }
        }
    }

    /**
    *
    * @param message
    *            Parameters from Task331A.
    */
   public void print(final String message) {
       System.out.println(message);
   }

    /**
     * Method main documentation comment.
     *
     * @param args
     *            Parameters from Command Line.
     */
    public static void main(final String[] args) {

        int incomingNumber; /* incoming number */
        boolean isRun = true;

        ArrayList<Couple> list = new ArrayList<>();
        TAsk243ARelease task243ARelease = new TAsk243ARelease();

        while (isRun) {
            task243ARelease.print("");
            task243ARelease.print("Enter integer: __ or 0 for STOPPING.");

            incomingNumber = task243ARelease.read();
            if (incomingNumber == 0) {
                task243ARelease.print("You are stopped the program.");
                isRun = false;
            } else if (incomingNumber < 1) {
                task243ARelease.print("Attention!!! Number \"m\" must be "
                        + "a positive integer.");
            } else {
                    list = task243ARelease.findCouple(incomingNumber);
                    task243ARelease.print(list, incomingNumber);
                    list.clear();
            }
        }
    }
}
