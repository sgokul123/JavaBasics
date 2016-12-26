/*
 * Disc : Gambler
 * Auth :Sonawane Gokul
 * Date 20/12/2016
 */
package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;
public class Gambler
{
	public static void main(String args[])
	{
		Utility u=new Utility();
	     System.out.println("Enter balance;");
	     int bal  =u.inputInteger();   
	     // gambler's stating bank roll
	     
	     System.out.println("Enter Goal to win :");
	     int goal   = u.inputInteger();  
	     System.out.println("Enter Trials :");
	     int trials = u.inputInteger();    
	      int wins = 0;   
	      wins=u.gamblerPlay(bal,goal,trials);
	     

	     System.out.println(wins + " wins of " + trials);
	     System.out.println("Percent of games won = " + 100.0 * wins / trials);
	     
	}
}