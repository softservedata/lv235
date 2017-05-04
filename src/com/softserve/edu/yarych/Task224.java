
package com.softserve.edu.yarych;

import java.util.LinkedList;
import java.util.List;

/**
 * Task #224: a natural number n is given.
 * Find all natural dividers of n.
 * @author Андрій
 */

public class Task224 {
    /**
     * number.
     */
    private int number;
    /**
     * Blah.
     */
    private List<Integer> listOfDivisors = new LinkedList<Integer>();

     /**
     * Constructor with perameter.
     * @param n is natural number.
     */
    public Task224(final int n) {
        this.number = n;
    }

    /**
     * @return number.
     */
    public int getNumber() {
        return number;
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
     * Method for finding all natural divisors of n.
     * @return list on natural divisors.
     */
    public List<Integer> calculate() {
        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                if ((number % i) == 0) {
                    listOfDivisors.add(i);
                }
            }
        } else {
            try {
                throw new NonNaturalNumberException("You have entered"
                        + " non-natural number.");
            } catch (NonNaturalNumberException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return getListOfDivisors();
    }
}
