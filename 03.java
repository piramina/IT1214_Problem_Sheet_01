import java.util.*;

class BankAccount{
	private int accountNumber;
	private String accountHolder;
	private double balance;
	
	BankAccount(int accountNumber,String accountHolder,double balance){
		this.accountNumber=accountNumber;
		this.accountHolder=accountHolder;
		this.balance=balance;
	}
	
	int getAccountNumber(){
		return accountNumber;
	}
	void setAccountNumber(int accountNumber){
		this.accountNumber=accountNumber;
	}
	
	String getAccountHolder(){
		return accountHolder;
	}
	void setAccountHolder(String accountHolder){
		this.accountHolder=accountHolder;
	}
	
	double getBalance(){
		return balance;
	}
	void setBalance(double balance){
		this.balance=balance;
	}
	
	void withdraw(double amount){
		if(amount>balance){
			throw new IllegalArgumentException("Insufficient balance");
		}
		balance-=amount;
	}
}
	
	class Bank{
		BankAccount[] accounts=new BankAccount[10];
		int count=0;
		
		void addBankAccount(BankAccount b){
			if(count<accounts.length){
				accounts[count++]=b;
			}else{
				System.out.println("Bank is dull.Cannot add more accounts");
			}
		}
		void withdraw(int accountNumber,double amount){
			boolean found=false;
			for(int i=0; i<count; i++){
				if(accounts[i].getAccountNumber()==accountNumber){
					found=true;
					try{
						accounts[i].withdraw(amount);
						System.out.println("Withdrawl of "+amount+" successful from account " + accountNumber);
					}catch(IllegalArgumentException e){
						System.out.println("Error: " + e.getMessage());
					}
					break;
				}
			}
			if(!found){
				System.out.println("Account number " + accountNumber + " not found.");
			}
		}
		
		void displayAccounts(){
			for(int i=0; i<count; i++){
				System.out.println("Account Number "+accounts[i].getAccountNumber());
				System.out.println("Account Holder "+accounts[i].getAccountHolder());
				System.out.println("Balance is "+accounts[i].getBalance());
			}
		}
	}


class Main{
	public static void main(String[] args){
		Bank ba=new Bank();
		
		ba.addBankAccount(new BankAccount(1001,"Alice",5000.00));
		ba.addBankAccount(new BankAccount(1002,"Bob",3000.00));
		
		ba.withdraw(1001,6000.00);
		ba.withdraw(1002,1000.00);
		
		ba.displayAccounts();

	}
}