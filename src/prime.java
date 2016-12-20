import java.util.Scanner;


public class prime {
public static void main(String args[]){
	int num;
	int i,j,flag=1,cnt=0;
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter the Number");
	num=sc.nextInt();
	
	
	for(i=2;i<num;i++)
	{
		for(j=2;j<i;j++)
		{
		     if(i%j==0)
		      {
			   flag=0;
			   break;
		      }
		     else{
		    	 flag=1;
		     }
		 }
		 if(flag==1)
		 {
			 System.out.print(i+" ->");
		     cnt=cnt+1;
		 }
		
	 }
	System.out.println();
	System.out.println(cnt+"   Prime numbers between 0 to "+num);
}
}
