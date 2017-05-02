package com.softserve.edu.main;

import java.util.ArrayList;
import java.util.List;

public class Task554 {
	/**
	 * Task #554. Given a positive integer n. Get all the triples of natural
	 * numbers, each of which does not exceed n. a^2+b^2=c^2 (a<=b<=c<=n)
	 * @throws IsNotNaturalNumberException
	 */
	public String task554(int number) throws IsNotNaturalNumberException {
		if (isNatural(number) == false) {
			throw new IsNotNaturalNumberException();
		}
		List<String> list = new ArrayList<String>();
		for (int a = 1; a <= number; a++) {
			for (int b = 1; b <= number; b++) {
				for (int c = 1; c <= number; c++) {
					int aplusb = (int) (Math.pow(a, 2) + Math.pow(b, 2));
					int cpow = (int) Math.pow(c, 2);
					if (aplusb == cpow && a <= b && b <= c) {
						list.add("a=" + Integer.toString(a) + " b="
								+ Integer.toString(b) + " c="
								+ Integer.toString(c) + "\n");
					}
				}
			}
		}
		return list.toString();
	}

	public boolean isNatural(int number) {
		if (number < 1) {
			return false;
		}
		return true;
	}
}
