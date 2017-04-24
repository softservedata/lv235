package com.softserve.edu.yarych;

import java.util.Scanner;

/*
 * Task #224: a natural number n is given. Find all natural dividers of n.
 */
public class Task224 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter natural number: ");
		int number = sc.nextInt();
		for (int i = 1; i <= number; i++) {
			if ((number%i) == 0) {
				System.out.println(i);
			}
		}
	}

}
