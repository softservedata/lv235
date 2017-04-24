package NoPackage;

import java.util.Scanner;

// Volodymyr Zubchyns'kyi
//  86 а) 332 178 б)

public class App {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		TaskChooser();
	}
	
	public static void TaskChooser() {
		
		int taskChooser;
		
		System.out.println("Виберіть номер задачі 1, 2, 3");
		System.out.print("Вибранй номер: ");
		taskChooser = input.nextInt();
		
		switch (taskChooser) {
		case 1:
			Task1 task1 = new Task1();
			task1.RunTask1();
			break;

		case 2:
			Task2 task2 = new Task2();
			task2.RunTask2();
			break;
			
		default:
			Task3 task3 = new Task3();
			task3.RunTask3();
			break;
			
		}
	}

}
	
	


