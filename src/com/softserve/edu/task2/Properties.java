package com.softserve.edu.task2;

/**
 * class for properties for task2. It`s a transfer calss
 * @author Volodymyr Zubchyns'kyi
 */
public class Properties {


	private int n, x, y, z, t;

	/**
	 * This is the main constructor of class Properties.
	 * @param n - n;
	 * @param x - x;
	 * @param y - y;
	 * @param z - z;
	 * @param t - t;
	 */
	public Properties(int n, int x, int y, int z, int t) {
		super();
		this.n = n;
		this.x = x;
		this.y = y;
		this.z = z;
		this.t = t;
	}

	@Override
	public String toString() {
		return "n=" + n + " x^2=" + x + " y^2=" + y + " z^2=" + z + " t^2=" + t;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + n;
		result = prime * result + t;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
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
		Properties other = (Properties) obj;
		if (n != other.n)
			return false;
		if (t != other.t)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}

	public void setN(int n) {
		this.n = n;
	}
	public int getN() {
		return n;
	}

	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}

	public void setZ(int z) {
		this.z = z;
	}
	public int getZ() {
		return z;
	}

	public void setT(int t) {
		this.t = t;
	}
	public int getT() {
		return t;
	}

}