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
	    boolean flag = true;
	    int index;
	    int temp; //holds a number when switching two objects
    	
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
	           
	           if (flag) {
	        	   array = Sort(array); //sorts the array
	           }
	           
	           
	      } 
	       	
		return array;
	}

	public static boolean Search(int[] array, int key){
		
		//this function searches an array for a value using binary search.
		
		boolean found = false; //if the key is found in the array, this is returned as true. false by default.		
		int position;
	    int lowerBound = 0;
	    int upperBound = array.length;	    
	    position = (lowerBound + upperBound) / 2;	     
	    
	    //lowerBound will eventually NOT be <= upperBound if the key is not found.
	    while((array[position] != key) && (lowerBound <= upperBound))
	    {	    	 
	        if (array[position] > key)
	        {	        	 
	        	upperBound = position - 1;        	 
	        } else {
	        	lowerBound = position + 1;	             
	        }	        
	        position = (lowerBound + upperBound) / 2;
	     }

	     if (lowerBound <= upperBound)
	     {
	           found = true;
	     }
	     
		return found;

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//creates an array of 10 items

				int[] numberList = new int[10];
			
				//fills said array with 250 random numbers between 1 and 10
				for (int counter = 0; counter < numberList.length; counter++){
					numberList[counter] = (int)(Math.random()*10 + 1);
					//System.out.println(numberList[counter]); //for debugging, remove later					

				}				

				System.out.println("RANDOMIZED ARRAY:");

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

				boolean found = Search(numberList, key); //searches array "numberList" for user's input
				
				if (found){
					System.out.println("The item you searched for is in the array!");

				} else {
					System.out.println("The item you searched for is not in the array!");

				}
	}

}
