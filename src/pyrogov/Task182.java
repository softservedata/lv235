/**
   * Task #182: a natural number n is given.
   * integers a1, ..., an.
   * Find the number and sum of those.
   * members of this sequence that are divided. 
   * by 5 and do not divide by 7.
  * @author Pyrogov
   */
package pyrogov;

import java.util.Arrays;

/**
 * class with descriptions.
 */

public class Task182 {

	/**
	 * main function.
	 *
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		/**
		 * Java doc.
		 */
		printCalculatedValues(10, -50);
	}

	public static void printCalculatedValues(final int arrayLength, final int leftArrayBorder) {

		final int[] numbers = new int[arrayLength];
		int arraySum = 0;
		int count = 0;

		for (int i = 0; i < numbers.length; i++) {

			numbers[i] = (int) ((Math.random() * 100) + leftArrayBorder);

			if (numbers[i] % 5 == 0 && numbers[i] % 7 != 0) {
				arraySum += numbers[i];
				count++;

			}

		}

		System.out.println("Масив згенерованих чисел: " + Arrays.toString(numbers));
		System.out.println("Кількість членів послідовності: " + count);
		System.out.println("Сума членів послідовності: " + arraySum);

	}

}
