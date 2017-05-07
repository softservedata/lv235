package edu.softserve.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ihor
 * @version 2.0
 *          Class Task2
 */
public class Task2 {
    /**
     * NUMBER_TEN.
     */
    private static final int TEN = 10;
    /**
     * method compute.
     * Task329.
     * @param n natural number
     * @param m natural number
     * @return sum n.
     */

    public List<Integer> myResult(final int n, final int m) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int j = i;
            int sum = 0;
            while (j > 0) {
                sum += j % TEN;
                j /= TEN;
            }
            if (sum * sum == m) {
                result.add(i);
            }
        }
        if (result.size() == 0) {
            System.out.println("List is empty");
        }
        System.out.println(result);
        return result;
    }


}
