package com.softserve.edu.yarych;

import java.util.LinkedList;
import java.util.List;

/**
 * Task #224: a natural number n is given.
 * Among numbers 1, ..., n find every number, which matches
 * last numbers of its square (for example: 6^2 = 36, 25^2 = 625).
 * @author Андрій
 */
public class Task561 {
    /**
     * Constant for using in calculations.
     */
    public static final int MAXIMUM_REMAINDER = 10;
    /**
     * List for keeping needed numbers.
     */
    private List<Integer> listOfNumbers = new LinkedList();

    /**
     * Public constructor.
     */
    public Task561() {
    }

    /**
     * @return current list with numbers.
     */
    public List<Integer> getListOfNumbers() {
        return listOfNumbers;
    }

    /**
     * @param listOfNums list to set (natural numbers).
     */
    public void setListOfNumbers(final List<Integer> listOfNums) {
        this.listOfNumbers = listOfNums;
    }

    /**
     * Method for calculating the task.
     * @param number is a natural number from user.
     * @return list of calculated numbers.
     */
    public List<Integer> calculate(final int number) {
        int decimal = MAXIMUM_REMAINDER;

        for (int i = 1; i < number; i++) {
            int square = (int) Math.pow(i, 2);
            if (i == decimal) {
                decimal *= MAXIMUM_REMAINDER;
            }
            if (i == square % decimal) {
                listOfNumbers.add(i);
            }
        }
        return getListOfNumbers();
    }
}
