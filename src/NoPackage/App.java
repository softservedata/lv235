package NoPackage;

import java.util.Scanner;

// Volodymyr Zubchyns'kyi
//  86 �) 332 178 �)
public class App {

	 static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task1();

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
	
	}


