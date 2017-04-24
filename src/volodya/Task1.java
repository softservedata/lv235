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
		System.out.println("Дано натуральне число. Скільки цифр в числі n");

		int n;
		int m;
		int counter = 0;

		System.out.println("Введіть число n.");
		System.out.print(" n=");
		n = input.nextInt();
		//If you enter a letter, all crash..

		if (n == 0) {
			System.out.println("Число 0 має 1 цифру");
			return;
	}

		m = n;
		while (m != 0) {
			m = m / 10;
			counter++;
		}

		// no switch-case for correct spell word "цифра"
		System.out.println("число n " + n + " має " + counter + " цифр");
	}
}
