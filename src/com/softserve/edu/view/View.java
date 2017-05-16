package com.softserve.edu.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.softserve.edu.console.Task108Console;
import com.softserve.edu.console.Task331aConsole;
import com.softserve.edu.console.Task554Console;

public class View {

	public static void main(String[] args) {
		View view = new View();
		view.start();
	}

	private void start() {
		try {
			menu();
		} catch (InputMismatchException e) {
			System.out.println("Enter correct number\n");
		}
		start();
	}

	/**
	 * The menu method.
	 */
	private void menu() {
		while (true) {
			System.out.format("%s%s%s%s", "Enter 1 to open task " + "#108\n",
					"Enter 2 to open task #331(a)\n",
					"Enter 3 to open task #554\n", "Enter 0 to exit\n");
			Scanner scanner = new Scanner(System.in);
			switch (scanner.nextInt()) {
			case 1:
				Task108Console task108ConsoleVer2 = new Task108Console();
				task108ConsoleVer2.start();
				break;
			case 2:
				Task331aConsole task331aConsole = new Task331aConsole();
				task331aConsole.start();
				break;
			case 3:
				Task554Console task554Console = new Task554Console();
				task554Console.start();
				break;
			case 0:
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Enter correct number\n");
				break;
			}
		}
	}
}
