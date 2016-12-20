import java.util.Scanner;



/*
 * Disc  : Write a Programm to find Power of 2 
 * Auth  :Sonawane Gokul
 * Date  :13/13/2016
 */
public class power {

	public static void main(String args[]){
		
		int N,res=1;
		int ch=1;
		Scanner sc 	=new Scanner(System.in);
		while(ch!=0){
		System.out.println("Enter Number :");
		N=sc.nextInt();
		for(int i=0;i<N;i++){
			res=res*2;
		}
		System.out.println("The 2^"+N+":"+res);
		System.out.println("1 )  :find power of 2 :");
		System.out.println("0 )  :Exit from program :");
		System.out.println("Enter your choice :");
		ch=sc.nextInt();
		res=1;
		}
		System.out.println("Thanks ...");
	}
	
	
}
