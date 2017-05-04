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
		int n = inputData();
		showResult(findMatch(n));
	}

	/**
	 * Use this to find x^2 + y^2 + z^2 + t^2.
	 * @param n - inputed by user.
	 * @return array of  x^2; y^2; z^2; t^2.
	 */
	public int[] findMatch(int n) {

		int m;
		int x, y, z, t;
		int counter;

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
		return new int[] { n, x, y, z, t };
	}

	/**
	 * Use this method to input data from console.
	 * @return entered number n.
	 */
	private int inputData() {
		System.out.print(" n=");
		return input.nextInt();
	}

	/**
	 * Use this to output data.
	 * @param array - array to output.
	 */
	private void showResult(int[] array) {
		System.out.println("n=" + array[0] + " x^2=" + array[1] + " y^2=" + array[2] + " z^2=" + array[3] + " t^2=" + array[4]);

	}
}
