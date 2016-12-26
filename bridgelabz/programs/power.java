/*
 * Disc  : Write a Programm to find Power of 2 
 * Auth  :Sonawane Gokul
 * Date  :13/13/2016
 */
package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;

public class power {

	public static void main(String args[]){
		
		int N,pow=1;
		int ch=1;
		Utility u=new Utility();
		while(ch!=0){
		System.out.println("Enter Number :");
		N=u.inputInteger();
		pow=u.power(N);
		System.out.println("The 2^"+N+":"+pow);
		System.out.println("1 )  :find power of 2 :");
		System.out.println("0 )  :Exit from program :");
		System.out.println("Enter your choice :");
		ch=u.inputInteger();
		pow=1;
		}
		System.out.println("Thanks ...");
	}
	
	
}