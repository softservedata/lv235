package com.softserve.edu;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is a console application with all three tasks.
 */
public class Main {

	public static void main(String[] args) {
		start();
	}

	private static void start() {
		try {
			menu();
		} catch (InputMismatchException e) {
			System.out.println("Enter correct number\n");
		}
		start();
	}

	private static void menu() {
		while (true) {
			System.out.format("%s%s%s%s", "Enter 1 to open task #108\n",
					"Enter 2 to open task #331(a)\n",
					"Enter 3 to open task #554\n", "Enter 0 to exit\n");
			Scanner scanner = new Scanner(System.in);
			switch (scanner.nextInt()) {
			case 1: {
				task108();
				break;
			}
			case 2: {
				task331a();
			}
				break;
			case 3: {
				task554();
			}
				break;
			case 0: {
				scanner.close();
				System.exit(0);
				break;
			}
			default:
				System.out.println("Enter correct number\n");
				break;
			}
		}
	}

	/*
	 * Task #108. Given a positive integer n. Get the smallest number 2 ^ r,
	 * that is bigger than n.
	 */
	private static void task108() {
		int n = 0;
		int r = 0;
		int result = 0;
		System.out.println("Enter a natural number n: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in); // Can't close scanner here
		n = scanner.nextInt();
		if (n < 1) {
			task108();
		}
		while (result <= n) {
			result = (int) Math.pow(2, r);
			r++;
		}
		System.out
				.println("The smallest number 2^r, that is bigger than n is: \n"
						+ result);
	}

	/*
	 * Task #331a. Given a positive integer n. Is it possible to represent a
	 * number in the form of a sum of three squares of natural numbers? Show
	 * them if it's possible.
	 */
	private static void task331a() {
		System.out.println("Enter a natural number n: ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if (n < 1) {
			task331a();
		}
		label: for (int a = 1; a < n; a++) {
			for (int b = 1; b < n; b++) {
				for (int c = 1; c < n; c++) {
					int res = (int) (Math.pow(a, 2) + Math.pow(b, 2) + Math
							.pow(c, 2));
					if (res == n) {
						System.out.println("a=" + a + " b=" + b + " c=" + c);
						break label;
					}
				}
			}
			if (a == n - 1 || n < 3) {
				System.out.println("Impossible to represent a number\n");
			}
		}
	}

	/*
	 * Task #554. Given a positive integer n. Get all the Pythagorean triples of
	 * natural numbers, each of which does not exceed n. a^2+b^2=c^2
	 * (a<=b<=c<=n)
	 */
	private static void task554() { // TODO

	}
}
