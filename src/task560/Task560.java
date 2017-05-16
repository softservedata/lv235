/**
   * Two natural numbers are said to be friendly.
   * if each of them is equal to the sum of all the divisors of the other.
   * except for this number itself.
   * Find all pairs of friendly numbers.
   * lying in the range from 200 to 300. 
   *@author Pyrogov
   */
package task560;

import java.util.ArrayList;
import java.util.Arrays;

public class Task560 {
	private final static int startRangeValue = 200;
	private final static int endRangeValue = 300;

	// дружні числа з Вікіпедії
	public final static ArrayList<Integer> allFriedlyIntegers = new ArrayList<Integer>(Arrays.asList(220, 284, 1184,
			1210, 2620, 2924, 5020, 5564, 6232, 6368, 10744, 10856, 12285, 14595, 17296, 18416, 63020, 76084));

	public static int[] checkFriedlyIntegers() {
		ArrayList<Integer> filteredFriedlyIntegers = new ArrayList<Integer>();
		for (Integer i = startRangeValue; i <= endRangeValue; i++) {
			if (allFriedlyIntegers.contains(i)) {
				filteredFriedlyIntegers.add(i);
			}
		}
		if (!filteredFriedlyIntegers.isEmpty()) {
			for (Integer j = 1; j < filteredFriedlyIntegers.size(); j++) {
				if (filteredFriedlyIntegers.get(j - 1) == getDividersSum(filteredFriedlyIntegers.get(j))) {
					return new int[] { filteredFriedlyIntegers.get(j - 1), filteredFriedlyIntegers.get(j) };
				}
			}
		}
		return null;
	}

	private static int getDividersSum(final int num) {

		int dividersSum = 0;

		for (int i = 1; i <= num / 2; i++) {

			if (num % i == 0) {
				dividersSum += i;

			}
		}

		return dividersSum;

	}

}
