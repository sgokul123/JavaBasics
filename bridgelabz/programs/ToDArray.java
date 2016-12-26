package com.bridgelabz.programs;



import com.bridgelabz.utility.Utility;
/*
 * Diasc write a program to create 2 dimensional array in memory to read in M rows and N cols 
 * Auth : Sonawane Gokul
 * Date :14/12/2016
 */
public class ToDArray {

	public static void main(String args[]){
	try{
		int m,n;
		Utility u=new Utility();
		System.out.println("Please Enter The M -Rows N - Coll's");
		m=u.inputInteger();
		n=u.inputInteger();
		int array[][]=new int[m][n];
		System.out.println("Please Enter Array Element :");
		array=u.getArray(m, n);
		u.printArray(array,m,n);
		//m	System.out.println(os);
	}catch(Exception e){
	  	System.out.print(""+e);
	}
	
	}
}