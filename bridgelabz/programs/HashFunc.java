package com.bridgelabz.programs;

/*
* Disc : Hashing Function to search a Number in a slot
* Auth : Sonawane Gokul
* Date : 22/12/2016
*/


import com.bridgelabz.utility.Node;
import com.bridgelabz.utility.Utility;

import java.io.FileReader;

import java.io.BufferedReader;

class HashOperation{
		Node[] start=new Node[11];
		Node[] end=new Node[11];
		
		//Init  Nodes
	 	public void  inits()
		{
			for(int i=0;i<11;i++){
		 start[i]=null;
		 end[i]=null;
		}
		}
		///Add new number
		void add(int data,int val)
		{
         	Node temp=new Node(data);
		if(start[val]==null)
		{
			start[val]=temp;
			end[val]=temp;
			
		}
		else{
			Node temp2=null;
			temp2=end[val];
			temp2.next=temp;
			end[val]=temp2.next;
		        
		}
		
		}
		
		void showList(){
			for(int i=0;i<11;i++){
				System.out.print("At  "+i);
				Node temp=start[i];
				if(temp==null)
				{
				System.out.print("  -->  None");
				}
				else{
				while(temp.next!=null){
					System.out.print("  --> "+temp.value );
				temp=temp.next;
				}	System.out.print("  --> "+temp.value );
				
				}
			    System.out.println(" ");
			}
		}
		void searchList(int val){
			int flag =0;
			int tm=val%11;
				Node temp;
				 temp=start[tm];
				while(temp.next!=null){
				  if(temp.value==val)
				   {	
					flag=1;
					temp=temp.next;
				   }
					  else temp=temp.next;	
			       }
			if(temp.value==val) flag=1;
				   
			              if(flag==1){
					int t=val%11;
					System.out.println(val+" Element is Present at :  "+t+"  List");
			  }
			else  System.out.println(val+" Element is not search ");
			
		}
		
}
public class HashFunc{
	public static void main(String args[]){
		HashOperation list=new HashOperation();
			list.inits();
	
		try
			{	
			Utility u=new Utility();
			FileReader fr=new FileReader("/home/bridgeit/Hash.txt");//Path of the file 		
					//read the data from the file
					BufferedReader br=new BufferedReader(fr);
					System.out.println("The data from the file :- /home/bridgeit/Hash.txt ");
					String CurrentLine;
					CurrentLine=br.readLine(); 
					String[] num=CurrentLine.split("\\s");
					int numbers[]=new int[num.length];

					for(int i =0; i<num.length;i++) 
					{ 
						numbers[i]= Integer.parseInt(num[i]);	
					
					}
	
					try
					{
					for(int i =0; i<num.length;i++)	        		
					{
						int val=numbers[i]%11;
							list.add(numbers[i],val);
	   				}
				   }catch(Exception e){System.out.println(""+e);}
					list.showList();
					System.out.println("Enter number to search");
					int search=u.inputInteger();
					list.searchList(search);
			br.close();		
			}catch(Exception e){System.out.println(""+e);}



	}
}