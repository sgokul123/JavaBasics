package com.bridgelabz.programs;

import java.util.Arrays;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;


public class BinarySearch {

	public static void main(String args[]){
	
		String key;
		int n;
		String word;
		int middle;
		Utility u=new Utility();
		System.out.println(" No of words you have. ");
		n=u.inputInteger();
		
		int first=0,last=n,flag=0;
			//search no using Binary search
		String arr[]=new String[n];
      	System.out.println("Enter Word's  :");	
	    for(int i=0;i<n;i++){
			arr[i]=u.inputString();
	    }
		//Arrays.sort(arr);
	   
		for(int j=0;j<n;j++){
			System.out.print("   "+arr[j]+"At index ->"+j);
		}
	   System.out.println();
	    System.out.println("Enter Search key :");
	    key=u.inputString();
	     middle=(first+last)/2;
	     first = 0;
	     last  = arr.length;
	  
	     while (first < last) {
	         int mid = (first + last) / 2;
	         if (key.compareTo(arr[mid]) < 0) {
	             last = mid;
	         } else if (key.compareTo(arr[mid]) > 0) {
	             first = mid + 1;
	         } else {
	            System.out.println(key+"  At Index : "+mid);break;
	         }
	     }
			
		
			
	}
	
	
}