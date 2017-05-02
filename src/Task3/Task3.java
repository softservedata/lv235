package Task3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * class for Task 3.
 * @author Volodymyr Zubchyns'kyi
 *
 */
public class Task3 {

	/**
	 * This is multiple number
	 */
	private static final int MULTIPLE_NUMBER = 3;
	/**
	 * This is aliquent number
	 */
	private static final int ALIQUANT_NUMBER = 5;
	/**
	 * Scanner for reading from input.
	 */
	private Scanner input = new Scanner(System.in);

	/**
	 * Use this to run 3rd Task.
	 */
	public void runTask3() {
		System.out.println("Given a positive integer n ,a_1..a_n. How many numbers multiple 3 and aliquant 5 ");

		int n = 0;
		int a = 0;

		n = inputData("n= ");
		a = inputData("a= ");

		countMultipleAliquant(n, a);
	}

	/**
	 * Use this method to input data from console.
	 * @param word - what will write, when you input data.
	 * @return entered number.
	 */
	private int inputData(String word) {
		int number;
		System.out.print(word);
		number = input.nextInt();
		return number;
	}

	/**
	 * Use this method to find numbers, which multiple 3 and aliquant 5
	 * @param n - how many numbers need to check.
	 * @param a - start number.
	 */
	private void countMultipleAliquant(int n, int a) {
		boolean noArgs = true;
		int counter = 0;
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			numbers.add(a);
			a++;
		}

		for (Integer number : numbers) {
			if (number % MULTIPLE_NUMBER == 0 && number % ALIQUANT_NUMBER != 0) {
				System.out.println("Number a = " + number + " multiple 3 and aliquant 5");
				counter++;
				noArgs = false;
			}
		}
		if (noArgs) {
			System.out.println("There are no numbers multiple 3 and aliquant 5");
		}

		System.out.println("There are " + counter + " numbers");
	}
}
