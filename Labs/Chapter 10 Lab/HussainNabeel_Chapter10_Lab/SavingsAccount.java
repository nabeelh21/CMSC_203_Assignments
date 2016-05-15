/**
* This class will hold the methods that a savings account needs to perform its functions. It also inherits attributes from the BankAccount class. 
* @author Nabeel Hussain 
*/ 

public class SavingsAccount extends BankAccount {
	
	private double rate = .025;     // Declares and initializes an instance variable to hold the annual interest rate of the savings account. 
	private int savingsNumber = 0;  // Declares an instance variable to hold the number of savings accounts for a customer. Initializes it to 0.
	private String accountNumber;   // Declares an instance variable to hold the account number of a customers savings account
	
	/**
	 * Constructor for the SavingsAccount class. It will take a name and an initial  balance amount as parameters.
	 * It should call the constructor for the superclass.
	 * @param name customers name
	 * @param balance starting balance amount for the account
	 */
	public SavingsAccount(String name, double balance)
	{
		super(name, balance);
		
		accountNumber = super.getAccountNumber() + "–" + savingsNumber;	
	}
	
	/**
	 * Copy constructor for the SavingsAccount class that creates another savings account for the same person.
	 * It should take the original savings account and an initial balance as parameters. 
	 * It should call the copy constructor for the superclass, and assign savingsNumber to be one more
	 * than the savingsNumber of the original savings account.
	 * @param account the original savings account of the customer
	 * @param balance starting balance amount for the account
	 */
	public SavingsAccount( SavingsAccount account, double balance)
	{
		super(account, balance);
		
		savingsNumber = account.savingsNumber + 1;
		
		accountNumber = super.getAccountNumber() + "–" + savingsNumber;
	}
	
	/**
	 * Will calculate one months interest earned on the balance and deposit it into the account.  
	 */
	public void postInterest(){
		
		double interest;
		
		interest = (rate/12) * getBalance();
		
		super.deposit(interest);
	}
	
	/**
	 * Will override the getAccountNumber method in the superclass. 
	 * @return the account number 
	 */
	@Override
	public String getAccountNumber()
	{
		return accountNumber;
	}	
}


