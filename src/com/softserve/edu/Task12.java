package com.softserve.edu;

import java.util.ArrayList;

/**
 * Class Task12.
 */
public class Task12 extends Task1 {
    /**
     * method compute. Given natural numbers m, n. Get all their natural common
     * multiples, smaller m*n
     */
    public void compute() {
        int n = 0;
        int m = 0;
        ArrayList<Integer> mass = new ArrayList();
        try {
            System.out.print("Input n  ");
            n = Integer.valueOf(getScanner().next());
            System.out.print("Input m  ");
            m = Integer.valueOf(getScanner().next());
            if (n < 0 || m < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Input integer n and m");
            contunie();
            return;
        }

        for (int i = Math.max(n, m); i < n * m; i++) {
            if (i % n == 0 && i % m == 0) {
                mass.add(i);
            }
        }
        if (mass.size() == 0) {
            System.out.println("No number");
        }
        for (int i : mass) {
            System.out.println(i);
        }
        contunie();
    }

    /**
     * method continue.
     */
    public void contunie() {
        System.out.println("\nFor  exit click 'e' to contunie click eny key");
        String y = getScanner().next().toUpperCase();
        if (y.equals("E")) {
            return;
        } else {
            compute();
        }
    }
}
