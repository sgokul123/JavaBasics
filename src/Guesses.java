import java.util.Scanner;


public class Guesses {

	public static void main(String args[])
{
		int status=0,min=0,max=100,low=0,high=1,correct=2;
		int GuessVal,Guess=0,tries=0;
		System.out.println("It is a User Vs Computer Game .");
		System.out.println("Please Enterr your Value between 0 To 100");
		Scanner sc=new Scanner(System.in);
		String EnterKey="Hola";
		GuessVal=sc.nextInt();
		Guess=(int) (Math.random()*100+1);
		while(status!=correct){
			tries=tries+1;
			System.out.println("Computer Guess : "+Guess);
			System.out.println("Please Press Enter Key To Continue");
			EnterKey=sc.nextLine();
			if(Guess<GuessVal)
			{
				
				status=low;
				
			}
			else if(Guess>GuessVal)
			{
				
				status=high;
				
			}
			else if(Guess==GuessVal)
			{
				
			status=correct;	
			
			} 
			else{
				
				System.out.println("Soryy Something is wrong...");
				
			}
			//this is anothe if-else
			if(status==high){
				
				max=Guess;
				
				do{
					
					Guess=(int)(Math.random()%100+1);
					
				}while(Guess>max ||Guess <min);
				
				
			}else if(status==low){
				
				min=Guess;
				
				do{
					
					Guess=(int) (Math.random()%100+1);
					
				}while(Guess>max ||Guess <min);
		
			}
			else if(status==correct){
				
				System.out.println("Computer Guessed it...");
				System.out.println("User Value is :"+GuessVal);
				System.out.println("Guess Value is :"+Guess);
				System.out.println("It takes "+tries+"Tries to Guess.");
				
				
			}else{
				
				System.out.println("Sorry Something is Wrong ...");
				System.out.println("Computer Guess is "+Guess);
				System.out.println("It Takes "+tries+"Tries");
				
			}
		}
		}
}
