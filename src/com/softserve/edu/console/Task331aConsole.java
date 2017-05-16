package com.softserve.edu.console;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.softserve.edu.interfaces.ITask331a;
import com.softserve.edu.main.IsNotNaturalNumberException;
import com.softserve.edu.main.Task331a;
/***/
public class Task331aConsole extends Task331a implements ITask331a {
	/***/
	public static void main(String[] args) {
		Task331aConsole task331aConsole = new Task331aConsole();
		task331aConsole.start();
	}
	/***/
	@Override
	public void start() {
		try {
			toConsole(task331a(enterNaturalNumber()));
		} catch (IsNotNaturalNumberException | InputMismatchException e) {
			System.out.println("Input is not a natural number");
		}
	}
	/***/
	@Override
	public int enterNaturalNumber() {
		System.out.println("Enter a natural number n: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in); // Can't close scanner here
		return scanner.nextInt();
	}
	/***/
	@Override
	public void toConsole(String list) {
		System.out
				.println("n is equal to sum of this tripple squares: " + list);
	}
}
