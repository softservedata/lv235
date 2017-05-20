package com.softserve.edu.console;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.softserve.edu.dto.Task108Dto;
import com.softserve.edu.interfaces.ITask108;
import com.softserve.edu.main.IsNotNaturalNumberException;
import com.softserve.edu.main.Task108;

/***/
public class Task108Console extends Task108 implements ITask108 {

	public static void main(String[] args) {
		Task108Console task108Console = new Task108Console();
		task108Console.start();
	}

	@Override
	public void start() {
		try {
			toConsole(compute(naturalNumberInput()));
		} catch (IsNotNaturalNumberException | InputMismatchException e) {
			System.out.println("Input is not a natural number");
		}
	}

	/**
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

	/***/
	@Override
	public void toConsole(Task108Dto task108dto) {
		System.out
				.println("The smallest number 2^r, that is bigger than n is: \n"
						+ task108dto);
	}
}
