import java.util.*;
public class Anagram {

	public static void main(String args[])
{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String :");
		String s1= sc.next();
		System.out.println("Entr 2 nd String :");
		String s2=sc.next();  
		int b=0,c=0;
		if(s1.length()>s2.length())
		   {
			System.out.print("String 2nd is smaller");
		   }
		  else if(s1.length()<s2.length())
		  {
			System.out.println("String 1st is smaller");
			}
		  else {
			  
		   for(int i=0;i<s1.length();i++) 
		   {
		      char s = s1.charAt(i);
		      for(int j=0;j<s2.length();j++) 
		      {
		         if(s==s2.charAt(j))
		         {
		            b++;
		         } 
		      }
		      if(b==0)
		         break;
		   }
		   if(b==0)
		      System.out.print("String is not Anagram:");
		   else 
		      System.out.print("String is Anagram :");
		} 
		System.out.print("");


		
		}
}
