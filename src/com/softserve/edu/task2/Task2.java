package com.softserve.edu.task2;


import java.util.ArrayList;
import java.util.List;

/**
 * @version 2.0
 * @author IRudyk
 * Class Task2.
 */
public class Task2 {
    /**
     * method compute.
     * Task #226
     * @param n natural number n
     * @param m natural number m
     * @return Get all natural common multiples, smaller m*n
     */
    public List<Integer> getCommonMultiples(final int n, final int m) {
        List<Integer> array = new ArrayList<>();
        if (n < 0 || m < 0) {
            throw new NumberFormatException();
        } else {
            for (int i = Math.max(n, m); i < n * m; i++) {
                if (i % n == 0 && i % m == 0) {
                    array.add(i);
                }
            }
        }
        return array;
    }

}
