package com.softserve.edu.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


/**
 * Class for console work with class Task3.
 * @author author IRudyk
 *
 */
public class Task3Console {

    /**
     *object Task3.
     */
    private Task3 task3 = new Task3();

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
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = 0;
        try {
            System.out.print("Input n  ");
            n = Integer.valueOf(br.readLine());
            writeToConsole(task3.getMarsenNumbers(n));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("number n must be natural");
        } catch (IOException e) {
            System.out.println("input integer value please");
        }
    }

    /**
     * method for writing on Console.
     * @param listResults data for Write
     */
    public void writeToConsole(final List<Integer> listResults) {
        if (listResults.size() > 0) {
            for (int i : listResults) {
                System.out.print(i + " ");
            }
        } else {
            System.out.print("Number not found");
        }
        System.out.println();
    }
}
