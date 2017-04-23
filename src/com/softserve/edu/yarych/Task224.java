package com.softserve.edu.yarych;

import java.util.Scanner;

public class Task224 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter natural number: ");
		int number = sc.nextInt();
		for (int i = 1; i < number; i++) {
			if ((number%i) == 0) {
				System.out.println(i );
			}
		}
	}

}
