package com.softserve.edu.yarych;


import java.util.Scanner;

/**
 * Extended class for console output.
 * @author Андрій
 *
 */
public class Task224Console extends Task224 {
    /**
     * Scanner object.
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Default constructor from superclass.
     */
    public Task224Console() {
        super();
    }

    /**
     * Main method.
     * @param args from command line.
     */
    public static void main(final String[] args) {
        Task224 number = new Task224();
        System.out.println("Enter natural number: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("You have entered non-natural number.");
        } else {
            number.calculate(n);
            for (int i = 0; i < number.getListOfDivisors().size(); i++) {
                System.out.println(number.getListOfDivisors().get(i));
            }
        }
    }
}
