package com.softserve.edu;

import java.util.Scanner;

/**
 * Main class Appl.
 *
 * @author IRudyk
 */
public final class Appl {

    /**
     * Default Constructor.
     */
    private Appl() {
    }

    /**
     * main functin main.
     *
     * @param args
     *            From Command Lines.
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task1 task;
        String t = "";

        while (true) {
            System.out.println("For task1 click '1'\nFor task2 click '2'");
            System.out.print("For task3 click '3'\n >>>> ");
            t = scanner.next();

            switch (t) {
            case "1":
                task = new Task11();
                task.compute();
                break;
            case "2":
                task = new Task12();
                task.compute();
                break;
            case "3":
                task = new Task13();
                task.compute();
                break;
            default:
                break;
            }

            System.out.println("For contunie click 'c' else click eni key");
            String con = scanner.next().toUpperCase();
            if (!con.equals("C")) {
                return;
            }
        }
    }
}
