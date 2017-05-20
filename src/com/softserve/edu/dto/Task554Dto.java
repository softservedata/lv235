package com.softserve.edu.dto;

public class Task554Dto {
	int a;
	int b;
	int c;

	public Task554Dto() {
	}

	public Task554Dto(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + c;
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
		Task554Dto other = (Task554Dto) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (c != other.c)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Task554Dto [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
}
