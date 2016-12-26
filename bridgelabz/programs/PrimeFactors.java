
/*
 * Disc :Write a program for Computes the prime factorization of N using brute force.
 * Auth :Sonawane Gokul
 * Date :14/12/2016
 */
package com.bridgelabz.programs;

import java.io.*;

import com.bridgelabz.utility.Utility;

class PrimeFactors
{
public static void main(String args[]) throws IOException
{
	int n,cnt=0;
	Utility u=new Utility();
	System.out.print("Enter a Number : ");
	n=u.inputInteger();
 	System.out.print("The Prime Factors of "+n+" are : ");
	cnt=u.primeFctore(n);
	System.out.println();
	System.out.println(cnt+"  Prime factors  ");
}
}
