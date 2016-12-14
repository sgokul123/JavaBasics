/*
 * Disc :Find  a Armstrong Number
 * Auth :Sonawane Gokul
 * DAte :14/12/2016
 */
import java.util.Scanner;
public class ArmstrongNo{

    
    public static void main(String args[]) {
       System.out.println("Please enter a 3 digit number to find if its an Armstrong number:");
        int number = new Scanner(System.in).nextInt();
        if(isArmStrong(number)){
            System.out.println("Number : " + number + " is an Armstrong number");
        }else{
            System.out.println("Number : " + number + " is not an Armstrong number");
        }

    
    }
    private static boolean isArmStrong(int number) {
        int result = 0;
        int orig = number;
        while(number != 0){
            int remainder = number%10;
            result = result + remainder*remainder*remainder;
            number = number/10;
        }
        //number is Armstrong return true
        if(orig == result){
            return true;
        }
      
        return false;
    } 
  
}
