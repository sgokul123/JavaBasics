import java.util.*;
/*
 * Disc :Write a programm to Prints the Nth harmonic number: 1/1 + 1/2 + ... + 1/N 
 * Auth :Sonawane Gokul
 * Date :14/12/2016
 */
	class Harmonic
	{
	    public static void main(String args[]) 
	    {

	        int num, i=1;
	        double rst = 0.0;
	        Scanner in=new Scanner(System.in);
	        System.out.println("Enter the number for length of series");
	        num = in.nextInt();

	        while(i <= num)
	        {
	        	if(i==num) 
	        		System.out.print("1/"+i+"");
	        	else   
	        		System.out.print("1/"+i+" +");
	             rst = rst + (double) 1 / i;
	             	 	i++;
	        }

	        System.out.println("\n\nSum of Harmonic Series is "+rst); 
	    }
	}