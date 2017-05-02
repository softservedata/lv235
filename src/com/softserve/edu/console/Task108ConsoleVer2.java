package com.softserve.edu.console;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.softserve.edu.interfaces.ITask108Ver2;
import com.softserve.edu.main.IsNotNaturalNumberException;
import com.softserve.edu.main.Task108Ver2;

public class Task108ConsoleVer2 extends Task108Ver2 implements ITask108Ver2 {

	public static void main(String[] args) {
		Task108ConsoleVer2 task108ConsoleVer2 = new Task108ConsoleVer2();
		task108ConsoleVer2.start();
	}

	@Override
	public void start() {
		try {
			toConsole(task108(enterNaturalNumber()));
		} catch (IsNotNaturalNumberException | InputMismatchException e) {
			System.out.println("Input is not a natural number");
		}
	}

	@Override
	public int enterNaturalNumber() {
		System.out.println("Enter a natural number n: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in); // Can't close scanner here
		return scanner.nextInt();
	}

	@Override
	public void toConsole(int number) {
		System.out
				.println("The smallest number 2^r, that is bigger than n is: \n"
						+ number);
	}

}
