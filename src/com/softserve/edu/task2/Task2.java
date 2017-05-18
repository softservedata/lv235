package com.softserve.edu.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * class for Task 2.
 * @author Volodymyr Zubchyns'kyi
 */
public class Task2 {

	/**
 	* Scanner for reading from input.
 	*/
	private Scanner input = new Scanner(System.in);

	/**
	 * Run Task 2.
	 */
	public void runTask2() {
		System.out.println("Given a positive integer n. Specify the following numbers x,y,z,t, when n=x^2+y^2+z^2+t^2");
		int n = inputData();
		showResult(findMatch(n));
	}

	/**
	 * Find x^2 + y^2 + z^2 + t^2.
	 * @param n - inputed by user.
	 * @return array of  x^2; y^2; z^2; t^2.
	 */
	public List<Properties> findMatch(int n) {
		validateNumber(n);
		int m;
		int x, y, z, t;
		int counter;
		List<Properties> prop = new ArrayList<>();
		m = n;
		m = (int) Math.sqrt(m);
		x = m * m;
		m = n - x;
		counter = m;
		m = (int) Math.sqrt(m);
		y = m * m;
		m = counter - y;
		counter = m;
		m = (int) Math.sqrt(m);
		z = m * m;
		m = counter - z;
		counter = m;
		m = (int) Math.sqrt(m);
		t = m * m;
		prop.add(new Properties(n, x, y, z, t));
		// Bug, , х-1.
			if (x + y + z + t != n) {
				throw new ArithmeticException("Try another n");
			}
		return prop;
	}

	/**
	 * Validate number n as positive integer.
	 * @param n - entered number from console.
	 */
	private void validateNumber(int n) {
		if (n <= 0) {
			throw new NumberFormatException("Try to enter a positive integer > 0");
		}
	}

	/**
	 * Method to input data from console.
	 * @return entered number n.
	 */
	private int inputData() {
		System.out.print(" n=");
		return input.nextInt();
	}

	/**
	 * Output data.
	 * @param properties - list to output.
	 */
	private void showResult(List<Properties> properties) {
		System.out.println(properties);

	}
}