package com.softserve.edu.task1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Class for console work with class Task1.
 * @author author IRudyk
 *
 */
public class Task1Console {

    /**
     *object Task1.
     */
    private Task1 task1 = new Task1();
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
        BufferedReader reader = new BufferedReader(
                      new InputStreamReader(System.in));
        int n = 0;
        int m = 0;
            try {
                System.out.print("Input n  ");
                n = Integer.valueOf(reader.readLine());
                System.out.print("Input m  ");
                m = Integer.valueOf(reader.readLine());

                writeToConsole(task1.getSumDigitsOfNumber(n, m));
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("number n, m must be natural");
            } catch (IOException e) {
                System.out.println("input integer value please");
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
