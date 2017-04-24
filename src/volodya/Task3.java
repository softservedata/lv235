package volodya;

import java.util.Scanner;

/**
 * class for Task 3.
 * @author Volodymyr Zubchyns'kyi
 *
 */
public class Task3 {

	/**
	 * Scanner for reading from input.
	 */
	private Scanner input = new Scanner(System.in);

	/**
	 * Use this to run 3rd Task.
	 */
	public void runTask3() {
		System.out.println("Дано натуральні числа n ,a_1..a_n. Оприділити кількість членів кратних 3 та некратних 5 ");

		int n = 0;
		int a = 0;
		boolean noArgs = true;
		int counter = 0;

		System.out.print("n = ");
		n = input.nextInt();
		System.out.print("a = ");
		a = input.nextInt();
		int[] mas = new int[n + 1];

		for (int i = 0; i < n; i++) {
			mas[i] = a;
			a += 1;
			//Перевірка, чи ділиться на 3 і не ділиться на 5
			if (mas[i] % 3 == 0 && mas[i] % 5 != 0) {
				System.out.println("Число a = " + mas[i] + " Кратне 3 та некратне 5" );
				counter++;
				noArgs = false;
			}
		}
		if (noArgs) {
			System.out.println("У даній послідовності немає чисел кратних 3 та некратних 5");
		}

		System.out.println("Всього " + counter + " чисел");
	}

}
