package com.softserve.edu.dto;

/**
 * Task #108. Given a positive integer n. Get the smallest number 2 ^ r, that is
 * bigger than n.
 */
public class Task108Dto {
	int number;

	public Task108Dto() {
	}

	public Task108Dto(int number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task108Dto other = (Task108Dto) obj;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "number=" + number;
	}
}
