import java.util.Stack;

import bridge.Utility;


class BalancedParentheses{
	public static void main(String[] args){
		Utility u = new Utility();
		String string = new String();
		System.out.println("Please Enter the Mathematical Expression for Checking: ");
		string = u.inputString();
	
		Stack stack = new Stack();
		//Pushing and popping while brackets occurs
		for(int i=0;i<string.length();i++){
			if(string.charAt(i) == '{'){
				stack.push('{');
			}
			if(string.charAt(i) == '('){
				stack.push('(');
			}
			if(string.charAt(i) == '['){
				stack.push('[');
			}
			if(string.charAt(i) == '}'){
				stack.pop();
			}
			if(string.charAt(i) == ')'){
				stack.pop();
			}
			if(string.charAt(i) == ']'){
				stack.pop();
			}
		}
		//Checking for the result	
		if(stack.empty())
			System.out.println("Expression is Balanced");
		else
			System.out.println("Expression is Not Balanced");
	}
}