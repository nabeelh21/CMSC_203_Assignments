import java.text.NumberFormat;

/**
* An Employee subclass that holds information about a stylist at Pete's Pet.
* @author Nabeel Hussain
*/
public class Stylist extends Employee {
	
	private double payRate;       // Declares variable to hold a stylist's pay rate
	private int numAppointments;  // Declares variable to hold a stylist's number of appointments for the week
	private int payCode;          // Declares variable to hold the paycode for a stylist
	private double weeklyPay;     // Declares a variable to hold the weekly pay for the stylist
	
	// Creating an instance of the NumberFormat class, so I can display the stylist's weekly pay in currency format.  
	NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
	
	
	/**
	 * The Stylist class constructor
	 * @param code the stylist's paycode
	 * @param firstName the stylist's first name
	 * @param lastName the stylist's last name
	 * @param pay the stylist's pay rate
	 * @param numAppt the stylist's number of appointment for the week
	 * @param id the vet's ID number
	 */
	public Stylist(int code, String firstName, String lastName, double pay, int numAppt, int id )
	
	{
		super(firstName, lastName, id);
		payRate = pay;
		numAppointments = numAppt; 
		payCode = code;
	}

	/** Overrides the calculateWeeklyPay method in the superclass.
	 *  They receive a fixed amount of money per appointment
	 *  @return The weekly pay for the stylist.
	 */
	@Override
	public double calculateWeeklyPay() {
		
		weeklyPay = payRate * numAppointments;
		
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
	 * @return the first name of the stylist, which is stored in the superclass Employee.   
	 */
	@Override
	public String getFirstName()
	{
		return super.getFirstName();
	}
	
	/**
	 * It will override the setFirstName method in the superclass Employee. It will take the  first name of each stylist,
	 * and call the setFirstName method from the superclass.
	 * @param firstName the stylist's first name 
	 */
	@Override
	public void setFirstName(String firstName)
	{
		super.setFirstName(firstName);
	}

	
	/**
	 * It will override the getLastName method in the superclass Employee.
	 * @return the last name of the stylist, which is stored in the superclass Employee.   
	 */
	@Override
	public String getLastName()
	{
		return super.getLastName();
	}
	
	/**
	 * It will override the setFirstName method in the superclass Employee. It will take the  first name of each stylist,
	 * and call the setFirstName method from the superclass.
	 * @param lastName the stylist's last name 
	 */
	@Override
	public void setLastName(String lastName)
	{
		super.setLastName(lastName);
	}
	
	
	/**
	 * It will override the getIdNumber method in the superclass Employee.
	 * @return the ID number of the stylist, which is stored in the superclass Employee.   
	 */
	@Override
	public int getIdNumber()
	{
		return super.getIdNumber();
	}
	
	/**
	 * It will override the setIdNUmber method in the superclass Employee. It will take the ID number of each stylist,
	 * and call the setIdNumber method from the superclass.
	 * @param idNumber the stylist's ID number 
	 */
	@Override
	public void setIdNumber(int idNumber)
	{
		super.setIdNumber(idNumber);
	}
	
	
	/**
	 * It will override the toString method in the superclass Employee
	 * @return a string representation of the Stylist employees info  
	 */
	public String toString()
	{
		String str;
		
		str = super.toString() + " " + defaultFormat.format(calculateWeeklyPay());
		
		return str;
	}
}


