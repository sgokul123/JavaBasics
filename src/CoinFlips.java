
/*
 * Disc : Flip Coin and print percentage of Heads and Tails
 * Auth :Sonawane Gokul
 * Date :13/13/2016
 */
public class CoinFlips {
	 
	  public static void main(String[] args) { 
	    int heads = 0;
	    int tails = 0;
	    int  perc;
	    for(int x=0;x<130;x++){
	      if (Math.random() < 0.5) {
	        tails = tails +1;
	      } else {
	        heads = heads +1;
	      }
	    }
	    perc=(heads/130);
	    System.out.println("Heads total: " + heads);
	    System.out.println("Tails total: " + tails);
	    System.out.println("Percentage of Head vs Tails: ");
		  }
	}