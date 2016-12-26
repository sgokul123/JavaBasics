package com.bridgelabz.programs;


/*
*Disc : Regular Expression Demonstration
*Auth :Sonawane Gokul
*Date 22/12/2016
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class RegexMatches
 {	
		Scanner sc=new Scanner(System.in);
		String message="Hello <<Name>>, We have your full name as <<Full Name>> in our system. your contact number is 91-xxxxxxxxxx. Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.";
		private String FName;
		private String LName;
		private String MNumber="0";
		private String date;
		//getter for first name
		public void setFirstName() {
			System.out.println("Enter The First Name :");
			FName=sc.next();
			}
		 //return Date in form dd/mm/yyyy format
	
              //getter for last name
		public void setLastName() {
				System.out.println("Enter The Last Name :");
			LName=sc.next();
		}
		
		//getter for mobile number
		public void setMobileNumber() {

			while(!isTenDigit(MNumber)){	
			System.out.println("Enter The Mobile Number :");
				MNumber=sc.next();
			}
			}
		//getter for date
		public void setDate() {
			System.out.println("Enter The Date (dd/mm/yyyy) :");
			date=sc.next();
			Pattern p=Pattern.compile("^[0-3]?[0-9]/[0-3]?[0-9]/([0-9]{4})$");//"^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$"
		      Matcher m=p.matcher(date);
		
			if(!m.matches())
			{	
				setDate();
			}	
		}
		//is ten digits validation 
	public boolean isTenDigit(String number) {
		if((number.length())==10&&number.contains("[a-zA-Z]+") == false)
			return true;
		else
			return false;
	}
		
	//Replace the user details with regex
	public String RegexReplace()
	{
		String firstName="<<Name>>";
		String fullName="<<Full Name>>";
		String mobileno="xxxxxxxxxx" ;
		String Date="01/01/2016";
		//Regex to replace first Name 
		Pattern p=Pattern.compile(firstName);
		Matcher m=p.matcher(message);
		message=m.replaceAll(FName); 

		//Regex to replace full Name
		p=Pattern.compile(fullName);
		m=p.matcher(message);
		message=m.replaceAll(FName+" "+LName);

		//Regex to replace mobile number
		p=Pattern.compile(mobileno);
		m=p.matcher(message);
		message=m.replaceAll(MNumber);	


		//Regex to replace Date
		p=Pattern.compile(Date);
		m=p.matcher(message);
		message=m.replaceAll(date);
	   return message;
	       }
	
  public static void main( String args[] ) {
		RegexMatches rx=new RegexMatches();
		//Users first name
		rx.setFirstName();
		//Users last name
		rx.setLastName();	
		//Users first mobile number
		rx.setMobileNumber();
		//Users first mobile number
		rx. setDate();
		System.out.println("hi");
		String regixs=rx.RegexReplace();

	System.out.println(regixs);
		
		
		}

}