import java.util.*;
      public class Gambler
      {
       public static void main(String args[])
	{
    	   Scanner sc=new Scanner(System.in);
    	   System.out.println("Enter stake ;");
        int stake  =sc.nextInt();    // gambler's stating bankroll
        System.out.println("Enter Goal :");
        int goal   = sc.nextInt();    // gambler's desired bankroll
        System.out.println("Enter Trials :");
        int trials = sc.nextInt();    // number of trials to perform
        int bets = 0;        // total number of bets made
        int wins = 0;        // total number of games won
        // repeat trials times
        for (int t = 0; t < trials; t++) {

            // do one gambler's ruin simulation
            int cash = stake;
            while (cash > 0 && cash < goal) {
                if (Math.random() < 0.5) cash++;     // win $1
                else                     cash--;     // lose $1
            }
            if (cash == goal) wins++;                // did gambler go achieve desired goal?
        }

        // print results
        System.out.println(wins + " wins of " + trials);
        System.out.println("Percent of games won = " + 100.0 * wins / trials);
        System.out.println("Avg # bets           = " + 1.0 * bets / trials);	
        sc.close();
       }
}
