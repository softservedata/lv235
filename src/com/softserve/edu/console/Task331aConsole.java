package com.softserve.edu.console;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.softserve.edu.dto.Task331aDto;
import com.softserve.edu.interfaces.ITask331a;
import com.softserve.edu.main.IsNotNaturalNumberException;
import com.softserve.edu.main.Task331a;

/***/
public class Task331aConsole extends Task331a implements ITask331a {
	/**
	 * Main method for task #331a.
	 * @param args
	 */
	public static void main(final String[] args) {
		Task331aConsole task331aConsole = new Task331aConsole();
		task331aConsole.start();
	}

	/**
	 * Start method.
	 */
	@Override
	public void start() {
		try {
			toConsole(getListOfEqualSquareTripple(naturalNumberInput()));
		} catch (IsNotNaturalNumberException | InputMismatchException e) {
			System.out.println("No results");
		}
	}

	/**
	 * NaturalNumberInput method.
	 * @throws IsNotNaturalNumberException
	 */
	@Override
	public int naturalNumberInput() throws IsNotNaturalNumberException {
		System.out.println("Enter a natural number n: ");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		scanner.close();
		if (isNatural(input) == false) {
			throw new IsNotNaturalNumberException();
		}
		return input;
	}

	/**
	 * @throws IsNotNaturalNumberException
	 */
	@Override
	public void toConsole(final List<Task331aDto> list)
			throws IsNotNaturalNumberException {
		if (list.isEmpty() == true) {
			throw new IsNotNaturalNumberException();
		} else {
			System.out.println("n is equal to sum of these tripple squares: "
					+ list);
		}
	}
}
