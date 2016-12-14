import java.util.*;
/*
 * Disc : Write a Program for REverce Number
 * Auth :Sonawane Gokul
 * Date :12/12/2016
 */
public class RevercNum {
	 static int Num=0,rem,reverce=0;
		
	 RevercNum (int n){
		 Num=n;
		 reverce();
	 }
	 void reverce(){
		// Scanner sc =new Scanner(System.in);
		//	System.out.println("Please Enter The Number :");
		//Num=sc.nextInt();
			while(Num>0){
				rem=Num%10;
				Num=Num/10;
				reverce=(reverce*10)+rem;
			}
			//reverce=(reverce*10)+rem;
			System.out.println("the Reverce is :"+reverce);
	 }
	public static void main(String args[]){
		RevercNum o=new RevercNum(5412121);
		
	}
	
}
