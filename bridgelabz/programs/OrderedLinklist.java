
package com.bridgelabz.programs;

import com.bridgelabz.utility.Node;

public class OrderedLinklist
{
	Node head;
	Node tail;
	int length=0;
	public int size()
	{
		return length;
	}
	public boolean isEmpty()
    {
        return head==null&&tail==null;
    }
	public void add(int value)
	{
		Node temp=new Node(value);
		Node current=null;
		Node previous=null;
		temp.setValue(value);
		boolean ins = false;
		//if node is empty
		if(head==null)
		{
			head=temp;
			tail=temp;
			length++;
		}
		//node is not Null
	    else if (value <= head.getValue())
        {
            temp.setNext(head);
            head = temp;
        }
        else
        {
   		previous=head;
	    	current=head.getNext();
	        try
          	{            
			while(current != null)
	        	{	
				if (value>=previous.getValue() && value<=current.getValue())
                   		{
                   			previous.setNext(temp);
                   			temp.setNext(current);
                  			ins = true;
                   			break;
                   		}
                   		else
                   		{
                   			previous=current;
					current=current.getNext();
				}
               		}
          	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
            if (ins==false)
            {
                tail.setNext(temp);
				tail=temp;
            }

        }
	length++;		
    }
	//Search for the items in the list
	public boolean search(int search)
	{
		Node current;;
		current=head;
		boolean flag=false;
		while(current !=null)
		{
			//Search Value Matches the Value in the list return true 
			if(search==current.getValue())
			{
				flag= true; break;
			}			
			else current=current.getNext();
			
		}
		if(flag)
		return false;
		else return false;
	}
	public void showList()
	{
		Node temp=head;
		//if linked list is empty
		if(temp==null)
		System.out.println("Empty");
		else
		{
			while(temp!=null)//display linked list
			{
				System.out.print(temp.getValue()+"=>");			
				temp=temp.getNext();	
			}
				System.out.println();			
		}
	}
	//Remove the node if already exits in the list
	public void remove(int value)
	{

		Node previous=head;
		Node current=head;
		//if the node is empty
		if(current==null)
		{
			System.out.println("Their is Nothing to remove");
		}
		else
		{							
			while(value!=current.getValue())
			{
				previous=current;
				current=current.getNext();
			}
			if(current==head)
			{
				head=head.getNext();
				current.setNext(null);
				length--;
			}
			else 
			{
				previous.setNext(current.getNext());
				current.setNext(null);
				length--;			
			}
		}
	}
	//returning string of list
	public String listtoString()
	{
		Node current = head;
		String output = "";
		while(current != null)
		{
			output +=current.getValue()+" ";
			current = current.getNext();
		}
		return output;
	}			
}