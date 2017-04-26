package com.softserve.edu.main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @version 1.0.0
 * @author Tymofii
 */
/* This is a console application with all three tasks. */
final class Main {

	/**
	 * The main method.
	 * @param args
	 */
	public static void main(final String[] args) {
		start();
	}

	/**
	 * The start method.
	 */
	private static void start() {
		try {
			menu();
		} catch (InputMismatchException e) {
			System.out.println("Enter correct number\n");
		}
		start();
	}

	/**
	 * The menu method.
	 */
	private static void menu() {
		while (true) {
			System.out.format("%s%s%s%s", "Enter 1 to open task " + "#108\n",
					"Enter 2 to open task #331(a)\n",
					"Enter 3 to open task #554\n", "Enter 0 to exit\n");
			Scanner scanner = new Scanner(System.in);
			switch (scanner.nextInt()) {
			case 1:
				task108();
				break;
			case 2:
				task331a();
				break;
			case 3:
				task554();
				break;
			case 0:
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Enter correct number\n");
				break;
			}
		}
	}

	/**
	 * Task #108. Given a positive integer n. Get the smallest number 2 ^ r,
	 * that is bigger than n.
	 */
	private static void task108() {
		int n = enterNaturalNumber();
		int r = 0;
		int result = 0;
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

	/**
	 * Task #331a. Given a positive integer n. Is it possible to represent a
	 * number in the form of a sum of three squares of natural numbers? Show
	 * them if it's possible.
	 */
	private static void task331a() {
		int n = enterNaturalNumber();
		if (n < 1) {
			task331a();
		}
		for (int a = 1; a < n; a++) {
			for (int b = 1; b < n; b++) {
				for (int c = 1; c < n; c++) {
					int res = (int) (Math.pow(a, 2) + Math.pow(b, 2) + Math
							.pow(c, 2));
					if (res == n) {
						System.out.format("%na=%d " + "b=%d " + "c=%d%n", a, b,
								c);
						return;
					}
				}
			}
			if (a == n - 1 || n < 3) {
				System.out.println("Impossible to represent a number\n");
			}
		}
	}

	/**
	 * Task #554. Given a positive integer n. Get all the triples of natural
	 * numbers, each of which does not exceed n. a^2+b^2=c^2 (a<=b<=c<=n)
	 */
	private static void task554() {// TODO a<=b<=c
		int n = enterNaturalNumber();
		if (n < 1) {
			task554();
		}
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				for (int c = 1; c <= n; c++) {
					int aplusb = (int) (Math.pow(a, 2) + Math.pow(b, 2));
					int cpow = (int) Math.pow(c, 2);
					if (aplusb == cpow && a <= b && b <= c) {
						System.out
								.format("a=%d " + "b=%d " + "c=%d%n", a, b, c);
					}
				}
			}
		}
	}

	/**
	 * The enterNaturalNumber method.
	 * @return scanner object
	 */
	private static int enterNaturalNumber() {
		System.out.println("Enter a natural number n: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in); // Can't close scanner
		return scanner.nextInt();
	}
}
