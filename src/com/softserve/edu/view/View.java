package com.softserve.edu.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.softserve.edu.console.Task108Console;

public class View {

	public static void main(String[] args) {
		View m = new View();
		m.start();
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
	private static void menu() {
		while (true) {
			System.out.format("%s%s%s%s", "Enter 1 to open task " + "#108\n",
					"Enter 2 to open task #331(a)\n",
					"Enter 3 to open task #554\n", "Enter 0 to exit\n");
			Scanner scanner = new Scanner(System.in);
			switch (scanner.nextInt()) {
			case 1:
				Task108Console t = new Task108Console();
				t.start();
				break;
			case 2:
				// TODO task331a
				break;
			case 3:
				// TODO task554();
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
