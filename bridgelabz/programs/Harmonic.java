
/*
 * Disc :Write a programm to Prints the Nth harmonic number: 1/1 + 1/2 + ... + 1/N 
 * Auth :Sonawane Gokul
 * Date :14/12/2016
 */
package com.bridgelabz.programs;

import java.util.*;

import com.bridgelabz.utility.Utility;

	 public class Harmonic
	{
	    public static void main(String args[]) 
	    {

	        int num, i=1;
	        double result = 0.0;
	       Utility u=new Utility();
	        System.out.println("Enter the number for length of series");
	        num = u.inputInteger();
	        System.out.println("\n\nSum of Harmonic Series is "+ u.harmonicSeries(num)); 
	    }
	}
