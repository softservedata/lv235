/**
   * Task #182: a natural number n is given.
   * integers a1, ..., an.
   * Find the number and sum of those.
   * members of this sequence that are divided. 
   * by 5 and do not divide by 7.
  * @author Pyrogov
   */
package task182;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * class with descriptions.
 */

public class Task182 {
	
	public static ArrayList<Integer>getNumberAmountOfMemberSequence(int arrayLength, int leftArrayBorder) throws Exception {

		  int[] numbers = new int[arrayLength];
		  int arraySum = 0;
		  int count = 0;
		  for (int i = 0; i < numbers.length; i++) {
		   numbers[i] = (int) ((i * 100) + leftArrayBorder);
		   if (numbers[i] % 5 == 0 && numbers[i] % 7 != 0) {
		    arraySum += numbers[i];
		    count++;
		   }
		  }
		  ArrayList<Integer> NumberAmountResults = new ArrayList<Integer>();
		  NumberAmountResults.add(arraySum);
		  NumberAmountResults.add(count);

		  if (NumberAmountResults.get(0) == 0 && NumberAmountResults.get(1) == 0) {
		   throw new Exception();
		   
		  }
		  
		  return NumberAmountResults;
		 }
}
	
	
	
	
	//public static ArrayList<Integer> determineNumberAmountOfMemberSequence
	//(int arrayLength, int leftArrayBorder) throws Exception {

//public static int[] determineNumberAmountOfMemberSequence(int arrayLength, int leftArrayBorder) throws Exception {
	
	//	int[] numbers = new int[arrayLength];
//		ArrayList<Integer> numbers = new ArrayList<Integer>();
//		int arraySum = 0;
//		int count = 0;
//		for (int i = 0; i < numbers.size(); i++) {
//			//numbers[i] = (int) ((i * 100) + leftArrayBorder);
//		 numbers.get(i) =  (int) ((i * 100) + leftArrayBorder);
//			if (numbers[i] % 5 == 0 && numbers[i] % 7 != 0) {
//				arraySum += numbers[i];
//				count++;
//			}
//		}
//		int[] arr = new int[] { arraySum, count };
//		if (arr[0] == 0 && arr[1] == 0) {
//			throw new Exception();
//		}
//		return arr;
//		}
//}

// System.out.println("Generated numbers array : " +
// Arrays.toString(numbers));
// System.out.println("The number of sequence members that div on 5 and
// do not div on 7 : " + count);
// System.out.println("The sum of number of sequence members that div on
// 5 and do not div on 7: " + arraySum);
