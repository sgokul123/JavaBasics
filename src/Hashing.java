import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class Hashing
{
	public static void main(String args[])
	{
		try
		{	
			//Create the object of FileREader Class to read the File
			FileReader fr=new FileReader("/home/bridgelabz6/hashing.txt");//Path of the file to 	read					
			//read the data from the file
			BufferedReader br=new BufferedReader(fr);
			System.out.println("The data from the file :- ");
			String CurrentLine;
			CurrentLine=br.readLine(); 
			String[] num=CurrentLine.split("\\s");
			int numbers[]=new int[num.length];
			int rem;			
			for(int i =0; i<num.length;i++) 
			{ 
				numbers[i]= Integer.parseInt(num[i]);		
			}
			//Creating array of OrderedLinklist class
			OrderedLinklist hasharr[]=new OrderedLinklist[11];//cresting slot of 10 using ordered linklist
			for(int i=0;i<11;i++)
			{
				 hasharr[i]=new OrderedLinklist();
			}
			Scanner sc=new Scanner(System.in);
			for(int i=0;i<numbers.length;i++)
			{
				rem=numbers[i]%11; 
				hasharr[rem].add(numbers[i]);//adding numbers into solt
			}
			for(int i=0;i<11;i++)
			{
				System.out.print(i+"  :");
				hasharr[i].showList();//Displaying slots
			}
			System.out.println("Enter number to search :- ");
			int search=sc.nextInt();
			rem=search%11;			
			if(hasharr[rem].search(search)==true)
			{
				hasharr[rem].remove(search);
			}			
			else
				hasharr[rem].add(search);
			for(int i=0;i<11;i++)
			{
				System.out.print(i+"  :");
				hasharr[i].showList();//Displaying slots
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}