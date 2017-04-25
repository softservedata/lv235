package com.softserve.edu.task1;


import java.util.Scanner;

/**
 * Class for console work with class Task1.
 * @author Ivan
 *
 */
public class Task1Console extends Task1 {

    /**
     * main().
     * @param args Parameters From Console
     */
    public static void main(final String[] args) {
        Task1Console task1Comsole = new Task1Console();
        task1Comsole.doTask();
    }

    /**
     * Task1 start work.
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
    public void writeToConsole(final int result) {
        System.out.println("Sum = " + result);
    }
}
