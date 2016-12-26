package com.bridgelabz.programs;

public class Stack
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