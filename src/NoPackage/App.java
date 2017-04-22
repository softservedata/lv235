package NoPackage;

import java.util.Scanner;

// Volodymyr Zubchyns'kyi
//  86 а) 332 178 б)
public class App {

	 static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task1();

	}
	
	
	public static void Task1() {
		System.out.println("Дано натуральне число. Скільки цифр в числі n");
		
		int n;
		int m;
		int counter=0;
		
		System.out.println("Введіть число n.");
		
		System.out.print(" n=");
		n= input.nextInt();
		// тут можна написати обробник помилок, бо при вводі букви все ламається :(
		
		if(n==0) {
		System.out.println("Число 0 має 1 цифру");
		return;
		}
		
		m=n;
		// for(int i = 0; m !=0; i++){
		while (m !=0) {
			m = m / 10;
			counter++;
		}
		
		// тут можна написати switch для того, щоб правильно писалося слово "цифра" (напр 1 цифра, 2 цифри і т.д.)
		System.out.println("число n "+ n + " має " + counter + " цифр");
		}
	
	}


