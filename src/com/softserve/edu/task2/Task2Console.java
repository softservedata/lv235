package com.softserve.edu.task2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * cClass for console work with class Task2.
 * @author Ivan
 */
public class Task2Console extends Task2 {

    /**
     * main.
     * @param args Parameters From Console
     */
    public static void main(final String[] args) {
        Task2Console task2Comsole = new Task2Console();
        task2Comsole.doTask();
    }

    /**
     * Task2 start work.
     */
    public void doTask() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int m = 0;
        while (true) {
            try {
                System.out.print("Input n  ");
                n = Integer.valueOf(scanner.next());
                System.out.print("Input m  ");
                m = Integer.valueOf(scanner.next());

                writeToConsole(compute(n, m));
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("number n, m must be natural");
            } finally {
                scanner.close();
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
