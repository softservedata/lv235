package edu.softserve.task1;

import java.util.Scanner;

/**
 * Class Task1Console for work with class Task1.
 *
 * @author Ihor
 */
public class Task1Console extends Task1 {
    /**
     * main().
     *
     * @param args natural n.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Put N:");
        Task1 task = new Task1Console();
        task.myResult(sc.nextInt());
    }
}
