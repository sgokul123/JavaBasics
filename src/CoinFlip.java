

public class CoinFlip {
	 
	  public static void main(String[] args) { 
	    int heads = 0;
	    int tails = 0;
	 
	    for(int x=0;x<100;x++){
	      if (Math.random() < 0.6) {
	        tails = tails +1;
	      } else {
	        heads = heads +1;
	      }
	    }
	 
	    System.out.println("Heads total: " + heads);
	    System.out.println("Tails total: " + tails);
	  }
	}