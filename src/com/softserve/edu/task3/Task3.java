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
     * number 3.
     */
    private static final int  NUMBER_THREE = 3;

    /**
     * number 5.
     */
    private static final int  NUMBER_FIVE = 5;

    /**
     * method compute.
     * Task #559 smaller m numbers of Mersen.
     * (A prime number is called a Mersen number if it can be
     * represented as 2^n-1, where n is also a prime number.)
     * @param number natural.
     * @return numbers of Mersen
     */
    public List<Integer> getMarsenNumbers(final int number) {
        List<Integer> listResults = new ArrayList<>();
        if (number < 0) {
            throw new NumberFormatException();
        } else {
            for (int i = 2; (Math.pow(2, i) - 1) < number; i++) {
                if (isSimpleNumber(i)
                        && isSimpleNumber((int) Math.pow(2, i) - 1)) {
                   listResults.add((int) Math.pow(2, i) - 1);
                }
            }
        }
        return listResults;
    }

    /**
     * Is number simple.
     * @param number natural number.
     * @return true if n is simple number.
     */
    public boolean isSimpleNumber(final int number) {
        boolean result = false;
        if (number < 0) {
            throw new NumberFormatException();
        } else if (number >= 2) {
            if (number == 2) {
                result = true;
            } else {
                if (number <= NUMBER_FIVE && number % 2 != 0) {
                    result = true;
                } else if (number % 2 != 0 && number % NUMBER_THREE != 0
                        && number % NUMBER_FIVE != 0) {
                    result = true;
                }
            }
        }
        return result;
    }
}
