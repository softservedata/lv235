package com.softserve.edu;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by User on 4/24/2017.
 */
public final class Third {

    /**
     *
     */
    private static final int TWO_DIGITS_MIN_VALUE = 10;

    /**
     *
     */
    private static final int TWO_DIGITS_MAX_VALUE = 99;

    /**
     *
     */
    private static final int HUNDRED_MASK = 100;

    /**
     *
     */
    private static final int TEN_MASK = 10;

    /**
     *
     */
    private static final int POWER = 3;

    /**
     *
     */
    private Third() {
    }

    /**
     *
     * @param args - program parameters
     */
    private static void main(final String[] args) {
        List<Integer> result = new ArrayList<>();

        for (int i = TWO_DIGITS_MIN_VALUE; i < TWO_DIGITS_MAX_VALUE; i++) {
            int d1 = i / HUNDRED_MASK;
            int d2 = i % HUNDRED_MASK;
            int d3 = d2 / TEN_MASK;
            int d4 = d2 % TEN_MASK;

            int resultOfPow = calculatePower(d1, d3, d4);
            if (i == resultOfPow) {
                result.add(i);
            }
        }
        System.out.println(result);
    }

    /**
     *
     * @param d1 - hundreds
     * @param d3 - ten
     * @param d4 - units
     * @return - power of 3 for d1, d2, d3
     */
    private static int calculatePower(final int d1,
                                      final int d3,
                                      final int d4) {
        return ((int) Math.pow(d1, POWER))
                + ((int) Math.pow(d3, POWER))
                + ((int) Math.pow(d4, POWER));
    }
}

