package com.softserve.edu;

public class App {
	public static void main(String[] args) {
		System.out.println("Super Calc");
		Calc calc = new Calc();
		System.out.println("1 + 1 = " + calc.add(1, 1));
		System.out.println("10 / 2 = " + calc.div(10, 2));
	}
}
