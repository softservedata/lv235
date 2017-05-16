package com.softserve.edu.dto;

/**
 * Task #108. Given a positive integer n. Get the smallest number 2 ^ r, that is
 * bigger than n.
 */
public class Task108dto {
	int number;

	public Task108dto() {
	}

	public Task108dto(int number) {
		super();
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
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
		Task108dto other = (Task108dto) obj;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "number=" + number;
	}
}
