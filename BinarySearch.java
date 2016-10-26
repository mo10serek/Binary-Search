/****************************************************************************
 *
 * Created by: Craig edded by michael
 * Created on: Oct 2016
 * This program lets the user perform a randomized Binary Search.
 * 
 ****************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 

public class BinarySearch {

	public static int[] Sort(int[] array){
		
		//this function uses a "bubble sort" to sort an array in ascending order
		
		int index;
	    boolean flag = true;
	    int temp; //holds a number when switching two objects

	    while(flag) {
	    	
	           flag = false;    //sets flag to false until all possible swaps occur
	           for(index = 0;  index < array.length -1;  index++) {
	        	   
	               if (array[index] > array[index + 1])
	               {
	            	   //swaps the two items if the first is larger than the second
	                   temp = array[index];
	                   array[index] = array[index + 1];
	                   array[index + 1] = temp;
	                   flag = true;
	               } 
	               
	            } 
	      } 
		
		return array;
	}
	
	public static int Search(int[] array, int first, int back, int key){
	//this function uses a "bubble sort" to sort an array in ascending order		

		if (first < back) {
			int mid =  (back + first) / 2;  // Compute mid point.
			if (key < array[mid]) {
				return Search(array, first, mid, key);  // repeat search in bottom half.
			} else if (key > array[mid]) {
				return Search(array, mid + 1, back, key);  // Repeat search in top half.
			} else {
				return mid;
			}
		}

		return -(first + 1);  // Failed to find key

	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//creates an array of 10 items

		int[] numberList = new int[250];
	
		//fills said array with 250 random numbers between 1 and 10
		for (int counter = 0; counter < numberList.length; counter++){
			numberList[counter] = (int)(Math.random()*250 + 1);
			//System.out.println(numberList[counter]); //for debugging, remove later					

		}				

		System.out.println("RANDOMIZED ARRAY:");

		int first = 0;
		int back = 250;
		
		for (int counter = 0; counter < numberList.length; counter++){

			//prints the unsorted array
			System.out.println(numberList[counter]);

		}
		
		numberList = Sort(numberList); //sorts the array
		
		System.out.println("ORDERED ARRAY:");
		for (int counter = 0; counter < numberList.length; counter++){
			//prints the sorted array
			System.out.println(numberList[counter]);
		}
		
		//initializes input stream
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
				
		int key; //integer to hold user's search
		System.out.println("Enter a number to search for in the array (Between 1 and 250)");
		key = Integer.parseInt(br.readLine());		
		
		int numberFound = Search(numberList , first, back, key); //sorts the array
		
		System.out.println("We found your number. it is on " + numberFound + " in the list");
		
	}
}
