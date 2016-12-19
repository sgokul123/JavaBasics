import bridge.Utility;


public class BankingOperation{
	Utility u = new Utility();
	long balance = 5000;
	protected   QueueNode front=null,rear=null,temp;
	int number = 0;
	long amount;
	//for adding node in queue	
	public void add(long amount2,String s1){
		QueueNode node = new QueueNode(amount2,s1,null);
		//System.out.println("hi");
		System.out.println();
		
		if(front ==null){
			front = node;
			rear = node;
			System.out.println("first");
		  }
		else if(rear!=null){
			temp=rear;
			temp.link=node;
			rear=temp.link;
			System.out.println("secound");
			
			}
		else{
			rear.setNode(node);
			rear = node;
		}
		
	}
	//for removing node from queue
	public void remove(){
		   if(front == null)
			{
			System.out.println("Queue is Empty");
			}
		   else if(front==rear){
			   front=rear=null;
	   	   }
		   else {
			   	temp=front;
			   	front = temp.link;
			  temp=null;
		   }
		   
		   }
	//depositing money
	public void deposit(int choice){
		System.out.print("Please Enter the amount you want to deposit: ");
		 amount = u.inputInteger();
		 this.add(amount,"Deposited");
			
		balance = balance + amount;
		System.out.println("Deposited Successfully");
		number++;
		//this.remove();
	}
	//withdrawing money
	public void withdraw(int choice){
		System.out.print("Please Enter the Amount want to withdraw: ");
		int amount = u.inputInteger();
		this.add(amount,"Withdrow");
		
		if(amount <= balance){
			balance = balance - amount;
		}
		else
		{
			System.out.println("Sorry Insufficient Balance");
		System.out.println("Bank is having low balance");
		
		}
		number++;
		//temp=front;
		//this.remove();
	}

	//balance
	public void getBalance(){
		System.out.println("Balance is         : "+balance+"   Rs");
		
		
	}
		public void display()
		{
			temp=front;
			while(temp.link!=null){
				System.out.println("-----> "+temp.data+"        :"+temp.s1);
				temp=temp.link;
			}
			
		}
	//finding total operations
	public int operations(){
		return number;
	}
//https://github.com/dhireshbhoir/Java-Basic/blob/master/MyQueue.java
}