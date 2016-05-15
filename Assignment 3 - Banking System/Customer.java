/**
 * This class will hold the customers first and last name, who's bank account the transactions will be performed on.
 * @author Nabeel Hussain
 */
public class Customer
{
	
	private String firstName;    // Declares variable to hold customers first name.
	private String lastName;     // Declares variable to hold customers last name
	private String fullName;     // Declares variable to hold customers full name
	
	
	/**
	 * Constructor for the Customer class. It will store the first and last name of the customer.
	 *  @param first first name
	 *  @param last last name
	 */
	public Customer(String first, String last)
	{
		firstName = first;
		lastName = last;
	}
	
	/**
	 * Will return the customers first name. 
	 *  @return  the first name
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * Will return the customers last name.
	 *  @return the last name
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * Will return the customers full name in string representation. 
	 *  @return a string with the first name followed by a space followed by the last name
	 */
	public String toString()
	{
		fullName =  firstName + " " + lastName;
		
		return fullName;		
	}
	
}