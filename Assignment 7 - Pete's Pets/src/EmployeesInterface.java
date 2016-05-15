
/**
 * EmployeesInterface specifies several key methods of Employees
 * @author ralexander
 */
public interface EmployeesInterface {
	
	/**
	 * addEmployee adds a worker with the specified elements 
	 * @param paycode 1-Manager, 2-Clerk, 3-Vet, 4-Stylist
	 * @param fname first name, a String
	 * @param lname last name, a String
	 * @param first, based on the paycode of the employee. If the 
	 * paycode is 1-first holds the salary, if 2-hourly rate, if 3-number of Vaccines, 
	 * if 4-pay per jobs
	 * @param second, based on the paycode of the employee.  If the 
	 * paycode is 1- this parameter is not needed so enter a 0, if 2-number of hours, 
	 * if 3-not needed (enter a 0), if 4-number of jobs
	 * @param empNum the employee ID number
	 */
	public void addEmployee(int paycode, String fname, String lname, double first, int second, int empNum);
	
	
	/**
	 * calculates the total pay for employees at Pete's Pets for a week
	 * @return a double, the total pay
	 */
	public double calculateWeeklyPay();
	
	
	/**
	 * gets the total number of managers entered so far
	 * @return an int, the current number of managers
	 */
	public int getNumManagers();
	
	
	/**
	 * gets the total number of Clerks entered so far
	 * @return an int, the current number of Clerks
	 */
	public int getNumClerks();
	
	
	/**
	 * gets the total number of Vets entered so far
	 * @return an int, the current number of Vets
	 */
	public int getNumVets();
	
	
	/**
	 * gets the total number of Stylists entered so far
	 * @return an int, the current number of Stylists
	 */
	public int getNumStylists();
	
	
	/**
	 * reorders the list of employees according to employee ID, with lowest ID first
	 */
	public void sort();
	
	
	/**
	 * generates a summary of the weeks' pay, in the following format:
	 * 
		WEEKLY PAY REPORT FOR Pete's Pets 

		EMPLOYEE             WEEKLY PAY
		11111 Eric Hall   $1,200.00
		22222 Patrick Brown   $687.50
		33333 Katie Bell   $1,006.25
		44444 Paul Johnson   $656.25
		55555 Iam Squirley   $837.50

		Total payroll: $4,387.50
		Total number of Managers paid:  1
		Total number of Clerks paid:  1
		Total number of Vets paid:  2
		Total number of Stylists paid:   1
	 * @return a String containing the report text
	 */
	public String generateWeeklyReport();
}
