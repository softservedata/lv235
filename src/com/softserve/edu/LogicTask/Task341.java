package com.softserve.edu.LogicTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Task341 {

	public static void main(String[] args) {
		
		int [] ar = { 9, 3, -5, 7, 1 };
		
		int minModDiff = 0;
		int maxModDiff = 0;
		for (int i = 0; i < ar.length; i++) {
			int min = ar[i];
			int minI = i;
			for (int j = i+1; j < ar.length; j++) {
				if(ar[j] < min) {
				min = ar[j];
				minI = j;
				}
			}
			if (ar[i]!=min) { 
				int tmp = ar[i];
				ar[i] = min;
				ar[minI] = tmp;
			}
			System.out.print(ar[i] + "  ");
		}
		
		maxModDiff = Math.abs(ar[0] - ar[ar.length-1]);
		System.out.println();
		System.out.println("maxModDiff: " + maxModDiff);
		
		System.out.println(ar.length-1 + " - ///////// ");
		
		//*****************
		int [] diff = new int [ar.length-1];
		
		System.out.println("--------- ");
		for (int i = 0; i < diff.length; i++) {
			diff[i] = Math.abs(ar[i] - ar[i+1]);
			System.out.print( diff[i] + " ");
		}
		
		System.out.println();
		System.out.println("----------");
			
			 minModDiff = diff[0];
		
			for (int j = 1; j < diff.length; j++) {
				if(diff[j] < minModDiff) {
					minModDiff = diff[j];
				}
			}
			System.out.print("minModDiff " + minModDiff);
		}
		
		/*
		ArrayList<Integer> list = new ArrayList(10);
		list.add(-5);
		list.add(1);
		list.add(3);
		list.add(3);
		list.add(9);

		Collections.sort(list);

		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		
		System.out.println();
		
		int i = list.get(0) - list.get(list.size()-1);  
		System.out.println("*****" + i);
		list.toArray();
			*/
	}
