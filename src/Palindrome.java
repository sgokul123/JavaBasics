import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import bridge.Utility;



public class Palindrome {
public static void main(String[] args) {
Utility util = new Utility();
Stack stack = new Stack();
Queue queue = new LinkedList();
System.out.println("Enter the String");
String data = util.inputString();
int size = data.length();

for(int i = 0; i < size; i++) {
stack.push(data.charAt(i));
queue.add(data.charAt(i));
}
if(stack.push("").equals(queue.remove()))
{
System.out.println("String is  a polindrome:"+data);
}else
System.out.println("String is not a polindrome:"+data);

}
}