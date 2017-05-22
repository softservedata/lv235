package com.softserve.edu.main;

import java.util.ArrayList;
import java.util.List;
import com.softserve.edu.dto.Task331aDto;

/**
 * Class for task #331a.
 */
public class Task331a {
	/**
	 * Task #331a. Given a positive integer n. Is it possible to represent a
	 * number in the form of a sum of three squares of natural numbers? Show
	 * them if it's possible.
	 * @throws IsNotNaturalNumberException.
	 * @return list.
	 * @param number
	 */
	public List<Task331aDto> getListOfEqualSquareTripple(final int number) {
		List<Task331aDto> list = new ArrayList<>();
		for (int a = 1; a < number; a++) { 
			for (int b = 1; b < number; b++) {
				for (int c = 1; c < number; c++) {
					int res = (int) (Math.pow(a, 2) + Math.pow(b, 2) + Math
							.pow(c, 2));
					if (res == number) {
						list.add(new Task331aDto(a, b, c));
						return list;
					}
				}
			}
		}
		return list;
	}

	/**
	 * Boolean method to check if number is natural.
	 * @param number
	 * @return boolean
	 */
	public boolean isNatural(final int number) {
		if (number < 1) {
			return false;
		}
		return true;
	}
}
