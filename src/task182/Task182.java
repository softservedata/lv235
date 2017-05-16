/**
   * Task #182: a natural number n is given.
   * integers a1, ..., an.
   * Find the number and sum of those.
   * members of this sequence that are divided. 
   * by 5 and do not divide by 7.
  * @author Pyrogov
   */
package task182;

import java.util.Arrays;
import java.util.Scanner;

/**
 * class with descriptions.
 */

public class Task182 {

	public static int printCalculatedValues(int arrayLength, int leftArrayBorder) {

		int[] numbers = new int[arrayLength];
		int arraySum = 0;
		int count = 0;

		for (int i = 0; i < numbers.length; i++) {

			numbers[i] = (int) ((i * 100) + leftArrayBorder);

			if (numbers[i] % 5 == 0 && numbers[i] % 7 != 0) {
				arraySum += numbers[i];
				count++;

			}

		}

//		System.out.println("Generated numbers array : " + Arrays.toString(numbers));
//		System.out.println("The number of sequence members that div on 5 and do not div on 7 : " + count);
//		System.out.println("The sum of number of sequence members that div on 5 and do not div on 7: " + arraySum);
		
		return (arraySum + count);
	}

}
