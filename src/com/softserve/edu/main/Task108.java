package com.softserve.edu.main;

import com.softserve.edu.dto.Task108dto;

public class Task108 {
	/**
	 * Task #108. Given a positive integer n. Get the smallest number 2 ^ r,
	 * that is bigger than n.
	 */
	public Task108dto compute(Task108dto task108dto)
			throws IsNotNaturalNumberException {
		int number = task108dto.getNumber();
		if (isNatural(number) == false) {
			throw new IsNotNaturalNumberException();
		}
		int power = 0;
		int result = 0;
		while (result <= number) {
			result = (int) Math.pow(2, power);
			power++;
		}
		return new Task108dto(result);
	}

	public boolean isNatural(int number) {
		if (number < 1) {
			return false;
		}
		return true;
	}
}
