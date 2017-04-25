/**
   * Two natural numbers are said to be friendly.
   * if each of them is equal to the sum of all the divisors of the other.
   * except for this number itself.
   * Find all pairs of friendly numbers.
   * lying in the range from 200 to 300. 
   *@author Pyrogov
   */
package pyrogov;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task560 {
	private final static int startRangeValue = 200;
	private final static int endRangeValue = 300;

	private static Map<Integer, Integer> getFriedlyIntegers() {

		ArrayList <Integer> possibleAmicableNums = new ArrayList<Integer>();
		Map<Integer, Integer> amicableNumsMap = new HashMap<Integer, Integer>();

		for (int i = startRangeValue; i < endRangeValue; i++) {

			int dividersSum = getDividersSum(i);

			for (int k = startRangeValue; k < endRangeValue; k++) {

				if (k == dividersSum) {
					possibleAmicableNums.add(k);

				}
			}

		}

		for (Integer num : possibleAmicableNums) {

			for (int j = 0; j < possibleAmicableNums.size(); j++) {

				if (possibleAmicableNums.get(j) == getDividersSum(num)
						&& num == getDividersSum(possibleAmicableNums.get(j)) && possibleAmicableNums.get(j) != num) {

					if (!amicableNumsMap.keySet().contains(possibleAmicableNums.get(j))) {
						amicableNumsMap.put(num, possibleAmicableNums.get(j));

					}
				}
			}
		}

		possibleAmicableNums.clear();

		return amicableNumsMap;

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

	public static void main(String[] args) {

		System.out.println("There are next amicable numbers in current range " + getFriedlyIntegers().toString());

	}

}
