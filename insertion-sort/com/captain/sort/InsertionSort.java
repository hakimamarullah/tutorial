package com.captain.sort;
public class InsertionSort{

	public static void sort(int[] inputArray){
		for(int i =1; i< inputArray.length; i++){
			int current = inputArray[i];

			int j = i-1;
			while(j>=0 && inputArray[j] >= current){
				inputArray[j+1] = inputArray[j];
				j--;
			}

			inputArray[j+1] = current;
		}
	}
}