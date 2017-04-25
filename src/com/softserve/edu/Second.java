package com.softserve.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by User on 4/24/2017.
 */
public final class Second {

    /**
     *
     */
    private static final int TEN = 10;

    /**
     *
     */
    private Second() {
    }

    /**
     *
     * @param args - program parameters
     */
    public static void main(final String[] args) {
        List<Integer> result = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i < n; i++) {
            int j = i;
            int sum = 0;
            while (j > 0) {
                sum += j % TEN;
                j = j / TEN;
            }
            if (sum * sum == m) {
                result.add(i);
            }
        }
        System.out.println(result);
    }
}

