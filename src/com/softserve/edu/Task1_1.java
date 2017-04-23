package com.softserve.edu;

import java.util.Scanner;

public class Task1_1 {
    
	/*
	 * Console application task 87
	 */
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
			compute();
	}
	
	/*
	 * Given a natural number n, m. Obtain the sum of m last digits of the number n.
	 */
	@SuppressWarnings("finally")
	public static void compute(){
		int n = 0;
		int m = 0;
		int sum = 0;
		try{
			System.out.print("Input n  ");
			n = Integer.valueOf(scanner.next());
			System.out.print("Input m  ");
			m = Integer.valueOf(scanner.next());
		}
		catch (NumberFormatException e){
		System.out.println("erb");	
		return;
		}
		
		int t = 0;
		int rozmN = n;
		int [] mass;
		while (rozmN >10){
			rozmN /= 10;
			t++;
		}
		t++;
		if(m>t){
			System.out.println("m over count of digits n");	
			contunie();
			return;
		}	
		
		mass = new int[t];
		
		t = n;
		for(int i = 0; i<mass.length; i++){
			mass[i] = t/(1*(int)Math.pow(10,mass.length-1-i));
			t = t%(1*(int)Math.pow(10,mass.length-1-i));
		}
		
		for(int i = mass.length-1; i>=mass.length-m; i--){
			sum+= mass[i];
		}
		
		System.out.println("Sum = "+ sum);	
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
