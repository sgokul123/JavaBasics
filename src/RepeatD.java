import java.util.Scanner;

/*
 * Disc : Write a Program to find repeated digitd in Number
 * Auth : Sonawane Gokul
 * Date : 13/13/2016
 */
public class RepeatD {

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int num,i,j,res,len=0,num2;
		System.out.println("Enter the Number :");
		num=sc.nextInt();
		num2=num;
		while(num>0){
			num=num/10;
			len=len+1;
		}
		int arr[]=new int[len];
		for(i=0;i<len;i++){
			arr[i]=num2%10;
			num2=num2/10;
		}
		for(i=0;i<len-1;i++){
			for(j=i+1;j<len;j++){
				if(arr[i]==arr[j]){
					arr[j]=0;
				}
			}
		}
		num=0;
		System.out.println("The Number withaut duplicate :");
		for(j=0;j<len;j++){
			if(arr[j]!=0)
			num=(num*10)+arr[j];
				System.out.print(arr[j]);
		}
		 RevercNum a=new RevercNum(num);
	}
}
