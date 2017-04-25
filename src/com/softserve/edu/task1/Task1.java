package com.softserve.edu.task1;

import java.util.ArrayList;

/**
 * @version 2.0
 * @author IRudyk
 * Class Task1.
 */
public class Task1 {

    /**
     * NUMBER_TEN.
     */
    private static final int NUMBER_TEN = 10;

    /**
     * method compute.
     * Task #87
     * @param n natural number
     * @param m natural number
     * @return sum m last digits number n
     */
    public int compute(final int n, final int m) {
        int sum = 0;
        if (n < 0 || m < 0) {
            throw new NumberFormatException();
        }

        int sizeN = 0;
        int tempN = n;
        ArrayList<Integer> array = new ArrayList<>();
        while (tempN >= NUMBER_TEN) {
            tempN /= NUMBER_TEN;
            sizeN++;
        }
        sizeN++;
        if (m > sizeN) {
            throw new ArithmeticException("m over count of digits n");
        }

        int digitN = n;
        for (int i = 0; i < sizeN; i++) {
            array.add(digitN / (1 * (int) Math.pow(NUMBER_TEN,
                     sizeN - 1 - i)));
            digitN = digitN % (1 * (int) Math.pow(NUMBER_TEN, sizeN - 1 - i));
        }

        for (int i = array.size() - 1; i >= array.size() - m; i--) {
            sum += array.get(i);
        }

        return sum;
    }

}
