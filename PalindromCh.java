
/*
*Disc :Palindrom checker using Deque
*Auth :Sonawane Gokul
*DAte : 21/12/2016
*
*/
import myApp.Deque;
import java.util.Scanner;
class PalindromCh
{
	public static void main(String args[]){
		String s1,s2;
		Scanner sc =new Scanner(System.in);
		System.out.println("Please Enter String :");
		s1=sc.next();
		boolean flag=false;
		int len=s1.length();
 		 Deque d=new  Deque(len);
		for(int i=0;i<len;i++){
			d.add(s1.charAt(i));
		}
		int f,r;
		f=d.getFront();
		r=d.getRear();
		if(!d.isEmpty())
		{
		
			for(int fr=0;fr<len;fr++){
			  for(int rr=r;rr>=0;rr--){
				if((int)d.next(fr)==(int)d.prev(rr)){
				flag=true;
				}
				else{
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
