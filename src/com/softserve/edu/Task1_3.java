package com.softserve.edu;

import java.util.ArrayList;

/*
 * Class for task 559
 */
public class Task1_3 extends Task1 {
	/*
	 * Given a natural number n. Find all the smaller n numbers of Mersen. (A prime number is called 
	 * a Mersen number if it can be represented as 2n-1, where p is also a prime number.)
	 */
	public void compute(){
		int n = 0;
		int [] simpleNumbers = {2,3,5,7,11,13,17,19,23,29,31};
		ArrayList<Integer> mass = new ArrayList();
		try{
			System.out.print("Input n  ");
			n = Integer.valueOf(scanner.next());
			if(n<0){
				throw new NumberFormatException();
			}
		}
		catch (NumberFormatException e){
		System.out.println("Input integer n");	
		contunie();
		return;
		}
		
		for(int i = 0; i<simpleNumbers.length; i++){
			if(Math.pow(2, simpleNumbers[i])-1 < n){
				mass.add((int)Math.pow(2, simpleNumbers[i])-1);
				System.out.println(mass.get(i));
			}
		}
		contunie();
	}
	
	/*
	 * Continue compute????
	 */
	public void contunie(){
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
