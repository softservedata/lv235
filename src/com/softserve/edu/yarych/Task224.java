
package com.softserve.edu.yarych;

import java.util.Scanner;

/**
 * Task #224: a natural number n is given.
 * Find all natural dividers of n.
 * @author Андрій
 */

public final class Task224 {
    /**
     * Scanner object.
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Private constructor.
     */
    private Task224() {
    }

    /**
     * Main method.
     * @param args from command line.
     */
    public static void main(final String[] args) {
        System.out.println("Enter natural number: ");
        int number = sc.nextInt();
        for (int i = 1; i <= number; i++) {
            if ((number % i) == 0) {
                System.out.println(i);
            }
        }
    }
}
