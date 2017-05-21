
package com.softserve.edu.yarych;

import java.util.LinkedList;
import java.util.List;

/**
 * Task #224: a natural number n is given.
 * Find all natural divisors of n.
 * @author Андрій
 */

public class Task224 {
    /**
     * List for containing all natural divisors.
     */
    private List<Integer> listOfDivisors = new LinkedList<Integer>();

     /**
     * Default constructor.
     */
    public Task224() {
    }

     /**
     * @return current list of divisors
     */
    public List<Integer> getListOfDivisors() {
        return listOfDivisors;
    }

    /**
     * @param listOfDivs list to set (natural numbers)
     */
    public void setListOfDivisors(final List<Integer> listOfDivs) {
        this.listOfDivisors = listOfDivs;
    }

    /**
     * Method for cheсking whether number is natural.
     * @param number is an integer number, entered by the user.
     * @return true if number is natural, false if not.
     */
    public boolean isNatural(final int number) {
        return number > 0;
    }

    /**
     * Method for finding all natural divisors of number.
     * @param number is an integer number, entered by the user.
     * @return list of all natural divisors.
     */
    public List<Integer> calculate(final int number) {
        for (int i = 1; i <= number; i++) {
            if ((number % i) == 0) {
                listOfDivisors.add(i);
            }
        }
        return getListOfDivisors();
    }

    /**
     * Method for executing this task.
     * @param number is an integer number, entered by the user.
     * @return calculate() method.
     */
    public List<Integer> doTask224(final int number) {
        if (isNatural(number)) {
            return calculate(number);
        } else {
            throw new NumberFormatException();
        }
    }
}
