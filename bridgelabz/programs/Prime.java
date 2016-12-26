package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;


public class Prime {
public static void main(String args[]){
	int num;
	int cnt=0;
	Utility u =new Utility();
	System.out.println("Enter the Number");
	num=u.inputInteger();
	
	cnt=u.PrimeSeries(num);
	System.out.println();
	System.out.println(cnt+"   Prime numbers between 0 to "+num);
	
}
}