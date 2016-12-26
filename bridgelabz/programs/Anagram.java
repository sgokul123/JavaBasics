package com.bridgelabz.programs;


import com.bridgelabz.utility.Utility;
public class Anagram {

	public static void main(String args[])
{
	Utility u=new  Utility();
		System.out.println("Enter String :");
		String s1= u.inputString();
		System.out.println("Entr 2 nd String :");
		String s2=u.inputString();  
	   u.isAnagram(s1, s2);
	
		}
}