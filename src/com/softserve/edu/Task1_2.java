package com.softserve.edu;

import java.util.ArrayList;
import java.util.Scanner;

public class Task1_2 {

	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		compute();
	}

	public static void compute(){
		int n = 0;
		int m = 0;
		ArrayList<Integer> mass = new ArrayList();
		try{
			System.out.print("Input n  ");
			n = Integer.valueOf(scanner.next());
			System.out.print("Input m  ");
			m = Integer.valueOf(scanner.next());
		}
		catch (NumberFormatException e){
		System.out.println("Input integer n and m");	
		contunie();
		return;
		}
		
		for(int i = Math.max(n, m); i<n*m; i++){
			if(i%n==0 && i%m == 0){
				mass.add(i);
			}
		}
		if(mass.size()==0){
			System.out.println("No number");
		}
		for(int i : mass){
			System.out.println(i);
		}
		contunie();
	}
	
	public static void contunie(){
		System.out.println("\nFor  exit click 'e' to contunie click eny key");
		String y = scanner.next().toUpperCase();
		if(y.equals("E")){
			return;
		}
		else{
			compute();
		}
	}
}
