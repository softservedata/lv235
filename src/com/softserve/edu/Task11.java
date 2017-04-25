package com.softserve.edu;

/**
 * @version 1.2
 * @author IRudyk
 * Class Task11.
 */
public class Task11 extends Task1 {

    /**
     * NUMBER_TEN.
     */
    private static final int NUMBER_TEN = 10;
    /**
     * method compute.
     * Task #87 Given a natural number n, m.
     * Obtain the sum of m last digits of the number n
     */
    public void compute() {
        int n = 0;
        int m = 0;
        int sum = 0;
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

        int t = 0;
        int rozmN = n;
        int[] mass;
        while (rozmN > NUMBER_TEN) {
            rozmN /= NUMBER_TEN;
            t++;
        }
        t++;
        if (m > t) {
            System.out.println("m over count of digits n");
            contunie();
            return;
        }

        mass = new int[t];

        t = n;
        for (int i = 0; i < mass.length; i++) {
            mass[i] = t / (1 * (int) Math.pow(NUMBER_TEN, mass.length - 1 - i));
            t = t % (1 * (int) Math.pow(NUMBER_TEN, mass.length - 1 - i));
        }

        for (int i = mass.length - 1; i >= mass.length - m; i--) {
            sum += mass[i];
        }

        System.out.println("Sum = " + sum);
        contunie();
    }

}
