package com.softserve.edu.yarych;

import java.util.Scanner;

public class Task561 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter natural number: ");
		int number = sc.nextInt();
		int decimal = 10;
		
		for (int i = 1; i < number; i++) {
			int square = (int) Math.pow(i, 2);
			if (i == decimal) {
				decimal *= 10;
			}
			if (i == square%decimal) {
				System.out.println(i);
			}
		}
	}

}
