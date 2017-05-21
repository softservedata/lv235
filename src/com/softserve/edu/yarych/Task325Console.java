package com.softserve.edu.yarych;

import java.util.Scanner;

/**
 * Extended class for console output.
 * @author Андрій
 */
public class Task325Console extends Task325 {

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
        Task325 number = new Task325();
        try {
            number.doTask325(n);
        } catch (NumberFormatException e) {
            System.out.println("You have entered non-natural number.");
        }
        for (Integer i : number.getListOfDivisors()) {
                System.out.println(i);
        }
    }
}
