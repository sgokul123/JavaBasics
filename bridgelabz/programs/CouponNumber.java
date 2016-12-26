

/*
 * Disc : Write a program for generate random numbers
 * Auth :Sonawane Gokul
 * Date :17/12/2016
 */
package com.bridgelabz.programs;

import java.util.ArrayList;

import com.bridgelabz.utility.Utility;
public class CouponNumber {
 
		public static void main(String[] args)
		{
			Utility u = new Utility();
			ArrayList<Integer> list = new ArrayList<Integer>(); 
		System.out.println("Enter the Value");
			int n = u.inputInteger();
			list =u.collect(n);
			  for (int i=0; i<list.size(); i++) {
		            System.out.println(list.get(i));
		       }
		       
			
	
    } 

}