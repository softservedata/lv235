package com.softserve.edu.LogicTask;

public class Task331A {

	public static void main(String[] args) {
		int n = 20;
		findTiplet(n);
	}

	public static void findTiplet(int n) {
		int x = 1; /* default x number */
		int y = 1; /* default y number */
		int z = 1; /* default y number */

		for (int j = 1; j <= n; j++) {
			for (int i = 1; i <= j; i++) {
				for (int g = 1; g <= i; g++) {
					int tmp = (int) Math.pow(j, 2) + (int) Math.pow(i, 2) + (int) Math.pow(g, 2);

					// System.out.println(j + " " + i + " "+ g + " " + tmp);

					if (tmp == n) {
						System.out.println("x: " + j + "; y: " + i + "; z: " + g);
						return;
					} else if (n == g) {
						System.out.println("Sorry. It is impossible to expand " + "a number \" " + n
								+ " \" by formula n = x^2 + y^2 + z^2;");
					}
				}
			}
		}
	}
}