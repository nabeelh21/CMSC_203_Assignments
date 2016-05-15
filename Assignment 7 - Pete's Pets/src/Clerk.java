import java.text.NumberFormat;

/**
* An Employee subclass that holds information about a clerk at Pete's Pet.
* @author Nabeel Hussain
*/
public class Clerk extends Employee {
	
	private double hourlyPay;    // Declares variable to hold a clerks hourly pay
	private int hoursWorked;     // Declares variable to hold a clerks hours worked
	private int payCode;         // Declares variable to hold the paycode for a clerk
	private double weeklyPay;    // Declares variable to hold a clerks weekly pay
	
	// Creating an instance of the NumberFormat class, so I can display the clerks weekly pay in currency format.
	NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
	
	
	/**
	 * The Clerk class constructor
	 * @param code the clerks paycode
	 * @param firstName the clerks first name
	 * @param lastName the clerks last name
	 * @param pay the clerks hourly pay rate
	 * @param hours the clerks number of hours worked
	 * @param id the clerks ID number
	 */
	public Clerk(int code, String firstName, String lastName, double pay, int hours, int id )
	
	{
		super(firstName, lastName, id);
		hourlyPay = pay;
		hoursWorked = hours;
		payCode = code;
	}

	/** Overrides the calculateWeeklyPay method in the superclass.
	 *  They receive a fixed hourly wage for up to the first 40 hours they work
	 *  and "time-and-a-half," i.e., 1.5 times their hourly wage, for overtime hours worked 
	 *  @return The weekly pay for the clerk.
	 */
	@Override
	public double calculateWeeklyPay() {
		
		if(hoursWorked <= 40)
		{
			weeklyPay = hoursWorked * hourlyPay;
		}
		else
		{
			weeklyPay = (hoursWorked - 40) * (1.5 * hourlyPay) + (40 * hourlyPay);
		}		
		return weeklyPay;
	}

	/** Overrides the compareTo method in the superclass, which will compare the employee Id's based on their numeric value
	 *  @param x the Employee object that is being compared
	 */
	@Override
	public int compareTo(Employee x) {
		
		if(super.getIdNumber() < x.getIdNumber())
		{
			return -1;
		}
		else if(super.getIdNumber() == x.getIdNumber())
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	
	/**
	 * It will override the getFirstName method in the superclass Employee.
	 * @return the first name of the clerk, which is stored in the superclass Employee.   
	 */
	@Override
	public String getFirstName()
	{
		return super.getFirstName();
	}
	
	/**
	 * It will override the setFirstName method in the superclass Employee. It will take the  first name of each clerk,
	 * and call the setFirstName method from the superclass.
	 * @param firstName the clerk's first name 
	 */
	@Override
	public void setFirstName(String firstName)
	{
		super.setFirstName(firstName);
	}

	
	/**
	 * It will override the getLastName method in the superclass Employee.
	 * @return the last name of the clerk, which is stored in the superclass Employee.   
	 */
	@Override
	public String getLastName()
	{
		return super.getLastName();
	}
	
	/**
	 * It will override the setFirstName method in the superclass Employee. It will take the  first name of each clerk,
	 * and call the setFirstName method from the superclass.
	 * @param lastName the clerk's last name 
	 */
	@Override
	public void setLastName(String lastName)
	{
		super.setLastName(lastName);
	}
	
	
	/**
	 * It will override the getIdNumber method in the superclass Employee.
	 * @return the ID number of the employee, which is stored in the superclass Employee.   
	 */
	@Override
	public int getIdNumber()
	{
		return super.getIdNumber();
	}
	
	/**
	 * It will override the setIdNUmber method in the superclass Employee. It will take the ID number of each employee,
	 * and call the setIdNumber method from the superclass.
	 * @param idNumber the clerk's ID number 
	 */
	@Override
	public void setIdNumber(int idNumber)
	{
		super.setIdNumber(idNumber);
	}
	
	
	/**
	 * It will override the toString method in the superclass Employee
	 * @return a string representation of the clerk employees info  
	 */
	public String toString()
	{
		String str;
		
		str = super.toString() + " " + defaultFormat.format(calculateWeeklyPay());
		
		return str;
	}
}


