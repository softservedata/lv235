package task323;

import java.util.Scanner;

public class Task323Main {

	
		public static void main(String[] args) {

			System.out.println("Ведіть натуральне число n");
			Scanner sc = new Scanner(System.in);
			int n = Integer.parseInt(sc.next());
			Task323 task323 = new Task323();
			
			System.out.println("coprime Integers with number " + n + ": " +task323.getCoprimeIntegers(n));
			//System.out.println("coprime Integers with number " + n + ": " + getCoprimeIntegers(n));
		}

	}


