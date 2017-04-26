package com.softserve.edu.main;

public class Task108 {
	int number;
	int power;
	int result;

	public Task108() {
	}

	public Task108(int number, int power, int result) {
		this.number = number;
		this.power = power;
		this.result = result;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Task108 [number=" + number + ", power=" + power + ", result="
				+ result + "]";
	}
}
