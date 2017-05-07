package edu.softserve.task2;

import java.util.Scanner;

/**
 * Class Task1Console for work with class Task2.
 *
 * @author Ihor
 */
public class Task2console extends Task2 {
    /**
     * main().
     *
     * @param args natural n,m.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N: ");
        int n = sc.nextInt();
        System.out.println("Enter M: ");
        int m = sc.nextInt();
        Task2 task = new Task2console();
        task.myResult(n, m);
    }
}
