package com.softserve.edu.logicTask.task331AB;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class solves create console menu for task 331A and 331B.
 *
 * @version 1.1 24.04.2017
 * @author Nazar
 *
 */
public class Task331ABRelese extends Task331A {

    /**
     * @return incomingNumber int.
     */
    public int read() {
        Scanner scanner = new Scanner(System.in);
        int incomingNumber = scanner.nextInt(); /* incoming number */
        return incomingNumber;
    }

    /**
     * @param triplet to print data.
     *            Parameters from Task331A.
     */
    @Deprecated
    public void print(final Triplet triplet) {
        System.out.println("x: " + triplet.getX() + "; y: " + triplet.getY()
                + "; z: " + triplet.getZ());
    }


/**
 *
 * @param list incoming list triplets.
 * @param incomingNumber number entered user.
 */
    public final void print(
            final ArrayList<Triplet> list,
            final int incomingNumber) {
        if (list.isEmpty()) {
            System.out.println("Sorry. It is impossible to expand "
                    + "a number \" " + incomingNumber
                    + " \" by formula n = x^2 + y^2 + z^2;");
        } else {
            for (Triplet triplet : list) {
                System.out.println(triplet);
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
        int chooseMethod; /* Enter number method; */
        boolean isRun = true;

        ArrayList<Triplet> list = new ArrayList<>();
        Task331ABRelese task331ABRelese = new Task331ABRelese();
        //Task331BRelese task331BRelese = new Task331BRelese();

        while (isRun) {
            task331ABRelese.print("");
            task331ABRelese.print("Enter integer: __ or 0 for STOPPING.");

            incomingNumber = task331ABRelese.read();
            if (incomingNumber == 0) {
                task331ABRelese.print("You are stopped the program.");
                isRun = false;
            } else if (incomingNumber < 1) {
                task331ABRelese.print("Attention!!! Number \"m\" must be "
                        + "a positive integer.");
            } else {
                System.out.println("Choose action: (Enter number of function)");
                System.out.println("1. Find one tiplet numbers of ("
                        + incomingNumber + ");");
                System.out.println("2. Find all tiplets numbers of ("
                        + incomingNumber + ");");
                System.out.println("0. To EXIT.");

                chooseMethod = task331ABRelese.read();
                switch (chooseMethod) {
                case 1:
                    list = task331ABRelese.findTiplet(incomingNumber);
                    task331ABRelese.print(list, incomingNumber);
                    list.clear();
                    break;
                case 2:
                    list = task331ABRelese.findAllTiplet(incomingNumber);
                    task331ABRelese.print(list, incomingNumber);
                    list.clear();
                    break;
                case 0:
                    isRun = false;
                    task331ABRelese.print("You are stopped the program.");
                    break;
                default:
                    System.out
                            .println("Please enter correct number from list !");
                    break;
                }
            }
        }
    }
}
