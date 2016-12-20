import java.util.Scanner;
import java.lang.Object;
/*
 * Disc :
 * Auth :Sonawane Gokul
 * Date :14/12/2016
 */

public class ThreeSum {

    private ThreeSum() { }

      public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    } 

     public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    } 
     public static void main(String[] args)  { 
        int n;
        System.out.println("Number of element:");
            	Scanner sc=new Scanner(System.in);
            	n=sc.nextInt();
            	int[] a =new int[n];
    	for(int i=0;i<n;i++)
    		{
    		a[i]=sc.nextInt();  // In in = new In(args[0]);
    	     
    		}
        //StopWatch timer = new StopWatch();
        int count = count(a);
        //System.out.println("elapsed time = " + timer.elapsedTime());
        System.out.println(count);
    } 
} 