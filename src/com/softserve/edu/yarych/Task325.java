package com.softserve.edu.yarych;

import java.util.LinkedList;
import java.util.List;

/**
 * Task #325: a natural number n is given.
 * Find all simple dividers of n.
 * @author Андрій
 */
public class Task325 {

    /**
     * Blah.
     */
    private List<Integer> listOfDivisors = new LinkedList<Integer>();
    /**
     * Variable for checking if number is simple.
     */
    private boolean isSimple = true;

    /**
     * Private constructor.
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
     * @return true if number is simple.
     */
    public boolean isSimple() {
        return isSimple;
    }

    /**
     * @param isSimpl value to set.
     */
    public void setSimple(final boolean isSimpl) {
        this.isSimple = isSimpl;
    }

    /**
     * @param number is a natural number from user.
     * @return list of simple divisors.
     */
    public List<Integer> calculate(final int number) {
        for (int i = 1; i <= number; i++) {
            if ((number % i) == 0) {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isSimple = false;
                    }
                }
                if (isSimple) {
                    listOfDivisors.add(i);
                }
            }
        }
        return getListOfDivisors();
    }
}
