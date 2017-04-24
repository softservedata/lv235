package com.softserve.edu.LogicTask;

public class Task331B {

	public static void main(String[] args) {
		int n = 12;
		findAllTiplet(n);
	}

	public static void findAllTiplet(int n) {
		int x = 1; /* default x number */
		int y = 1; /* default y number */
		int z = 1; /* default z number */
		boolean notFindTiplet = true; /* flag for print "...impossible to expand..." massage */
		for (int j = 1; j <= n; j++) {
			for (int i = 1; i <= j; i++) {
				for (int g = 1; g <= i; g++) {
					int tmp = (int) Math.pow(j, 2) + (int) Math.pow(i, 2) + (int) Math.pow(g, 2);
					if (tmp == n) {
						System.out.println("x: " + j + "; y: " + i + "; z: " + g);
						notFindTiplet = false;
					} 
					else if (n == g && notFindTiplet) {
						System.out.println("Sorry. It is impossible to expand " + "a number \" " + n
								+ " \" by formula n = x^2 + y^2 + z^2;");
					}
				}
			}
		}
	}
}
