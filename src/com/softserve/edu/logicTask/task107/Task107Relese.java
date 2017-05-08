package com.softserve.edu.logicTask.task107;

import java.util.Scanner;

/**
 * Class solves the problem task 107 with console menu.
 *
 * @version 1.1 24.04.2017
 * @author Nazar
 *
 */
public class Task107Relese extends Task107 {

    /**
     * @return incomingNumber int.
     */
    public  int read() {
        Scanner scanner = new Scanner(System.in);
        int incomingNumber = scanner.nextInt(); /* incoming number */
        return incomingNumber;
    }

    /**
    *
    *@param result Parameters from Task107.
    */
    public void print(final int result) {
        //System.out.println("4^k < m, if integer m > 1.");
        System.out.println("(4^k < m), " + "k = " + result);
    }

    /**
    *
    *@param message Parameters from Task107.
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

        Task107Relese task107Relese = new Task107Relese();
        task107Relese.console(task107Relese);
    }
    /**
     * Method main documentation comment.
     *
     * @param task107Relese Instance of class Task107Relese.
     */
    public void console(final Task107Relese task107Relese) {
        int incomingNumber; /* incoming number */
        boolean isRun = true;
        while (isRun) {
            System.out.println("Enter integer: __ or 0 for STOPPING.");
            incomingNumber = task107Relese.read();
            if (incomingNumber == 0) {
                task107Relese.print("You are stopped the program.");
                isRun = false;
            } else if (incomingNumber <= 1) {
                task107Relese.print("Attention!!! Number \"m\" must be "
                        + "an integer and greater than 1.");
            } else {
                task107Relese.print(task107Relese.logicTask107(incomingNumber));
            }
        }
    }
}
