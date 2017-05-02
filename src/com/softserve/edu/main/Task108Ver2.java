package com.softserve.edu.main;

public class Task108Ver2 {

	public Task108Ver2() {
	}
	/**
	 * Task #108. Given a positive integer n. Get the smallest number 2 ^ r,
	 * that is bigger than n.
	 */
	public int task108(int number) throws IsNotNaturalNumberException {
		if (isNatural(number) == false) {
			throw new IsNotNaturalNumberException();
		}
		int power = 0;
		int result = 0; 
		while (result <= number) {
			result = (int) Math.pow(2, power);
			power++;
		}
		return result;
	}

	public boolean isNatural(int number) {
		if (number < 1) {
			return false;
		}
		return true;
	}

}
