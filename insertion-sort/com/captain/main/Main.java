package com.captain.main;

import com.captain.sort.InsertionSort;

import static java.lang.Thread.sleep;
import java.util.*;

public class Main{
	public static void main(String[] args) {
		System.out.println("HALO");
		int n2 = 10000000;
		int[] arr2 = new int[n2+1];
		for(int i=n2; i>=0; i--){
			arr2[i]=i;
		}
		sort(arr2, arr2.length);
		System.out.println(Arrays.toString(arr2));
		System.out.println("DONE1");

		try {
			int sec = 4;
			while(sec >0){
				System.out.println(sec--);
				sleep(1000);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int n = 100000000;
		int[] arr = new int[n+1];
		for(int i=n; i>=0; i--){
			arr[i]=i;
		}
		InsertionSort.sort(arr);
		System.out.println("DONEINSERTION");

//

	}

	public static void sort(int[] arr, int n){
		int index = 0;
		while (index < n){
			if (index == 0)
				index = index + 1;
			if (arr[index] >= arr[index-1])
				index = index + 1;
			else{
				int temp = arr[index];
				arr[index]= arr[index-1];
				arr[index-1] = temp;
				index = index -1;
			}
		}
	}

}

