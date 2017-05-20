package com.softserve.edu.console;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.softserve.edu.dto.Task554Dto;
import com.softserve.edu.interfaces.ITask554;
import com.softserve.edu.main.IsNotNaturalNumberException;
import com.softserve.edu.main.Task554;

public class Task554Console extends Task554 implements ITask554 {
	/***/
	public static void main(String[] args) {
		Task554Console task554Console = new Task554Console();
		task554Console.start();
	}

	/***/
	@Override
	public void start() {
		try {
			toConsole(compute(naturalNumberInput()));
		} catch (IsNotNaturalNumberException | InputMismatchException e) {
			System.out.println("Input is not a natural number");
		}
	}

	/***/
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
	public void toConsole(List<Task554Dto> list)
			throws IsNotNaturalNumberException {
		if (list.isEmpty() == true) {
			throw new IsNotNaturalNumberException();
		}
		// else
		// System.out.println("n is equal to sum of these tripple squares: "
		// + list);
	}
}
