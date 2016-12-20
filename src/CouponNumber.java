
/*
 * Disc : Write a program for generate random numbers
 * Auth :Sonawane Gokul
 * Date :17/12/2016
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

import bridge.Utility;
public class CouponNumber {
 
    // return a random coupon between 0 and n-1
    public static int getCoupon(int n) {
        return (int) (Math.random() * n);
    }

// return number of cards you collect before obtaining one of each of the n types
    public static int collect(int n) {
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
        for (int i=0; i<distinct; i++) {
            System.out.println(list.get(i));
       }
        return count;
      }
	

 // test client
    public static void main(String[] args) {
	Utility util = new Utility();
	System .out.println("Enter the number");
        int n = util.inputInteger();
        int count = collect(n);
        System.out.println("Total random number "+count);
	
    } 

}