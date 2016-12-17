import java.util.Arrays;

import java.util.Scanner;


public class BinarySearch {

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int key,n;
		int middle;
		System.out.println(" No of element you have. ");
		n=sc.nextInt();
		
		int first=0,last=n,flag=0;
			//search no using Binary search
		int arr[]=new int[n];
      	System.out.println("Enter Array Elements  :");	
	    for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
	    Arrays.sort(arr);
	    for(int i=0;i<n;i++){
			System.out.print("   "+arr[i]+"At index ->"+i);
		}
	   System.out.println();
	    System.out.println("Enter Search key :");
	    key=sc.nextInt();
	     middle=(first+last)/2;
			while(first<=last)
			{
				if(arr[middle]==key){
					System.out.println("Elment is Present in array at"+middle+"     Location");
					flag=1;
					break;
						}
				else if(key<arr[middle]){
					last=middle-1;
					middle=(first+last)/2;
					
				}
				else{
					first=middle+1;
					middle=(first+last)/2;
				}
				
		  }
			if(flag==0){
				System.out.println("Element is Not Present in List ...");
			}
	sc.close();		
	}
	
	
}
