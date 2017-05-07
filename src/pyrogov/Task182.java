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
import java.util.Scanner;

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

		System.out.println("Enter natural number n which defines array lenght");

		Scanner sc = new Scanner(System.in);
		int arrayLength = Integer.parseInt(sc.next());
		System.out.println("Enter number which defines left border array");
		int leftArrayBorder = Integer.parseInt(sc.next());

		printCalculatedValues(arrayLength, leftArrayBorder);

	}

	// метод для рахування значень
	public static void printCalculatedValues(int arrayLength, int leftArrayBorder) {

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

		System.out.println("Generated numbers array : " + Arrays.toString(numbers));
		System.out.println(" The number of sequence members that div on 5 and do not div on 7 : " + count);
		System.out.println("The sum of number of sequence members that div on 5 and do not div on 7: " + arraySum);

	}

}
