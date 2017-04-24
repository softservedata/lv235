package com.softserve.edu.LogicTask;

public class Task107 {

	public static void main(String[] args) {
		int m = 25; /* incoming number */
		if (LogicTask107(m) != -1) {
			System.out.println(LogicTask107(m));
		} else 
			System.out.println("Attention!!! Number \"m\" must be an integer and greater than 1.");
		}

	public static int LogicTask107(int m) {
		int k = 1; /* result - max power of number 4 */
		if (m == 2) {
			return 0;
		} else if (m == 3) {
			return 0;
		} else if (m > 3) {
			while ((int) Math.pow(4, k + 1) < m) {
				k++;
			}
			return k;
		} else {
			return -1;
		}
	}
}
