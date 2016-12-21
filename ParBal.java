import java.util.*;
class Stack
{
   private int maxSize;
   private char[] stackArray;
   private int top;
   
   Stack(int s) {
      maxSize = s;
      stackArray = new char[maxSize];
      top = -1;
   }
   public void push(char j) {
      stackArray[++top] = j;
   }
   public char pop() {
      return stackArray[top--];
   }
   public char peek() {
      return stackArray[top];
   }
   public boolean isEmpty() {
      return (top == -1);
   }
   public boolean isFull() {
      return (top == maxSize - 1);
   }
}
public class ParBal
{
 	public static void main(String args[])
{
	int size;
	String s1=new String();
	Scanner sc =new Scanner(System.in);
	s1=sc.next();
	size=s1.length();
	Stack st=new Stack(size);
	int i;
	for(i=0;i<size;i++)
	{
	if(!st.isFull()){
		if(s1.charAt(i)=='(' || s1.charAt(i)== '['||s1.charAt(i)=='{') 
			st.push(s1.charAt(i));
		else if(s1.charAt(i)==')' || s1.charAt(i)== ']'||s1.charAt(i)=='}')
			{
			if(!st.isEmpty()) st.pop();
		}

	
	}
	else{	
	
	}
	
	}
	if(st.isEmpty()){
	System.out.println("Expression is Balanced...");		
	}
else{
	System.out.println("Expression is not Balanced...");
	}
}
}
