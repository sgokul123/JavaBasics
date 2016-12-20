import java.util.Scanner;

import bridge.Utility;


public class MasterP {
	Scanner sc=new Scanner(System.in);
	Utility u;
	MasterP(){
		u=new Utility();
		//BinaryS();
	//	armStrong();
		bubbleSort();
	int f=u.isValid(20235);
		if(f==1){
			System.out.println("Valid");
		}else{
			System.out.println("Not Valid");
		}
	}
	public static void main(String args[]){
		new MasterP();
	}
	public void armStrong(){
		 System.out.println("Please enter a 3 digit number to find if its an Armstrong number:");
	        int number = new Scanner(System.in).nextInt();
	        if(u.isArmStrong(number)){
	            System.out.println("Number : " + number + " is an Armstrong number");
	        }else{
	            System.out.println("Number : " + number + " is not an Armstrong number");
	        }
	
	}
	public void bubbleSort(){
		int no;
		System.out.println("Enter array size :");
		no=sc.nextInt();
		
		int list []=new int[no];
		int list1 []=new int[no];
		for(int i=0;i<no;i++){
			list[i]=sc.nextInt();
		}
		
		Bubblesort b =new Bubblesort();
       list1=b.bubbleSort(list, no);
       for(int i=0;i<no;i++){
			System.out.print("     ->"+list1[i]);
		}
	}
	public void BinaryS(){
		int n,k;
		System.out.println("Enter Array size :");
		n=sc.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter Array Element :");
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		///System.out.println("Enter Search Element :");
		k=sc.nextInt();
		u.findTriple(arr,n);
	}
	
}
