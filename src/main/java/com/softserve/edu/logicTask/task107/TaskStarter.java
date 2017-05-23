
package com.softserve.edu.logicTask.task107;

import java.util.InputMismatchException;
import com.softserve.edu.logicTask.ScannerSingleton;

/**
 * Class solves the problem task 107 with console menu.
 *
 * @version 3.1 04.05.2017
 * @author Nazar
 * @see com.softserve.edu.logicTask.ScannerSingleton
 */
public class TaskStarter {

    /**
     * Class field used in this class.
     */
    private MaxPower maxPower = new MaxPower();

    /**
     * Constant for NumberFormatException message.
     */
    private static final String ATTENTION = "Attention!!! Number \"m\" must be "
            + "an integer and greater than 1.";

    /**
     * Constant for print message.
     */
    private static final String ENTER = "Enter your integer: ";

    /**
     * @return incomingNumber int.
     */
    private int read() {
       return ScannerSingleton.readInt();
    }
    /**
     * @param message
     *            print String to console.
     */
    private void print(final String message) {
        System.out.printf(message + "%n%n");
    }
    /**
     * @param incomingNumber
     *            integer.
     * @param result
     *            integer calculate by MaxPower class.
     */
    private void print(final int incomingNumber, final int result) {
        System.out.printf("(4^k < %d), k = %d;%n%n", incomingNumber, result);
    }
    /**
     * @param message
     *             print String red color to console.
     */
    private void printRed(final String message) {
        System.err.printf(message + "%n%n");
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
    public void start() {
        print(ENTER);
        try {
            int incomingNumber = read();
            int result = maxPower.calculate(incomingNumber);
            print(incomingNumber, result);
        } catch (InputMismatchException | NumberFormatException e) {
            printRed(ATTENTION);
        }
    }
}
