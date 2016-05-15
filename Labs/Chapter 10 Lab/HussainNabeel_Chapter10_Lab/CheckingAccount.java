/**
* This class will hold the methods that a checking account needs to perform its functions. It also inherits attributes from the BankAccount class. 
* @author Nabeel Hussain 
*/ 

public class CheckingAccount extends BankAccount {
	
	private static final double FEE = .15;   // Declares a static constant variable to hold the cost of clearing one check
	String accountNumber;    // Declares an instance variable to hold the account number of a customers checking account
	
	/**
	 * Constructor for the CheckingAccount class. It will take a name and an initial  balance amount as parameters.
	 * It should call the constructor for the superclass.
	 * @param name customers name
	 * @param amount starting account balance
	 */
	public CheckingAccount( String name, double amount)
	{
		super(name, amount);
		
		accountNumber = super.getAccountNumber() + "–10";	
	}
	
	/**
	 * Will override the withdraw method in the superclass. It will take the amount to withdraw, add it to the fee for
	 * check clearing, and call the withdraw method from the superclass. 
	 * @param amount the amount being withdrawn from account
	 * @return true if there was sufficient funds to complete the transaction, false otherwise
	 */
	@Override
	public boolean withdraw(double amount)
	{
		double amt;
		boolean completed = true;

		if (amount <= getBalance())
		{
			amt = amount + FEE;
			
			super.withdraw(amt);
		}
		else
		{
			completed = false;
		}
		return completed;
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
