import java.util.*;
/*
 * Disc :Write a Program for find highest number
 * Auth :Sonawane Gokul
 * Date :12/12/2016
 */
public class highnum {
	static int high,shigh=0,low=10,slow=10;
	
	public static void main(String args[]){
		int num;
		int rem;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number :");
		num=sc.nextInt();
		high=0;
		while(num>0){
			rem=num%10;
			if(rem>high){
				shigh=high;
				high=rem;
			}
			else if(rem<low){
				slow=low;
				low=rem;
				
			}
			num=num/10;
		}
		System.out.println("Highest number is :-"+high);
		System.out.println("sec high  number is :-"+shigh);
		System.out.println("lowest  number is :-"+low);
		System.out.println("Sec lowest  number is :-"+slow);
			}
}
