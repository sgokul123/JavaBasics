import java.util.*;
/*
 * Disc :Write a Program for occurance of char count
 * Auth :Sonawane Gokul
 * Date :12/12/2016
 */
public class countchar {


public static void main(String args[]){
int len;
int i=0;
//char sl[100];
String sl=new String();
Scanner sc=new Scanner(System.in);
System.out.println("Enter the String :");
sl=sc.next();
len=sl.length();
System.out.println(len);
int[] arr=new int[200];

try{
	
	for(int h=0;h<30;h++){
		arr[h]=0;
	}
	
while(i<len){
	char c=sl.charAt(i);
	arr[c-'a']=arr[c-'a']+1;
	i=i+1;;
}
for(int j=0;j<30;j++){
	if(arr[j]!=0)
	System.out.print("      =>"+(char)(j+'a')+"->"+arr[j]);
	}
}catch(Exception e){
	System.out.println(e);
}
}
}

