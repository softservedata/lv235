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
     * Main method.
     * @param args from command line.
     */
    public static void main(final String[] args) {

        System.out.println("Enter natural number: ");
        int n = sc.nextInt();
        Task224 number = new Task224();
        try {
            number.doTask224(n);
        } catch (NumberFormatException e) {
            System.out.println("You have entered non-natural number.");
        }
        for (Integer i : number.getListOfDivisors()) {
            System.out.println(i);
        }
    }
}
