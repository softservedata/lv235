package task182;

import java.util.Arrays;
import java.util.Scanner;

public class Task182Main {

	public static void main(String[] args)  {
		System.out.println("Enter natural number n which defines array lenght");
		Scanner sc = new Scanner(System.in);
		int arrayLength = sc.nextInt();  //Integer.parseInt(sc.next());
		System.out.println("Enter number which defines left border array");
		int leftArrayBorder = Integer.parseInt(sc.next());
		Task182 task182 = new Task182();

		try {
			System.out.println(Arrays.toString(task182.printCalculatedValues(arrayLength,leftArrayBorder)));
		} catch (Exception e) {
			System.out.println("No correct result");
			
		}
	}
}
