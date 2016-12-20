import java.util.Scanner;
/*
 * Disc: Write a programm to find year is Leap Year or not
 * Auth :Sonawane  Gokul
 * Date :13/13/2016
 */
public class LeapOrNot
{
	Scanner sc=new Scanner(System.in);
	public static void main(String args[])
    {
		LeapOrNot u=new LeapOrNot();
      int year;
     int ch=0;
        Scanner sc = new Scanner(System.in);
        while(ch!=1){
        		System.out.println("Please Enter the Year  :");
        year=u.isValid();
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
    int isValid(){
    	int num=0,num2=0;
    	int flag=0,cnt=0;
    	while(flag!=1){
    		System.out.println("Enter Year :");
    		num=sc.nextInt();
    		num2=num;
    		while(num>0){
    			num=num/10;
    			cnt=cnt+1;
    		}
    		if(cnt==4){flag = 1;}
    		else {
    			System.out.println("Year Must be 4 disit ..."+cnt);
    		    cnt=0;
    		}
    	}
    	return num2;
    	
    }
}