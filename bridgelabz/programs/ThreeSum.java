package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;
/*
 * Disc :
 * Auth :Sonawane Gokul
 * Date :14/12/2016
 */

public class ThreeSum {
   public static void main(String[] args)  { 
        int n;
        System.out.println("Number of element:");
            Utility u=new Utility();
            n=u.inputInteger();
            	int[] a =new int[n];
    	a=u.getAElement(n);
        int count = u.count(a);
        u.printAll(a);
        System.out.println(count);
    } 
} 
