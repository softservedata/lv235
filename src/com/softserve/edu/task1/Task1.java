package com.softserve.edu.task1;

/**
 * @version 2.0
 * @author IRudyk
 * Class Task1.
 */
public class Task1 {

    /**
     * method compute.
     * Task #87
     * @param n natural number
     * @param m natural number
     * @return sum m last digits number n.
     */
    public int getSumDigitsOfNumber(final int n, final int m) {
       int sum = 0;
       if (n < 0 || m < 0) {
           throw new NumberFormatException();
       } else {
           String nString = String.valueOf(n);
           if (nString.length() < m) {
               throw new ArithmeticException("m over count of digits n");
           } else {
               for (int i = nString.length() - 1;
                         i >= nString.length() - m; i--) {
                   sum += Integer.parseInt(String.valueOf(nString.charAt(i)));
               }
           }
       }
       return sum;
    }
}
