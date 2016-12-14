import java.util.Scanner;
/*
 * Disc: Write a programm to find year is Leap Year or not
 * Auth :Sonawane  Gokul
 * Date :13/13/2016
 */
public class LeapOrNot
{
    public static void main(String args[])
    {
 
      int year;
     int ch=0;
        Scanner sc = new Scanner(System.in);
        while(ch!=1){
        		System.out.println("Please Enter the Year  :");
        year=sc.nextInt();
        boolean isLeapYear = false;
 
        if(year % 400 == 0)
        {
            isLeapYear = true;
        }
        else if (year % 100 == 0)
        {
            isLeapYear = false;                               
        }
        else if(year % 4 == 0)
        {
            isLeapYear = true;
        }
        else
        {
            isLeapYear = false;
        }
 
        //Output the test result
        if(isLeapYear)
        {
            System.out.println("Year "+year+" is a Leap Year");
        }
        else
        {
            System.out.println("Year "+year+" is not a Leap Year");
        }
        System.out.println("Enter Your choice :");
    	ch=sc.nextInt();
    
        }
        System.out.println("Thanks...");
    }
}