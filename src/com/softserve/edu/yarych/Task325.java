package com.softserve.edu.yarych;

import java.util.LinkedList;
import java.util.List;

/**
 * Task #325: a natural number n is given.
 * Find all prime dividers of n.
 * @author Андрій
 */
public class Task325 {
    /**
     * List for containing all natural divisors.
     */
    private List<Integer> listOfDivisors = new LinkedList<Integer>();

    /**
     * Puublic constructor.
     */
    public Task325() {
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
     * @param number is a natural number from user.
     * @return list of simple divisors.
     */
    public List<Integer> calculate(final int number) {
        int n = number;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                listOfDivisors.add(i);
                n /= i;
            }
        }
        return getListOfDivisors();
    }

    /**
     * Method for executing this task.
     * @param number is an integer number, entered by the user.
     * @return calculate() method.
     */
    public List<Integer> doTask325(final int number) {
        if (isNatural(number)) {
            return calculate(number);
        } else {
            throw new NumberFormatException();
        }
    }
}
