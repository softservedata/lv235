package com.softserve.edu.yarych;

import java.util.Scanner;

/**
 * Task #325: a natural number n is given.
 * Find all simple dividers of n.
 * @author Андрій
 */
public final class Task325 {
    /**
     * Scanner object.
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Private constructor.
     */
    private Task325() {
    }

    /**
     * Main method.
     * @param args from command line.
     */
    public static void main(final String[] args) {
        System.out.println("Enter natural number: ");
        int number = sc.nextInt();
        boolean isSimple = true;

        for (int i = 1; i <= number; i++) {
            if ((number % i) == 0) {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isSimple = false;
                    }
                }
                if (isSimple) {
                    System.out.println(i);
                }
            }
        }
    }
}
