import java.text.NumberFormat;

/**
* An Employee subclass that holds information about a manager at Pete's Pet.
* @author Nabeel Hussain
*/
public class Manager extends Employee {
	
	private double mgrSalary;   // Declares variable to hold a managers weekly salary
	private int payCode;        // Declares variable to hold the paycode number for a manager. 
	private double weeklyPay;   // Declares variable to hold a managers weekly pay
	
	// Creating an instance of the NumberFormat class, so I can display the managers weekly pay in currency format.
	NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
	
	
	/**
	 * The Manager class constructor 
	 * @param code the managers paycode
	 * @param firstName the managers first name
	 * @param lastName the managers last name
	 * @param salary the mansgers weekly salary
	 * @param id the managers ID number
	 */
	public Manager(int code, String firstName, String lastName, double salary, int id )
	
	{
		super(firstName, lastName, id);
		mgrSalary = salary;	
		payCode = code;
	}

	
	/** Overrides the calculateWeeklyPay method in the superclass. 
	 *  @return The weekly pay for the manager.
	 */
	@Override
	public double calculateWeeklyPay() {
		
		weeklyPay = mgrSalary;
		
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
	 * @return the first name of the manager, which is stored in the superclass Employee.   
	 */
	@Override
	public String getFirstName()
	{
		return super.getFirstName();
	}
	
	/**
	 * It will override the setFirstName method in the superclass Employee. It will take the  first name of each manager,
	 * and call the setFirstName method from the superclass.
	 * @param firstName the managers first name 
	 */
	@Override
	public void setFirstName(String firstName)
	{
		super.setFirstName(firstName);
	}

	
	/**
	 * It will override the getLastName method in the superclass Employee.
	 * @return the last name of the manager, which is stored in the superclass Employee.   
	 */
	@Override
	public String getLastName()
	{
		return super.getLastName();
	}
	
	/**
	 * It will override the setFirstName method in the superclass Employee. It will take the  first name of each manager,
	 * and call the setFirstName method from the superclass.
	 * @param lastName the managers last name
	 */
	@Override
	public void setLastName(String lastName)
	{
		super.setLastName(lastName);
	}
	
	
	/**
	 * It will override the getIdNumber method in the superclass Employee.
	 * @return the ID number of the manager, which is stored in the superclass Employee.   
	 */
	@Override
	public int getIdNumber()
	{
		return super.getIdNumber();
	}
	
	/**
	 * It will override the setIdNUmber method in the superclass Employee. It will take the ID number of each manager,
	 * and call the setIdNumber method from the superclass.
	 * @param idNumber the managers id number
	 */
	@Override
	public void setIdNumber(int idNumber)
	{
		super.setIdNumber(idNumber);
	}
	
	
	/**
	 * It will override the toString method in the superclass Employee
	 * @return a string representation of the manager employees info  
	 */
	public String toString()
	{
		String str;
		
		str = super.toString() + " " + defaultFormat.format(calculateWeeklyPay());
		
		return str;
	}
}


