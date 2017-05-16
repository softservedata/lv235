/**
   * Task #323: Given a natural number n.
   * Obtain all natural numbers less than n.
   * and relatively prime to it.
   *@author Pyrogov
   */

package task323;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task323 {

	

	public static List<Integer> getCoprimeIntegers(int n) {

		List<Integer> simpleDigits = new ArrayList<Integer>();
		// змінна яка містить найбільший дільник для числа меншого ніж n
		int greatestDivisor;
		// перевірка всіх інтеджерів менших ніж n
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

			int temporary = a % b;
			a = b;
			b = temporary;

		}

		return a;
	}

}
