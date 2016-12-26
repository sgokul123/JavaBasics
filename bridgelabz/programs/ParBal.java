package com.bridgelabz.programs;



import com.bridgelabz.utility.Utility;

public class ParBal
{
 	public static void main(String args[])
{
	int size;
	String s1=new String();
	Utility u=new Utility();
	s1=u.inputString();
	size=s1.length();
	Stack st=new Stack(size);
	int i;
	for(i=0;i<size;i++)
	{
	if(!st.isFull()){
		if(s1.charAt(i)=='(' || s1.charAt(i)== '['||s1.charAt(i)=='{') 
			st.push(s1.charAt(i));
		else if(s1.charAt(i)==')' || s1.charAt(i)== ']'||s1.charAt(i)=='}')
			{
			if(!st.isEmpty()) st.pop();
		}

	
	}
	else{	
	
	}
	
	}
	if(st.isEmpty()){
	System.out.println("Expression is Balanced...");		
	}
else{
	System.out.println("Expression is not Balanced...");
	}
}
}