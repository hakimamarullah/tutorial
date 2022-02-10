package com.captain.main;

import com.captain.sort.InsertionSort;
public class Main{
	public static void main(String[] args) {
		int[] arr = new int[]{10,9,8,7,6,5,4,3,2,1};
		InsertionSort.sort(arr);
		for(int i : arr){
			System.out.print(i +" ");
		}
	}
}