package com.bridgelabz.utility;



public class Node
{
	public int value;
	public Node next;
	public int data;
	public  Node left;
	public Node right;	
	//Function to set the value
	public Node(int data){
		 this.data = data;
		 this.value=data;
			left = null;
			right = null;
			next=null;
			}
	public void setValue(int value)
	{
		this.value=value;
	}
	//Function to get the value
	public int getValue()
	{
		return value;
	}
	//Function to set the Next of the value
	public void setNext(Node next)
	{
		this.next=next;
	}
	//Function to get the Next  value
	public Node getNext()
	{
		return next;
	}
}