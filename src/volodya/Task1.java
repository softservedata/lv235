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
		int m;
		int counter = 0;

		System.out.println("Enter n.");
		System.out.print(" n=");
		n = input.nextInt();
		//If you enter a letter, all crash..

		if (n == 0) {
			System.out.println("Number 0 has 1 digit");
			return;
	}

		m = n;
		while (m != 0) {
			m = m / 10;
			counter++;
		}

		//for correct spelling word "digit(s)"
		switch (counter) {
		case 1:
			System.out.println("Number n " + n + " has " + counter + " digit");
			break;

		default:
			System.out.println("Number n " + n + " has " + counter + " digits");
			break;
		}

	}
}
