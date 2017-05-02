package com.softserve.edu.main;

import java.util.ArrayList;
import java.util.List;

public class Task331a {
	/**
	 * Task #331a. Given a positive integer n. Is it possible to represent a
	 * number in the form of a sum of three squares of natural numbers? Show
	 * them if it's possible.
	 * @throws IsNotNaturalNumberException
	 */
	public String task331a(int number) throws IsNotNaturalNumberException {
		if (isNatural(number) == false) {
			throw new IsNotNaturalNumberException();
		}
		List<Integer> list = new ArrayList<>();
		for (int a = 1; a < number; a++) {
			for (int b = 1; b < number; b++) {
				for (int c = 1; c < number; c++) {
					int res = (int) (Math.pow(a, 2) + Math.pow(b, 2) + Math
							.pow(c, 2));
					if (res == number) {
						list.add(a);
						list.add(b);
						list.add(c);
						return list.toString();
					}
				}
			}
			if (a == number - 1 || number < 3) {
				return "Impossible to represent a number\n";
			}
		}
		return "Impossible to represent a number\n";
	}

	public boolean isNatural(int number) {
		if (number < 1) {
			return false;
		}
		return true;
	}
}
