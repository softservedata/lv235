package NoPackage;

import java.util.Scanner;

public class Task1 {
	
	Scanner input = new Scanner(System.in);
	
	public void RunTask1() {
		System.out.println("Дано натуральне число. Скільки цифр в числі n");
	
		int n;
		int m;
		int counter=0;
	
		System.out.println("Введіть число n.");
		System.out.print(" n=");
		n= input.nextInt();
		//тут необхідно написати обробник помилок, бо при вводі букви все ламається :(
	
		if(n==0) {
			System.out.println("Число 0 має 1 цифру");
			return;
	}
	
	m=n;
	while (m !=0) {
		m = m / 10;
		counter++;
	}
	
	// тут можна написати switch для того, щоб правильно писалося слово "цифра" (напр 1 цифра, 2 цифри і т.д.)
	System.out.println("число n "+ n + " має " + counter + " цифр");
	
	}
}
