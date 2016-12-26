package com.bridgelabz.programs;

/*
 * Disc : Programm for Read file and sort the integer values from file using orderd list
 */
import java.io.FileReader;
import java.io.FileWriter;

import com.bridgelabz.utility.Utility;

import java.io.BufferedReader;
class OrderedListProgram
	{
		public static void main(String args[])
			{
				//create the object of the OrderedLinklist class
				OrderedLinklist list=new OrderedLinklist();
				//create the object of Scanner class
				
				Utility u=new Utility();
				try
				{	
					//Create the object of FileREader Class to read the File
					FileReader fr=new FileReader("/home/bridgeit/Ordered.txt");//Path of the file to read					
					//read the data from the file
					BufferedReader br=new BufferedReader(fr);
					System.out.println("The data from the file :- ");
					String CurrentLine;
					CurrentLine=br.readLine(); 
					String[] num=CurrentLine.split("\\s");
					int numbers[]=new int[num.length];
					for(int i =0; i<num.length;i++) 
					{ 
						numbers[i]= Integer.parseInt(num[i]);		
					}
					for(int n:numbers)	        		
					{
						list.add(n);
	   				}
					list.showList();
					System.out.println("Enter number to search");
					int search=u.inputInteger();
					//boolean flag;
					if(list.search(search))
					{
						System.out.println("Number is searched in list");
						//list.remove(search);
					}					
					else
					{ 
						System.out.println("Number is not searched in list");
						list.add(search);						
					}
					fr.close();
					FileWriter fw = new FileWriter("/home/bridgeit/Ordered.txt");//Path of the file to write					
					fw.write(list.listtoString());
					fw.close();
					list.showList();
					//System.out.println(nf.listtoString());
						
				}
				catch(Exception e)
					{
					e.printStackTrace();
				}
		}
}