package com.bridgelabz.programs;

/*
*Disc :Palindrom checker using Deque
*Auth :Sonawane Gokul
*DAte : 21/12/2016
*
*/
import com.bridgelabz.utility.Utility;

class PalindromCh
{
	public static void main(String args[]){
		String s1;
		Utility u=new Utility();
		System.out.println("Please Enter String :");
		s1=u.inputString();
		boolean flag=false;
		int len=s1.length();
 		 Deque d=new  Deque(len);
		for(int i=0;i<len;i++){
			d.add(s1.charAt(i));
		}
		int r;
		//f=d.getFront();
		r=d.getRear();
		if(!d.isEmpty())
		{
		
			for(int fr=0;fr<len;fr++)
			{
			  for(int rr=r;rr>=0;rr--)
			  {
				if((int)d.next(fr)==(int)d.prev(rr))
				{
				flag=true;
				}
				else
				{
				flag=false;
				}
			  }
			}	
		}
		else{
		System.out.println("Queue is Empty ...");		

		}
		if(flag){
		System.out.println("String is Palindrom...");
		}
		else{
			System.out.println("String is not Palindrom...");
			}
}
}