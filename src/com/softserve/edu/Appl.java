package com.softserve.edu;

import java.util.Scanner;

public class Appl {
 
	public static Scanner scanner = new Scanner(System.in);
	private static Task1 task;
	public static void main(String[] args) {
		String t = "";
		while(true){
			System.out.println("For task1 click '1'\n For task2 click '2'");
			System.out.println("For task3 click '3'");
			t = scanner.next();
			
			switch (t) {
			case "1":
				task = new Task1_1();
				task.compute();
				break;
			case "2":
				task = new Task1_2();
				task.compute();
				break;
			case "3":
				task = new Task1_3();
				task.compute();
				break;
			default:
				break;
			}
			
			System.out.println("For contunie click 'c' else click eni key");
			String con = scanner.next().toUpperCase();
			if(!con.equals("C")){
				return;
			}
		}
	}
}
