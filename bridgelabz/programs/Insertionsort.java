package com.bridgelabz.programs;



import com.bridgelabz.utility.Utility;

public class Insertionsort {

	public static void main(String args[]){
	
		int n;
		Utility u=new Utility();
		System.out.println(" No of words you have. ");
		n=u.inputInteger();
			//search no using Binary search
		String arr[]=new String[n];
      	System.out.println("Enter Word's  :");	
	    for(int i=0;i<n;i++){
			arr[i]=u.inputString();
	    }
		
	   
		for(int j=0;j<n;j++){
			System.out.print("   "+arr[j]+"At index ->"+j);
		}
		
		Insertionsort p=new Insertionsort();
		p.insertionSort(arr, n);
		
	    System.out.println();
	    for(int j=0;j<n;j++){
			System.out.print("   "+arr[j]+"At index ->"+j);
		}
	}
	public  void insertionSortAsc(String[] arr, int i) {
        String temp = arr[i];
        int j = i-1;
        while (j >= 0 && arr[j].compareToIgnoreCase(temp) > 0) {
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=temp; 
    }

    public  void insertionSort(String[] arr, int n) {
        for(int i = 1; i<n; i++) {
            insertionSortAsc(arr, i);
        }
    }
	
}