public class Node
{
	private int value;
	private Node next;
	//Function to set the value
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