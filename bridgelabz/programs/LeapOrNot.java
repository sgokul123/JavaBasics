
/*
 * Disc: Write a programm to find year is Leap Year or not
 * Auth :Sonawane  Gokul
 * Date :13/13/2016
 */
package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;

public class LeapOrNot
{
	public static void main(String args[])
    {
		int year;
		Utility u =new Utility();
		
        System.out.println("Please Enter the Year  :");
        
        year=u.inputInteger();
        int isvalid = u.isValid(year);
        
        if(isvalid==1){
        	if(u.isLeapYear(year)){
                System.out.println("Year "+year+" is a Leap Year");
            }
            else{
                System.out.println("Year "+year+" is not a Leap Year");
            }
        }
        else{
        	System.out.println("Year  is not valid ...");
        }
        //Output the test result
    }
}