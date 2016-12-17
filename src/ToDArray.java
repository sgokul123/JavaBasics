import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;
/*
 * Diasc write a program to create 2 dimensional array in memory to read in M rows and N cols 
 * Auth : Sonawane Gokul
 * Date :14/12/2016
 */
public class ToDArray {

	public static void main(String args[]){
	try{
		int m,n;
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter The M -Rows N - Coll's");
		m=sc.nextInt();
		n=sc.nextInt();
		int array[][]=new int[m][n];
		System.out.println("Please Enter Array Element :");
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				array[i][j]=sc.nextInt();
			}
		} 
		OutputStream o=null;
		System.out.println(array);
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.println(array[i][j]);
						
			}
		}
		OutputStreamWriter os=new OutputStreamWriter(o);
	//m	System.out.println(os);
	sc.close();
	}catch(Exception e){
	  	System.out.print(""+e);
	}
	
	}
}
