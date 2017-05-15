package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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

	public int counter = 0;
	/**
	 * Use this to run 3rd Task.
	 */
	public void runTask3() {
		System.out.println("Given a positive integer n ,a_1..a_n. How many numbers multiple 3 and aliquant 5 ");

		int n;
		int a;

		n = inputData("n= ");
		a = inputData("a= ");

		showResult(countMultipleAliquant(n, a));
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
	public List<Integer> countMultipleAliquant(int n, int a) {

		boolean noArgs = true;
		List<Integer> numbers = new ArrayList<>();
		List<Integer> resources = new ArrayList<>();

		if ( n <= 0 || a <= 0) {
			throw new NumberFormatException();
		}

		for (int i = 0; i < n; i++) {
			numbers.add(a);
			a++;
		}

		for (Integer number : numbers) {
			if (number % MULTIPLE_NUMBER == 0 && number % ALIQUANT_NUMBER != 0) {
				resources.add(number);
				counter++;
				noArgs = false;
			}
		}
		if (noArgs) {
			throw new NoSuchElementException("There are no numbers multiple 3 and aliquant 5");
		}
		return resources;
	}

	/**
	 * Use this method to show result.
	 * @param numbers - list, which to display.
	 */
	private void showResult(List<Integer> numbers) {
		for (Integer number : numbers) {
			System.out.println("Number a = " + number + " multiple 3 and aliquant 5");
		}
		System.out.println("There are " + counter + " numbers");
	}
}
