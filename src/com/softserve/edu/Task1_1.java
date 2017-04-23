package com.softserve.edu;


/*
 * Class for task 87
 */
public class Task1_1 extends Task1 {
	/*
	 * Given a natural number n, m. Obtain the sum of m last digits of the number n.
	 */
	public void compute(){
		int n = 0;
		int m = 0;
		int sum = 0;
		try{
			System.out.print("Input n  ");
			n = Integer.valueOf(scanner.next());
			System.out.print("Input m  ");
			m = Integer.valueOf(scanner.next());
			if(n<0 || m<0){
				throw new NumberFormatException();
			}
		}
		catch (NumberFormatException e){
		System.out.println("Input integer n and m");	
		contunie();
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
