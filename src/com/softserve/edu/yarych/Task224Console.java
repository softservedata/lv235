package com.softserve.edu.yarych;


import java.util.InputMismatchException;
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
    public Task224Console(int n) {
        super(n);
    }

    /**
     * Main method.
     * @param args from command line.
     */
    public static void main(final String[] args) {
        
        System.out.println("Enter natural number: ");
        int n = sc.nextInt();
        Task224 number = new Task224(n);
        number.calculate();
        for (Integer i : number.getListOfDivisors()) {
            System.out.println(i);
        }
    }
}
