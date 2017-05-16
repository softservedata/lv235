package task182;

import java.util.Scanner;

public class Task182Main {

	public static void main(String[] args) {
		
		//System.out.println("Enter natural number n which defines array lenght");
//		Scanner sc = new Scanner(System.in);
//		int arrayLength = Integer.parseInt(sc.next());
//		System.out.println("Enter number which defines left border array");
//		int leftArrayBorder = Integer.parseInt(sc.next());

		Task182 task182 = new Task182();
		//Task182.printCalculatedValues(arrayLength, leftArrayBorder);
		//printCalculatedValues(arrayLength, leftArrayBorder);
		System.out.println(task182.printCalculatedValues(10,10));

	}
}
