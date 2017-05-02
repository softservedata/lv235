package Task2;

import java.util.Scanner;

/**
 * class for Task 2.
 * @author Volodymyr Zubchyns'kyi
 *
 */
public class Task2 {

	/**
 	* Scanner for reading from input.
 	*/
	private Scanner input = new Scanner(System.in);

	/**
	 * Use this method to run Task 2.
	 */
	public void runTask2() {

		System.out.println("Given a positive integer n. Specify the following numbers x,y,z,t, when n=x^2+y^2+z^2+t^2");

		int n;
		int m;
		int x, y, z, t;
		int counter;

		n = inputData();
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

		// Bug, , х-1.
		if (x + y + z + t != n) {
			System.out.println("Enter another number");
			runTask2();
		}

		System.out.println("n=" + n + " x^2=" + x + " y^2=" + y + " z^2=" + z + " t^2=" + t);
	}

	/**
	 * Use this method to input data from console.
	 * @return entered number n.
	 */
	private int inputData() {
		int n;
		System.out.print(" n=");
		n = input.nextInt();
		return n;
	}
}
