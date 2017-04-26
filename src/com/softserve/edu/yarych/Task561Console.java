package com.softserve.edu.yarych;

import java.util.Scanner;

/**
 * Extended class for console output.
 * @author Андрій
 */
public class Task561Console extends Task561 {
    /**
     * Scanner object.
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Constructor from superclass.
     */
    public Task561Console() {
        super();
    }

    /**
     * Main method.
     * @param args from command line.
     */
    public static void main(final String[] args) {
        Task561 number = new Task561();
        System.out.println("Enter natural number: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("You have entered non-natural number.");
        } else {
            number.calculate(n);
            for (Integer i : number.getListOfNumbers()) {
                System.out.println(i);
            }
        }
    }
}
