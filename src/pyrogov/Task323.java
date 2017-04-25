/**
   * Task #323: Given a natural number n.
   * Obtain all natural numbers less than n.
   * and relatively prime to it.
   *@author Pyrogov
   */

package pyrogov;

import java.util.*;

public class Task323 {
	public static void main(String[] args) {

		System.out.println("coprime Integers >>>: " + getCoprimeIntegers(18));

	}

	public static List<Integer> getCoprimeIntegers(int n) {

		List<Integer> simpleDigits = new ArrayList<Integer>();
		int greatestDivisor;
		for (int i = 1; i < n; i++) {

			if (n % i != 0) {
				greatestDivisor = gcd(n, i);

				if (greatestDivisor == 1) {
					simpleDigits.add(i);

				}

			}

		}

		return simpleDigits;

	}

	// checks greatest common divisor (Evklid's algorithm)
	public static int gcd(int a, int b) {

		while (b != 0) {

			int tmp = a % b;
			a = b;
			b = tmp;

		}

		return a;
	}

}
