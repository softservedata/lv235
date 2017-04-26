package volodya;

import java.util.Scanner;

/**
 * class for Task 1.
 * @author Volodymyr Zubchyns'kyi
 */
public class Task1 {

	/**
	 * Scanner for reading from input method.
	 */
	private Scanner input = new Scanner(System.in);

	/**
	 * Use this to run first task.
	 */
	public void runTask1() {
		System.out.println("Given a positive integer. How many digits in the number n");

		int n;
		int counter = 0;

		n = inputData();
		counter = findDigits(n, counter);
		showResult(n, counter);
	}

	/**
	 * Use this method to input data from console.
	 * @return n - entered number.
	 */
	private int inputData() {
		int n;
		System.out.println("Enter n.");
		System.out.print(" n=");
		n = input.nextInt();
		//If you enter a letter, all crash..
		return n;
	}

	/**
	 * Use this method to find all digits.
	 * @param n - entered number.
	 * @param counter - count, how many digits.
	 * @return how many digits in number.
	 */
	private int findDigits(int n, int counter) {
		int m;
		if (n == 0) {
			return 0;
		}
		m = n;
		while (m != 0) {
			m = m / 10;
			counter++;
		}
		return counter;
	}

	/**
	 * Show result in console.
	 * @param n - entered number.
	 * @param counter - counted digits.
	 */
	private void showResult(int n, int counter) {
		switch (counter) {
		case 0:
			System.out.println("Number 0 has 1 digit");
			break;

		case 1:
			System.out.println("Number " + n + " has " + counter + " digit");
			break;

		default:
			System.out.println("Number " + n + " have " + counter + " digits");
			break;
		}
	}
}
