package NoPackage;

import java.util.Scanner;

// Volodymyr Zubchyns'kyi
//  86 а) 332 178 б)
public class App {

	 static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Task1();
		Task2();

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
	
	public static void checker() {
		
	}
	
	public static void Task2() {
		System.out.println("Дано натуральне число n. Вказати такі невід'ємні x,y,z,t, що n=x^2+y^2+z^2+t^2");
		
		int n;
		int m;
		int x,y,z,t;
		int counter;
		
		System.out.print(" n=");
		n= input.nextInt();
		m=n;
	
		m=(int) Math.sqrt(m);
		x=m*m;
		m=n-x;
		counter = m;
		m=(int) Math.sqrt(m);
		y=m*m;
		m=counter-y;
		counter = m;
		m=(int) Math.sqrt(m);
		z=m*m;
		m=counter-z;
		counter=m;
		m=(int) Math.sqrt(m);
		t=m*m;
		
		
		// Є багa, , х-1.
		if(x+y+z+t!=n){
		System.out.println("Виберіть інше число");
		Task2();
		}
		
		System.out.println("n=" + n + " x^2=" + x + " y^2=" + y + " z^2=" + z + " t^2=" + t );
		System.out.println();
		
		}
	}
	
	


