package NoPackage;

import java.util.Scanner;

// Volodymyr Zubchyns'kyi
//  86 �) 332 178 �)

public class App {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		TaskChooser();
	}
	
	
	public static void Task1() {
		System.out.println("���� ���������� �����. ������ ���� � ���� n");
		
		int n;
		int m;
		int counter=0;
		
		System.out.println("������ ����� n.");
		
		System.out.print(" n=");
		n= input.nextInt();
		// ��� ����� �������� �������� �������, �� ��� ���� ����� ��� �������� :(
		
		if(n==0) {
		System.out.println("����� 0 �� 1 �����");
		return;
		}
		
		m=n;
		// for(int i = 0; m !=0; i++){
		while (m !=0) {
			m = m / 10;
			counter++;
		}
		
		// ��� ����� �������� switch ��� ����, ��� ��������� �������� ����� "�����" (���� 1 �����, 2 ����� � �.�.)
		System.out.println("����� n "+ n + " �� " + counter + " ����");
		}
	
	public static void Task2() {
		System.out.println("���� ���������� ����� n. ������� ��� ����'��� x,y,z,t, �� n=x^2+y^2+z^2+t^2");
		
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
		
		
		// � ���a, , �-1.
		if(x+y+z+t!=n){
		System.out.println("������� ���� �����");
		Task2();
		}
		
		System.out.println("n=" + n + " x^2=" + x + " y^2=" + y + " z^2=" + z + " t^2=" + t );
		System.out.println();
		
		}
	
	public static void Task3() {
		System.out.println("���� ��������� ����� n ,a_1..a_n. ��������� ������� ����� ������� 3 �� ��������� 5 ");
		
		int n = 0;
		int a = 0;
		boolean noArgs = true;
		
		System.out.print("n = ");
		n= input.nextInt();
		System.out.print("a = ");
		a= input.nextInt();
		int mas[] = new int [n+1];
		for(int i=0; i<n; i++)
		{
			mas[i] = a;
			a+=1;
			if(mas[i]%3 == 0 && mas[i]%5 != 0)
			{
				System.out.println("����� a = " + mas[i] + " ������ 3 �� �������� 5" );
				noArgs = false;
			}
		}
		if(noArgs == true)
		{
			System.out.println("� ���� ����������� ���� ����� ������� 3 �� ��������� 5");
		}
		
	}

	//not used in code
	public static void TryAgain() {
		String checker;
		System.out.println("Try again? 1/n: ");
		checker = input.next();
		if (checker == "y") {
			TaskChooser();
		}
	}
	
	public static void TaskChooser() {
		
int taskChooser;
		
		System.out.println("������� ����� ������ 1, 2, 3");
		System.out.print("������� �����: ");
		taskChooser = input.nextInt();
		switch (taskChooser) {
		case 1:
			Task1();
			break;

		case 2:
			Task2();
			break;
			
		default:
			Task3();
			break;
			
		}
	}

}
	
	


