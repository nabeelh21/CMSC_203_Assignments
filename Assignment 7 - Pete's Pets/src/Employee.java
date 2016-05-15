/**
* This abstract Employee class holds the general information about an employee at Pete's Pet.
* @author Nabeel Hussain
*/
public abstract class Employee implements Comparable<Employee>{
	
	
	private String firstName;   // Declares variable to hold the employees first name
	private String lastName;    // Declares variable to hold the employees last name
	private int idNumber;       // Declares variable to hold the employees id number
	
	/**
	 * The Employee constructor, which will set the employees first name, last name, and ID number.
	 * @param fName the employees first name
	 * @param lName the employees last name
	 * @param id the employees ID number
	 */
	public Employee(String fName, String lName, int id)
	{
		setFirstName(fName);
		setLastName(lName);
		setIdNumber(id);
	}
	
	/** The calculateWeeklyPay method is abstract. It must be overridden in the subclass.
	 *  @return The weekly pay for the employee.
	 */
	public abstract double calculateWeeklyPay();
	
	
	/** The compareTo method, which will compare the employees Id's based on their numeric value
	 *  @param other the Employee object that is being compared
	 */
	public int compareTo(Employee other)
	{
		// If the previous number is less then the next number that is being compared, then return -1
		if(idNumber < other.getIdNumber())
		{
			return -1;
		}
		// If the previous number is equal to the next number being compared, then return 0
		else if(idNumber == other.getIdNumber())
		{
			return 0;
		}
		// return a 1 in all other scenarios, which will signify that the previous number is greater than the next number that is being compared. 
		else
		{
			return 1;
		}
	}
	
	
	/**
	 * The toString method which will return a String containing the employees data.
	 * @return A reference to a String.
	*/
	public String toString()
	{
		String str;
		
		str = idNumber + " " + firstName + " " + lastName;
		
		return str;
	}
	
	
	/**
	 * Will return the first name of the employee
	 * @return the employees first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Will take the String parameter passed in, and assign that as the first name of the employee
	 * @param firstName the employees first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	/**
	 * Will return the last name of the employee
	 * @return the employees last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Will take the String parameter passed in, and assign that as the first name of the employee
	 * @param lastName the employees last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
		
	/**
	 * Will return the ID number of the employee
	 * @return the employees ID number
	 */
	public int getIdNumber() {
		return idNumber;
	}
	
	/**
	 * Will take the int parameter passed in, and assign that as ID number of the employee
	 * @param idNumber the employees ID number
	 */
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}	
}
