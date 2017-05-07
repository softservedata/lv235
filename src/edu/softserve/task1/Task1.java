package edu.softserve.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ihor
 * @version 2.0
 * Class Task1.
 */
public class Task1 {

    /**
     * @param n natural number
     * @task225
     * @return natural digits.
     */
    public List<Integer> myResult(final int n) {
        List<Integer> result = new ArrayList<>();
        for (int q = 1; q < n; q++) {
            if ((n % (q * q) == 0) && (n % (q * q * q) != 0)) {
                result.add(q);
            }
        }
        if (result.size() == 0) {
            System.out.println("List is empty");
        }
        System.out.println(result);
        return result;
    }
}
