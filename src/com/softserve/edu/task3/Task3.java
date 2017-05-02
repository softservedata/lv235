package com.softserve.edu.task3;

import java.util.ArrayList;

/**
 * @version 1.2
 * @author IRudyk
 * Class Task3.
 */
public class Task3 {

    /**
     * MAX_SIMPLE_NUMBER.
     */
    private static final int MAX_SIMPLE_NUMBER = 33;

    /**
     * VALUE_FOR_AUDIT.
     */
    private static final int[]  VALUE_FOR_AUDIT = {2, 3, 5};

    /**
     * method compute.
     * Task #559 smaller n numbers of Mersen.
     * (A prime number is called a Mersen number if it can be
     * represented as 2n-1, where n is also a prime number.)
     * @param n natural number n
     * @return numbers of Mersen
     */
    public ArrayList<Integer> compute(final int n) {

        ArrayList<Integer> simpleNumbers = new ArrayList<>();
        ArrayList<Integer> rsesultMass = new ArrayList<>();
        simpleNumbers.add(2);
        for (int i = VALUE_FOR_AUDIT[1]; i < MAX_SIMPLE_NUMBER; i++) {
            if ((i % 2 != 0) && ((i % VALUE_FOR_AUDIT[1]) != 0)
                    && ((i % VALUE_FOR_AUDIT[2]) != 0)) {
                simpleNumbers.add(i);
            }
        }
        if (n < 0) {
            throw new NumberFormatException();
        }

        for (int i = 0; i < simpleNumbers.size(); i++) {
            if (Math.pow(2, simpleNumbers.get(i)) - 1 < n) {
                rsesultMass.add(simpleNumbers.get(i));
            }
        }
        return rsesultMass;
    }
}
