package com.softserve.edu.console;

import java.util.Scanner;

import com.softserve.edu.main.Task108;

public class Task108Console extends Task108 implements NaturalNumberInput {
	public static void main(String[] args) {
		Task108Console task108Console = new Task108Console();
		task108Console.start();
	}

	public void start() {
		Task108Console task108Console = new Task108Console();
		task108Console.toConsole(task108Console
				.task108(StringToInt(enterNaturalNumber())));
	}

	public int task108(int number) {
		while (getResult() <= number) {
			setResult((int) Math.pow(2, getPower()));
			setPower(getPower() + 1);
		}
		return getResult();
	}

	public int StringToInt(String str) {
		return Integer.parseInt(str);
	}

	@Override
	public String enterNaturalNumber() {
		System.out.println("Enter a natural number n: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in); // Can't close scanner here
		String result = scanner.next();
		setNumber(StringToInt(result));
		if (isNatural(getNumber()) == false) {
			return "Input isn't a natural number";
		}
		return result;
	}

	@Override
	public boolean isNatural(int number) {
		if (number < 1) {
			return false;
		}
		return true;
	}

	@Override
	public void toConsole(int number) {
		System.out
				.println("The smallest number 2^r, that is bigger than n is: \n"
						+ number);
	}
}
