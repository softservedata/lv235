package NoPackage;

import java.util.Scanner;

public class Task2 {

	Scanner input = new Scanner(System.in);
	
	public void RunTask2() {
		
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
			RunTask2();
		}
		
		System.out.println("n=" + n + " x^2=" + x + " y^2=" + y + " z^2=" + z + " t^2=" + t );
		System.out.println();
		
	}
	
}
