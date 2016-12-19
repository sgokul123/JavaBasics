import java.util.Scanner;

import bridge.Utility;




class QNode{
	static int data=0;
	static QNode next=null;
	QNode(int val,QNode link){
		data=val;
		next=link;
	}
	public void setNode(QNode node) {
		
		
		
	}
	
}


class BankingOp 
{//extends QNode{
	Scanner sc=new Scanner(System.in);
	
	long balance = 5000;
	protected   QNode front=null,rear=null,temp;
	int number = 0;
	long amount;
	//for adding node in queue	
	public void add(int data){
		QNode node = new QNode(data,null);
		System.out.println("hi");
		if(front ==null){
			front = node;
			rear = node;
			System.out.println("Out");
		  }
		else if(rear!=null){

			temp=rear;
			temp.next=node;
			rear=temp.next;
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
			   	front = temp.next;
		   }
		   
		   }
	//depositing money
	public void deposit(int choice){
		this.add(choice);
		System.out.print("Please Enter the amount you want to deposit: ");
		 amount = sc.nextLong();
		balance = balance + amount;
			System.out.println("Deposited Successfully");
		number++;
		this.remove();
	}
	//withdrawing money
	public void withdraw(int choice){
		this.add(choice);
		System.out.print("Please Enter the Amount want to withdraw: ");
		long amount = sc.nextLong();
		if(amount <= balance){
			balance = balance - amount;
		}
		else
			System.out.println("Sorry Insufficient Balance");
		number++;temp=front;

		this.remove();
	}

	//balance
	public void getBalance(){
		System.out.println("Balance is: "+balance+" Rs");
		
		
	}
		public void display()
		{
			temp=front;
			while(temp.next==null){
				System.out.println("---> "+temp.data);
				temp=temp.next;
			}
			
		}
	//finding total operations
	public int operations(){
		return number;
	}

}
	// This class contain main methode.
public class BankQueue {
	public static void main(String[] args){
		Utility u = new Utility();
		BankingOp bo = new BankingOp();
		int choice;
		boolean check = true;
		while(check){
			System.out.println("\nPlease choose your option:\n1.Deposit\n2.Withdraw\n3.Balance Info \n4. remove \n 5. display\n 0. Exit");
			choice = u.inputInteger();

			switch(choice){
				case 1:{
					bo.deposit(choice);
					break;
				}
				case 2:{
					bo.withdraw(choice);
					break;
				}
				case 3:{
					bo.getBalance();
					break;
				}
				case 4:
				{
					bo.remove();
					break;
				}
				case 5:{
					bo.display();
					break;
				}
				case 0:
				{
					System.out.println("Exit");
					check = false;
					break;
				}
				default:{
					System.out.println("Entered Wrong Choice");
					break;
				}
			}//end of switch
		}//end of while
		
		System.out.println("\nTotal number of Deposits and Withdraws: "+bo.operations());
	}
}
