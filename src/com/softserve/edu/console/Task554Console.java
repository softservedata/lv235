package com.softserve.edu.console;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.softserve.edu.interfaces.ITask554;
import com.softserve.edu.main.IsNotNaturalNumberException;
import com.softserve.edu.main.Task554;

public class Task554Console extends Task554 implements ITask554 {

	public static void main(String[] args) {
		Task554Console task554Console = new Task554Console();
		task554Console.start();
		// String s = "abcd";
		// s = s.substring(0, s.length() - 1);
	}

	@Override
	public void start() {
		try {
			toConsole(task554(enterNaturalNumber()));
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
	public void toConsole(String list) {
		list = list.replaceAll(",", "");
		list = list.substring(1, list.length() - 1);
		System.out
				.println("Triples of numbers, each of which doesn't exceed n. a^2+b^2=c^2\n"
						+ list);
	}
}
