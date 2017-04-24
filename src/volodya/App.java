package volodya;

import java.util.Scanner;

/**
 * Main class.
 * @author Volodymyr Zubchyns'kyi
 */
public final class App {

/**
 * Default constructor for class.
 */
private App() {
}

	/**
 	* Scanner for reading from input method.
 	*/
	private static Scanner input = new Scanner(System.in);

	/**
 	* This is start point of program.
 	* @param args
 	* command line arguments.
 	*/
	public static void main(final String[] args) {
		taskChooser();
	}

	/**
	 * This method use to choose task number.
	 */
	public static void taskChooser() {

		int taskChooser;

		System.out.println("Виберіть номер задачі 1, 2, 3");
		System.out.print("Вибранй номер: ");
		taskChooser = input.nextInt();

		switch (taskChooser) {
		case 1:
			Task1 task1 = new Task1();
			task1.runTask1();
			break;

		case 2:
			Task2 task2 = new Task2();
			task2.runTask2();
			break;

		default:
			Task3 task3 = new Task3();
			task3.runTask3();
			break;

		}
	}

}
