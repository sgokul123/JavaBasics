
/*
 * Disc : Programm for read text from file and split it into wordsusing unorder list
 * Auth :Sonawane Gokul
 * Date :19/12/2016
 */

package com.bridgelabz.programs;



import com.bridgelabz.utility.Utility;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;

	class UnOrderList
		{
			public static void main(String args[])
				{
					//create the object of the UnOrderedLinklist class
					UnOrderedLinklist list=new UnOrderedLinklist();
					//create the object of Scanner class
				try
					{	
						//Create the object of FileREader Class to read the File
						FileReader fr=new FileReader("/home/bridgelabz6/workspace/bridgeeit/src/Unordered.txt");//Path of the file to read					
						//read the data from the file
						
						Utility u=new Utility();
						BufferedReader br=new BufferedReader(fr);
						
						System.out.println("The data from the file :- ");
						String CurrentLine;
						CurrentLine=br.readLine(); 
						String[] words=CurrentLine.split("\\s");
						for(String w:words)	        		
						{
							list.add(w);
		    				}
						list.showList();
						System.out.println("Enter word to search");
						String search=u.inputString();
						boolean flag=list.search(search);
						if(flag==true)
						{
							System.out.println("Word is searched in list");
							//list.remove(search);
						}					
						else
						{ 
							System.out.println("Word is not searched in list");
							list.add(search);						
						}
						fr.close();
						FileWriter fw = new FileWriter("/home/bridgelabz6/workspace/bridgeeit/src/Unordered.txt");//Path of the file to write					
						fw.write(list.listtoString());
						fw.close();
						list.showList();							
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
}
}