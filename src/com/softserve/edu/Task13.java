package com.softserve.edu;

import java.util.ArrayList;

/**
 * Class Task13.
 *
 * @author IRudyk
 */
public class Task13 extends Task1 {

    /**
     * MAX_SIMPLE_NUMBER.
     */
    private static final int MAX_SIMPLE_NUMBER = 33;

    /**
     * VALUE_FOR_AUDIT.
     */
    private static final int[]  VALUE_FOR_AUDIT = {2, 3, 5};

    /**
     * method compute. Given a natural number n all the smaller n numbers of
     * Mersen. (A prime number is called a Mersen number if it can be
     * represented as 2n-1, where p is also a prime number.)
     */
    public void compute() {
        int n = 0;
        int l = 2;
        l++;
        ArrayList simpleNumbers = new ArrayList<>();
        simpleNumbers.add(2);
        for (int i = l; i < MAX_SIMPLE_NUMBER; i++) {
            if ((i % 2 == 0) && (i % VALUE_FOR_AUDIT[1] == 0)
                    && (i % VALUE_FOR_AUDIT[2] == 0)) {
                simpleNumbers.add(i);
            }
        }
        ArrayList<Integer> mass = new ArrayList();
        try {
            System.out.print("Input n  ");
            n = Integer.valueOf(getScanner().next());
            if (n < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Input integer n");
            contunie();
            return;
        }

        for (int i = 0; i < simpleNumbers.size(); i++) {
            if (Math.pow(2, (int) simpleNumbers.get(i)) - 1 < n) {
                mass.add((int) Math.pow(2, (int) simpleNumbers.get(i) - 1));
                System.out.println(mass.get(i));
            }
        }
        contunie();
    }

    /**
     * method contunie.
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
