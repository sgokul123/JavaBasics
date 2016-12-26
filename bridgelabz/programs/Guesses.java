package com.bridgelabz.programs;



import com.bridgelabz.utility.Utility;


public class Guesses {

	public static void main(String args[])
     {
		int status=0,min=0,max=100,low=0,high=1,correct=2;
		String UserVal="No";
		int GuessVal,Guess=0,tries=0;
		System.out.println("It is a User Vs Computer Game .");
		System.out.println("Please Enterr your Value between 0 To 100");
		Utility u=new Utility();
		GuessVal=u.inputInteger();
		Guess=50;
		while(status!=correct){
			tries=tries+1;
			System.out.println("Computer Guess : "+Guess);
			
			if(Guess==GuessVal){
				status=correct;	
			}
			 else{
				System.out.println("is your Value is Less Guess value then  type : 'Yes' else  type :'No' ");
						UserVal=u.inputString();
			 if(UserVal.equalsIgnoreCase("No"))	{
				min=Guess;
					status=low;
				
			  }
			else if(UserVal.equalsIgnoreCase("Yes")){
				max=Guess;
				status=high;
				
			  }
			else{
				
				System.out.println("Soryy Something is wrong...");
			
			  }
			}
			//this is anothe if-else
			if(status==high){
					Guess=(min+max)/2;
				
				
			}else if(status==low){
				Guess=(min+max)/2;
				
				}
			else if(status==correct){
				
				System.out.println("Computer Guessed it...");
				System.out.println("User Value is :"+GuessVal);
				System.out.println("Guess Value is :"+Guess);
				System.out.println("It takes "+tries+"Tries to Guess.");
				
				
			}else{
				
				System.out.println("Sorry Something is Wrong ...");
				System.out.println("Computer Guess is "+Guess);
				System.out.println("It Takes "+tries+"Tries");
				
			}
		}
		}
}