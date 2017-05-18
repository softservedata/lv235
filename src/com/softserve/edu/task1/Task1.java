package com.softserve.edu.task1;

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
	 * Run first task.
	 */
	public void runTask1() {
		System.out.println("Given a positive integer. How many digits in the number n");
		int n;
		int counter;
		n = inputData();
		counter = findDigits(n);
		showResult(n, counter);
	}

	/**
	 * Input data from console.
	 * @return n - entered number.
	 */
	private int inputData() {
		int n;
		System.out.println("Enter n.");
		System.out.print(" n=");
		n = input.nextInt();
		validateNumber(n);
		return n;
	}

	/**
	 * Find all digits.
	 * @param n - entered number.
	 */
	public int findDigits(int n) {
		int m;
		int counter = 0;
		validateNumber(n);
		m = n;
		while (m != 0) {
			m = m / 10;
			counter++;
		}
		return counter;
	}

	/**
	 * Validate number n as positive integer.
	 * @param n - entered number from console.
	 */
	private void validateNumber(int n) {
		if (n <= 0) {
			throw new NumberFormatException();
		}
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