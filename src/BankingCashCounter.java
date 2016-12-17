
public class BankingCashCounter{
	public static void main(String[] args){
		Utility u = new Utility();
		BankingOperation bo = new BankingOperation();
		int choice;
		boolean check = true;
		while(check){
			System.out.println("\nPlease choose your option:\n1.Deposit\n2.Withdraw\n3.Balance Info\n4.Exit");
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
				case 4:{
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
