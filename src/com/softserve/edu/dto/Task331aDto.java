package com.softserve.edu.dto;

/**
 * DTO class for task #331a.
 */
public class Task331aDto {
	/**
	 * Variable a for task #331a.
	 */
	private int a;
	/**
	 * Variable b for task #331a.
	 */
	private int b;
	/**
	 * Variable b for task #331a.
	 */
	private int c;

	/**
	 * Constructor.
	 */
	public Task331aDto() {
	}

	/**
	 * @param a
	 * @param b
	 * @param c
	 */
	public Task331aDto(final int a, final int b, final int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * @return a
	 */
	public int getA() {
		return a;
	}

	/**
	 * @param a
	 */
	public void setA(final int a) {
		this.a = a;
	}

	/**
	 * @return b
	 */
	public int getB() {
		return b;
	}

	/**
	 * @param b
	 */
	public void setB(final int b) {
		this.b = b;
	}

	/**
	 * @return c
	 */
	public int getC() {
		return c;
	}

	/**
	 * @param c
	 */
	public void setC(final int c) {
		this.c = c;
	}

	/**
	 * HashCode method.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + c;
		return result;
	}

	/**
	 * Equals method.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Task331aDto other = (Task331aDto) obj;
		if (a != other.a) {
			return false;
		}
		if (b != other.b) {
			return false;
		}
		if (c != other.c) {
			return false;
		}
		return true;
	}

	/**
	 * toString method.
	 */
	@Override
	public String toString() {
		return "a=" + a + ", b=" + b + ", c=" + c;
	}
}
