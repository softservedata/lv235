package com.softserve.edu.LogicTask;

public class Task243A {

	public static void main(String[] args) {
		int n = 20;   /* incoming number */
		// n = x*2 + y*2
		findCouple(n);
	}
	
	public static void findCouple(int n) { 
		int x = 1;	  /* default x number */
		int y = 1;    /* default y number */
		
		for (int j = 1; j <= n; j++) {
			for (int i = 1; i <= j; i++) {
				int tmp = (int) Math.pow(j, 2) + (int) Math.pow(i, 2);
				if (tmp == n) {
					System.out.println("x: " + j + " y: " + i);
					return;
				} else  if (n==i){
					System.out.println("Sorry. It is impossible to expand "
							+ "a number \" " + n + " \" by formula n = x^2 + y^2;");
				}
			}
		}

	}
}