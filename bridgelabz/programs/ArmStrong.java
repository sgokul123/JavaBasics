package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;

public class ArmStrong {
	public void armStrong(){
		 System.out.println("Please enter a 3 digit number to find if its an Armstrong number:");
	     Utility u=new Utility();  
		 int number = u.inputInteger();
	        if(u.isArmStrong(number)){
	            System.out.println("Number : " + number + " is an Armstrong number");
	        }else{
	            System.out.println("Number : " + number + " is not an Armstrong number");
	        }
	
	}
}
