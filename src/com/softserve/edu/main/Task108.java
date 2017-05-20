package com.softserve.edu.main;

import com.softserve.edu.dto.Task108Dto;

public class Task108 {
	/**
	 * Task #108. Given a positive integer n. Get the smallest number 2 ^ r,
	 * that is bigger than n.
	 */
	public Task108Dto compute(int number) throws IsNotNaturalNumberException {
		int power = 0;
		int result = 0;
		while (result <= number) {
			result = (int) Math.pow(2, power);
			power++;
		}
		return new Task108Dto(result);
	}

	public boolean isNatural(int number) {
		if (number < 1) {
			return false;
		}
		return true;
	}
}
