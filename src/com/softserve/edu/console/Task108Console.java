package com.softserve.edu.console;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.softserve.edu.dto.Task108dto;
import com.softserve.edu.interfaces.ITask108;
import com.softserve.edu.main.IsNotNaturalNumberException;
import com.softserve.edu.main.Task108;

/***/
public class Task108Console extends Task108 implements ITask108 {
	/***/
	@Override
	public void start() {
		try {
			toConsole(compute(enterNaturalNumber()));
		} catch (IsNotNaturalNumberException | InputMismatchException e) {
			System.out.println("Input is not a natural number");
		}
	}

	/***/
	@Override
	public Task108dto enterNaturalNumber() {
		System.out.println("Enter a natural number n: ");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		scanner.close();
		return new Task108dto(input);
	}

	/***/
	@Override
	public void toConsole(Task108dto d) {
		System.out
				.println("The smallest number 2^r, that is bigger than n is: \n"
						+ d);
	}
}
