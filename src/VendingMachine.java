import java.util.Scanner;
class VendingMachine
{
	int notes[]={1000,500,100,50,10,5,2,1};
	int noofnotes[]=new int[8];
	int i=0,total=0;	
	public void count(int number)
	{
		noofnotes[i]=number/notes[i];
		number=number%notes[i];
		if(number>0)
		{	
			i++;
			count(number);
		}
		else
		{
			for(int j=0;j<notes.length;j++)
			{
				if(noofnotes[j]>0)				
					System.out.println(noofnotes[j]+" notes of "+notes[j]+" Rs ");
				total=total+noofnotes[j];
			}
			System.out.println("Total notes : "+total);
		}
	}
	public static void main(String args[])
    { 
	     Scanner sc=new Scanner(System.in);
	     int number;
		System.out.println("Enter value :");
		number=sc.nextInt();
					 
		VendingMachine v=new VendingMachine();
		v.count(number);
	}
} 