package com.softserve.edu.yarych;

import java.util.Scanner;

public class Task325 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter natural number: ");
		int number = sc.nextInt();
		boolean isSimple = true;
		
		for (int i = 1; i <= number; i++) {
			if ((number%i) == 0) {
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i%j == 0) {
						isSimple = false;
					}
				}
				if (isSimple) {
					System.out.println(i);
				}
			}
		}
		
	}
}
