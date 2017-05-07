
package edu.softserve.task3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ihor.
 * @version 2.0
 *  Class Task3
 */

public class Task3 {
    /**
     * NUMBER_THREE.
     */
    private static final int THREE = 3;
    /**
     * NUMBER_TEN.
     */
    private static final int FOUR = 4;
    /**
     * NUMBER_TEN.
     */
    private static final int TEN = 10;
    /**
     * NUMBER TEN_THOUSAND.
     */
    private static final int TEN_THOUSAND = 10000;

    /**
     * method compute.
     * Task562.
     *
     * @return sum n.
     */

    public List<Integer> task562() {
        List<Integer> result = new ArrayList<>();
        for (int i = TEN; i < TEN_THOUSAND; i++) {
            int n = i;
            int sum = 0;
            while (n > 0) {
                if (counter(i) == 2) {
                    sum += Math.pow(n % TEN, 2);
                    n /= TEN;
                }
                if (counter(i) == THREE) {
                    sum += Math.pow(n % TEN, THREE);
                    n /= TEN;
                }
                if (counter(i) == FOUR) {
                    sum += Math.pow(n % TEN, FOUR);
                    n /= TEN;
                }
            }
            if (sum == i) {
                result.add(i);
            }
        }
        if (result.size() != 0) {
            System.out.println(result + " is Amstrong number.");
        } else {
            System.out.println("List is  empty");
        }
        return result;
    }

    /**
     * method compute.
     *
     * @param n natural number
     * @return count .
     */
    public static int counter(final int n) {
        int count = 0;
        int i = n;
        while (i > 0) {
            count++;
            i /= TEN;
        }
        return count;
    }
}