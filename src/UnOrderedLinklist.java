
//For Simple Methods for Node Operation
import java.util.Scanner;
class UnOrderedLinklist
{
	Node1 head;
	Node1 tail;
	int length=0;
	//returns the number of elements in this list.
	public int size()
	{
		return length;
	}
	//check whether list is empty or not 
	public boolean isEmpty()
    {
        return head==null&&tail==null;
    }
	//add the String in the linklist
	public void add(String value)
	{
		Node1 temp=new Node1();
		temp.setValue(value);
		//if node is empty
		if(head==null)
		{
			head=temp;
			tail=temp;
			length++;
		}
		//node is not Null
		else
		{
		tail.setNext(temp);
		length++;		
		}	
		tail=temp;

	}
	//Search for the items in the list
	public boolean search(String search)
	{
		Node1 current=new Node1();
		current=head;
		while(current !=null)
		{
			//Search Value Matches the Value in the list return true 
			if(search.equals(current.getValue()))
			{
				return true;
				
			}			
			current=current.getNext();
		}
		return false;
	}
	public void showList()
	{
		Node1 temp=head;
		//if linked list is empty
		if(temp==null)
		System.out.println("List is null");
		else
		{
			while(temp!=null)//display linked list
			{
				System.out.print(temp.getValue()+"=>");			
				temp=temp.getNext();	
			}			
		}
		System.out.println();
	}
	//Remove the node if already exits in the list
	public void remove(String value)
	{
		Node1 n=new Node1();
		Node1 previous=head;
		Node1 current=head;
		//if the node is empty
		if(current==null)
		{
			System.out.println("Their is Nothing to remove");
		}
		else
		{							
			while(value.compareTo(current.getValue())!=0)
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
	public String listtoString()
	{
		Node1 current = head;
		String output = "";
		while(current != null)
		{
			output +=current.getValue().toString()+" ";
			current = current.getNext();
		}
		return output;
	}			
}