package com.bridgelabz.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class Utility {
	BufferedReader br;
	public Utility(){
		br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	public static void main(String args[]){
		
		//Utility u=new Utility();
		
		
	}
	//validate username by checking length
	public boolean checkLength(String temp)
	{
		int length=temp.length();
		if(length<3)
		{
		return false;
		}
		else
		{
		return true;	
		}
	}
	public String replaceUsername(String temp)
	{
		String uname="Hello username";
		uname=uname.replaceAll("username",temp);
		return uname;
	}

	public  boolean isArmStrong(int number) {
        int result = 0;
        int orig = number;
        while(number != 0){
            int remainder = number%10;
            result = result + remainder*remainder*remainder;
            number = number/10;
        }
        //number is Armstrong return true
        if(orig == result){
            return true;
        }
      
        return false;
    } 

//Calculate percentage of head and tail
public void countHeadTail(int no)
{
int head=0;
int tail=0;
int i;

float headPer,tailPer;
	Random r=new Random();
	for(i=0;i<no;i++)
	{
		if((r.nextInt(no)%2)< 0.5 ) //creating random no to count head and tail
		{
		head++;
		}
		else
		{
		tail++;
		}
	}
	headPer=head*(100/no);	//calculating percentage of head
	tailPer=tail*(100/no);	//calculating percentage of tail
	System.out.println("No of heads:"+headPer);
	System.out.println("No of tails:"+tailPer);
}
//To calculate prime factors of n no
public void PrimeFactors(int no) 
{
	int factor;
	for(factor=2;factor*factor<=no;factor++)
	{
		while(no%factor==0)
		{
			System.out.println(factor+" ");
			no=no/factor;
		}
	}
	if(no>1)
		System.out.println(no);
}
//String is anagram or not
public void isAnagram(String s1,String s2)
{
		int b=0,c=0;
		if(s1.length()>s2.length())
		{
			System.out.print("String 2nd is smaller");
		}
		else if(s1.length()<s2.length())
		{
			System.out.println("String 1st is smaller");
		}
		else {
			 for(int i=0;i<s1.length();i++) 
			   {
				b=0;
			      char s = s1.charAt(i);
			      for(int j=0;j<s2.length();j++) 
			      {
			         if(s==s2.charAt(j))
			         {
			            b++;
			         } 
			      }
			      if(b==0)
			         break;
			   }
			   if(b==0)
			      System.out.print("String is not Anagram:");
			   else 
			      System.out.print("String is Anagram :");
	} 
		
}
//Find triple that sums to zero
public void findTriple(int list[],int no)
{
int i,j,k,flag=0;
for(i=0;i<no;i++)
{
	for(j=i+1;j<no;j++)
	{
		for(k=j+1;k<no;k++)
		{
			if((list[i]+list[j]+list[k])==0)
			{
			System.out.println("Combination of triples: "+list[i]+" "+list[j]+" "+list[k]+"=0");
			flag=1;
			break;
			}
		}
	}
}
if(flag==0)
	System.out.println("No triple found");
}


//search no using Binary search
public void binaryNoSearch(int search,int array[]) 
{
	int key,n;
	int middle;
	System.out.println(" No of element you have. ");
	n=array.length;
	
	int first=0,last=n,flag=0;
		//search no using Binary search
	int arr[]=new int[n];
	arr=array;
    Arrays.sort(arr);
    for(int i=0;i<n;i++){
		System.out.print("   "+arr[i]+"At index ->"+i);
	}
    System.out.println();
    key=search;
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
}
// Validation of Leap Year
	public boolean isLeapYear(int year){
		boolean b=false;
	if(year % 400 == 0)
	{
   b= true;
	}
	else if (year % 100 == 0)
	{
 b=  false;                               
	}
	else if(year % 4 == 0)
	{
   b= true;
	}
	else
	{
   b= false;
	}
	return b;
	}
	
	
	//Wtrite code year validation.
	public int isValid(int n){
		int flag=0,cnt=0;
		int num=n;;
			while(num>0){
    			num=num/10;
    			cnt=cnt+1;
    		}
			
    		if(cnt==4)
    		{
    			flag=1;
    			}
    		else {
    				flag=0;
    				}
    	
    	return flag;
    
	}
	
	
	//Calculate the power of N 
	public int power(int n){
		
		int num=1;
		for(int i=0;i<n;i++){
			num=num*2;
		}
		return num;
	}
	
	
	//Print Harmonic series of N
	public double harmonicSeries(int num){
		double result = 0;
		int i=1;
		System.out.print(""+i+"+");
    	
		while(i <= num)
        {
        	if(i==num) 
        		System.out.print("1/"+i+"");
        	else   
        		System.out.print("1/"+i+" +");
             result = result + (double) 1 / i;
             	 	i++;
        }
		return result;
	}
	//Search world using binary search
	public void binaryWordSearch(String list[],String word) 
	{
		int i,first=0;
		int count=0;
		int last=list.length-1;
		int middle=(first+last)/2;
		//searching start
		for(i=0;i<=last;i++)
		{
			if((list[middle].compareTo(word))==0)//match found
			{
			count++;
			System.out.println("Match found at "+(middle+1));
			break;
			}
			else if(list[middle].compareTo(word)<0)//middle is less than word to be search
			{
			first=middle+1;
			count++;
			}
			else	//middle is greater than word to be search
			{
			last=middle-1;
			count++;
			}
			middle=(first+last)/2;
		}
		if(first>last)	//word is not found
			System.out.println("Word is not found "+word);

		System.out.println("No of attempts to search"+count);
	}


	//bubble sort for integers
	public int[] bubbleSort(int list[],int no)
	{
		int i,j,temp;
		for(i=0;i<no;i++)
		{
			for(j=0;j<no-i-1;j++)
			{
			//bubble sort logic
				if(list[j]>list[j+1])
				{
				temp=list[j+1];
				list[j+1]=list[j];br = new BufferedReader(new InputStreamReader(System.in));
				
				list[j]=temp;
				}
			}
		} 
		return list;
	}

	
	public int inputInteger()
    {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		try{
	   		int number = Integer.parseInt(br.readLine());
	   		return number;
   		}catch(Exception e) {
   			System.out.println(e);
   		}
		return 0;
    }
	
	//input string
		public String inputString(){
			try{
				return br.readLine();
			}
			catch(Exception e){
				System.out.println(e);
			}
			return "";
	}
		//input double
		public double inputDouble(){
			try{
				return br.read();
			}
			catch(Exception e){
				System.out.println(e);
			}
			return 0.0;
		}
		// Calculate the Prime numbers between range
		public int PrimeSeries(int num) {
			int flag=0 ,cnt=0;
			for(int i=2;i<num;i++)
			{
				for(int j=2;j<i;j++)
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
			return cnt;
		}
		//Calculate the Prime factors of Number
		public int  primeFctore(int n) {
			int i=2;
			int count=0;
			while(n>1)
			{
				if(n%i == 0)
				{
					System.out.print(i+" ");
					n=n/i;
					count=count+1;
				}
				else
					i++;
			}
			return count;
		}
		public int gamblerPlay(int bal,int goal,int trials) {
			int wins=0;
			 for (int t = 0; t < trials; t++) {
		    	  	int cash = bal;
		    	  	while (cash > 0 && cash < goal) {
		    		 if (Math.random() < 0.5) 
		    			 cash++;     

		    		 else                    
		    			 cash--;    
		    	 }
		    	 if (cash == goal) wins++;    
		    	 // did gambler go achieve desired goal?
		     }
			
			return wins;
		}
		//
		public static int getCoupon(int n) {
	        return (int) (Math.random() * n);
	    }

		//get randome coupen 
		public  ArrayList collect(int n) {
	        boolean[] isCollected = new boolean[n]; // isCollected[i] = true if card type i already collected
	        ArrayList<Integer> list = new ArrayList<Integer>(); 
	        int count = 0;                          
	        int distinct  = 0;                      

	        // repeat until you've collected all n card types
	        while (distinct < n) {
	            int value = getCoupon(n);            // pick a random card 
	            count++;                            
	            if (!isCollected[value]) {           
	                distinct++;
			 list.add(new Integer(distinct));
	                isCollected[value] = true;
	            }
	        }
		 Collections.shuffle(list);
	       System.out.println("Total randome count : "+count);
	        System.out.println("Distinct number count  : "+distinct);
	 	    return list;
	      }
		
		//Get Array Elements
		public int[][] getArray(int m,int n) {
			int array[][]=new int[m][n];
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					array[i][j]=inputInteger();
				}
			} 
			return array;
		}
		//Display  array
		public void printArray(int[][] array, int m, int n)
		{
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					System.out.println(array[i][j]);
							
				}
			}
			
		}
		//get count of addition of three is =0
		 public  int count(int[] a)
		 {
		        int n = a.length;
		        int count = 0;
		        for (int i = 0; i < n; i++) {
		            for (int j = i+1; j < n; j++) {
		                for (int k = j+1; k < n; k++) {
		                    if (a[i] + a[j] + a[k] == 0) {
		                        count++;
		                    }
		                }
		            }
		        }
		        return count;
		    } 
		 //Display Addition of three =0
		  public  void printAll(int[] a) {
		        int n = a.length;
		        for (int i = 0; i < n; i++) {
		            for (int j = i+1; j < n; j++) {
		                for (int k = j+1; k < n; k++) {
		                    if (a[i] + a[j] + a[k] == 0) {
		                        System.out.println(a[i] + " +" + a[j] + "+ " + a[k]+"=  0");
		                    }
		                }
		            }
		        }
		    }
		// get single dimentional array
		public int[] getAElement(int n) {
			int[] a =new int[n];
	    	for(int i=0;i<n;i++)
    		{
    		a[i]=inputInteger();  // In in = new In(args[0]);
    	     
    		}
			return a;
		}
		public boolean insert(int player, int row, int coll,int [][] arr) {
			if(arr[row][coll]==0){
				arr[row][coll]=player;	
				return true;	
				}
				else {return false;}
		}
		public boolean isWon(int curP, int row, int coll,int[][] arr) {
			return arr[row][0]==curP &&arr[row][1]==curP && arr[row][2]==curP||arr[0][coll]==curP && arr[1][coll]==curP&&arr[2][coll]==curP||arr[0][0]==curP &&arr[1][1]==curP && arr[2][2]==curP||arr[0][2]==curP && arr[1][1]==curP&&arr[2][0]==curP;
			
		}
		public void board(int[][] arr) {
			char arr1[][]=new char[3][3];
			
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
				if(arr[i][j]==1)	
				{
					arr1[i][j]='x';
				}else if(arr[i][j]==2){arr1[i][j]='0';}
				else{arr1[i][j]=' ';}
			    }	
			}
			for(int i=0;i<3;i++){
			System.out.println("   "+arr1[i][0]+"   |  "+arr1[i][1]+"   |  "+arr1[i][2]+"  ");
			System.out.println("");
			}	
		}
		public String inputStrings() {
			String s="";
			try{ 
			 s=br.readLine();
			}catch(Exception e){}
			return s;
			}
		
		

}
