package com.softserve.edu.yarych;

import java.util.Scanner;

/**
 * Task #224: a natural number n is given.
 * Among numbers 1, ..., n find every number, * which matches its square
 * (for example: 6^2 = 36, 25^2 = 625).
 * @author Андрій
 */
public final class Task561 {
    /**
     * Constant for using in calculations.
     */
    public static final int MAXIMUM_REMAINDER = 100;
    /**
     * Scanner object.
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Private constructor.
     */
    private Task561() {
    }

    /**
     * Main method.
     * @param args from command line.
     */
    public static void main(final String[] args) {
        System.out.println("Enter natural number: ");
        int number = sc.nextInt();
        int decimal = MAXIMUM_REMAINDER;

        for (int i = 1; i < number; i++) {
            int square = (int) Math.pow(i, 2);
            if (i == decimal) {
                decimal *= MAXIMUM_REMAINDER;
            }
            if (i == square % decimal) {
                System.out.println(i);
            }
        }
    }
}
