package com.softserve.edu.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


/**
 * Class for console work with class Task2.
 * @author author IRudyk
 */
public class Task2Console {

    /**
     *object Task2.
     */
    private Task2 task2 = new Task2();

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
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = 0;
        int m = 0;
            try {
                System.out.print("Input n  ");
                n = Integer.valueOf(br.readLine());
                System.out.print("Input m  ");
                m = Integer.valueOf(br.readLine());

                writeToConsole(task2.getCommonMultiples(n, m));
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
    public void writeToConsole(final List<Integer> result) {
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
