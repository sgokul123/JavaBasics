import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class NumberAdd {
	static int num=0;
	static int rem=0;
    static    int sum=0;
public static void main(String args[])
{
	
	try{
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

	System.out.println("enter the num=");
	
	Scanner sc=new Scanner(System.in);
	num=Integer.parseInt(sc.next());
	while(num>0){
		rem=num%10;
		num=num/10;
		sum= sum +rem;
		
	}
	
	System.out.println("The Addition Of Numbers is =");
	System.out.println(sum);
	}catch(Exception e){
		System.out.println(e);
	}
}
}
