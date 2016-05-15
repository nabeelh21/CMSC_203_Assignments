/**
* This class will help to keep track of a customer’s account balance, and perform banking transactions, such as deposit and withdrawal.
* @author Nabeel Hussain 
*/ 
public class BankAccount {
	
	private double balance;
	private Customer name;
	
	/**
	 * A constructor for the BankAccount. It will create a new account for a user by creating a customer object,
	 * and setting the starting balance to $0.
	 * @param firstName customers first name
	 * @param lastName customers last name
	 */
	public BankAccount(String firstName, String lastName)
	{
		// Creates new customer object
		name = new Customer(firstName, lastName);
		
		balance = 0.0;		
	}
	
	/**
	 * Constructor for the BankAccount. Sets the starting balance to $0. 
	 * @param n customer object
	 */
	public BankAccount(Customer n)
	{
		balance = 0.0;
	}
	
	/**
	 * Will add the amount of money the user wants to deposit, into their bank account balance. 
	 * @param amount the amount to deposit into the account balance
	 */
	public void deposit(double amount)
	{
		balance += amount;
	}
	
	/**
	 * Will subtract the amount of money the user wants to withdraw, from their bank account balance.
	 * 
	 * @param amount the amount to withdraw from the account balance
	 */
	public void withdraw( double amount)
	{
		balance -= amount;
	}
	
	/**
	 * Returns the customer's account balance. 
	 * @return the balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * Returns the customer’s full name, by calling the toString method of the customer class.  
	 *  @return customers full name
	 */
	public String getCustomer()
	{
		return name.toString();
	}
	
	/**
	 * Returns the customer’s full name and their account balance in String representation. 
	 *  @return the customer name followed by the account balance
	 */
	public String toString()
	{	
		return getCustomer() + ": " +  balance;
	}
}