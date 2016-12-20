
import java.util.*;
/*
 * Disc :User Input and Replace String Template “Hello <<UserName>>, How are you?"
 * Auth :Sonawane Gokul
 * DAte :12/12/2016
 */
public class StringTemp {
public static void main(String args[])
{
	String UserName; 
	Scanner il = new Scanner(System.in);
	System.out.println("Please Enter your Name : ");
   UserName =il.nextLine();
    System.out.println("Hello "+UserName+", How are you?");

}
}
