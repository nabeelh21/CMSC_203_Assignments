import java.text.NumberFormat;

/**
* An Employee subclass that holds information about a veterinarian at Pete's Pet.
* @author Nabeel Hussain
*/
public class Vet extends Employee {
	
	private double numVaccines;            // Declares variable to hold the number of vaccinations administered by the vet 
	private int payCode;                   // Declares variable to hold the paycode for a vet	
	private double weeklyPay;              // Declares variable to hold the weekly pay for a vet
	private final double VACC_PAY = 3.75;  // Declares the amount a vet makes for each vaccine they administer
	
	
	// Creating an instance of the NumberFormat class, so I can display the vets weekly pay in currency format. 
	NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
	
	/**
	 * The Vet class constructor
	 * @param code the vet's paycode
	 * @param firstName the vet's first name
	 * @param lastName the vet's last name
	 * @param numVacc the vet's number of vaccinations administered by the vet
	 * @param id the vet's ID number
	 */
	public Vet(int code, String firstName, String lastName, double numVacc, int id )
	
	{
		super(firstName, lastName, id);
		numVaccines = numVacc;	
		payCode = code;
	}

	/** Overrides the calculateWeeklyPay method in the superclass.
	 *  They receive $800 plus $3.75 for each vaccine they administer
	 *  @return The weekly pay for the vet.
	 */
	@Override
	public double calculateWeeklyPay() {
		
		weeklyPay = 800 + (VACC_PAY * numVaccines);
		
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
	 * @return the first name of the vet, which is stored in the superclass Employee.   
	 */
	@Override
	public String getFirstName()
	{
		return super.getFirstName();
	}
	
	/**
	 * It will override the setFirstName method in the superclass Employee. It will take the  first name of each vet,
	 * and call the setFirstName method from the superclass.
	 * @param firstName the vet's first name 
	 */
	@Override
	public void setFirstName(String firstName)
	{
		super.setFirstName(firstName);
	}

	
	/**
	 * It will override the getLastName method in the superclass Employee.
	 * @return the last name of the vet, which is stored in the superclass Employee.   
	 */
	@Override
	public String getLastName()
	{
		return super.getLastName();
	}
	
	/**
	 * It will override the setFirstName method in the superclass Employee. It will take the  first name of each vet,
	 * and call the setFirstName method from the superclass.
	 * @param lastName the vet's last name 
	 */
	@Override
	public void setLastName(String lastName)
	{
		super.setLastName(lastName);
	}
	
	
	/**
	 * It will override the getIdNumber method in the superclass Employee.
	 * @return the ID number of the vet, which is stored in the superclass Employee.   
	 */
	@Override
	public int getIdNumber()
	{
		return super.getIdNumber();
	}
	
	/**
	 * It will override the setIdNUmber method in the superclass Employee. It will take the ID number of each vet,
	 * and call the setIdNumber method from the superclass.
	 * @param idNumber the vet's ID number 
	 */
	@Override
	public void setIdNumber(int idNumber)
	{
		super.setIdNumber(idNumber);
	}
	
	
	/**
	 * It will override the toString method in the superclass Employee
	 * @return a string representation of the Vet employees info  
	 */
	public String toString()
	{
		String str;
		
		str = super.toString() + " " + defaultFormat.format(calculateWeeklyPay());
		
		return str;
	}
}


