package com.softserve.edu.task3;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Class for console work with class Task3.
 * @author Ivan
 *
 */
public class Task3Console extends Task3 {

    /**
     * main().
     * @param args Parameters From Console
     */
    public static void main(final String[] args) {
        Task3Console task3Comsole = new Task3Console();
        task3Comsole.doTask();
    }

    /**
     * Task3 start work.
     */
    public void doTask() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (true) {
            try {
                System.out.print("Input n  ");
                n = Integer.valueOf(scanner.next());

                writeToConsole(compute(n));
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("number n must be natural");
            } finally {
                System.out.println("For continue click 'c' else click eni key");
                String conf = scanner.next().toUpperCase();
                if (!conf.equals("C")) {
                    return;
                }
            }
        }
    }

    /**
     * method for writing on Console.
     * @param result data for Write
     */
    public void writeToConsole(final ArrayList<Integer> result) {
        if (result.size() > 0) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        } else {
            System.out.print("Number not found");
        }
        System.out.println();
    }
}
