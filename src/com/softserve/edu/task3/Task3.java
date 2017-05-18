package com.softserve.edu.task3;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.2
 * @author IRudyk
 * Class Task3.
 */
public class Task3 {

    /**
     * VALUE_FOR_AUDIT.
     */
    private static final int[]  VALUE_FOR_AUDIT = {2, 3, 5};

    /**
     * method compute.
     * Task #559 smaller m numbers of Mersen.
     * (A prime number is called a Mersen number if it can be
     * represented as 2^n-1, where n is also a prime number.)
     * @param number natural.
     * @return numbers of Mersen
     */
    public List<Integer> getMarsenNumbers(final int number) {
        List<Integer> rsesultMass = new ArrayList<>();
        if (number < 0) {
            throw new NumberFormatException();
        } else {
            for (int i = 2;; i++) {
                if (isSmallNumber(i)
                        && isSmallNumber((int) Math.pow(2, i) - 1)) {
                   rsesultMass.add((int) Math.pow(2, i) - 1);
                   if ((Math.pow(2, i) - 1) > number) {
                       break;
                   }
                }
            }
        }
        return rsesultMass;
    }

/**
 * Is number simple.
 * @param number natural number.
 * @return true if n is simple number.
 */
    public boolean isSmallNumber(final int number) {
        boolean result = false;
        if (number < 0) {
            throw new NumberFormatException();
        } else {
            if (number <= 2) {
                result = true;
            } else if (number <= VALUE_FOR_AUDIT[2] && number % 2 != 0) {
                result = true;
            } else if ((number % 2 != 0) && ((number % VALUE_FOR_AUDIT[1]) != 0)
                    && ((number % VALUE_FOR_AUDIT[2]) != 0)) {
                result = true;
            }
        }
        return result;
    }
}
