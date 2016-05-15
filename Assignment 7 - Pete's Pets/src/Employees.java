import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * The Employees class will contain the methods that will help the Petes Pets application perform all its functions.
 * It will display the employees in order by there ID number, and calculate and display their weekly pay.   
 * @author Nabeel Hussain
 */
public class Employees implements EmployeesInterface
{
	double totalWeeklyPay;   // Declares variable to hold the total weekly pay for all the employees.
	int numManagers = 0;     // Declares variable to keep track of the number of managers added.
	int numClerks = 0;		 // Declares variable to keep track of the number of clerks added.
	int numVets = 0;		 // Declares variable to keep track of the number of veterinarians added.
	int numStylists = 0;	 // Declares variable to keep track of the number of stylist's added.
	
	Employee emp;  // Instance of the Employee class.
	
	ArrayList<Employee> empList = new ArrayList<>();  // ArrayList of type Employee to hold all the employees in the on Pete's Pets store. 
	
	//Creating an instance of the NumberFormat class, so I can format the number into currency, for the banking system. 
	NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
	
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
	public void addEmployee(int paycode, String fname, String lname, double first, int second, int empNum)
	{
		// If paycode is 1, then add the info for the manager into the ArrayList<Employee> empList
    	if(paycode == 1)
    	{
    		emp = new Manager(paycode, fname, lname, first, empNum);
    		empList.add(emp);
    		numManagers++;
    	}
    	// If paycode is 2, then add the info for the clerk into the ArrayList<Employee> empList
    	else if(paycode == 2)
    	{
    		emp = new Clerk(paycode, fname, lname, first, second, empNum);
    		empList.add(emp);
    		numClerks++;
    	}
    	// If paycode is 3, then add the info for the veterinarian into the ArrayList<Employee> empList
    	else if(paycode == 3)
    	{
    		emp = new Vet(paycode, fname, lname, first, empNum);
    		empList.add(emp); 
    		numVets++;
    	}
    	// If paycode is 4, then add the info for the stylist into the ArrayList<Employee> empList
    	else if(paycode == 4)
    	{
    		emp = new Stylist(paycode, fname, lname, first, second, empNum);
      		empList.add(emp);
    		numStylists++;
    	}
    	// If none of the above paycode numbers are passed in as a parameter, then display message saying that the file contains invalid data.   
    	else
    	{
    		JOptionPane.showMessageDialog(null, "File contains invalid paycode number");
    	}
	}
	
	
	/**
	 * Will calculate the total pay for employees at Pete's Pets for a week
	 * @return a double, the total pay
	 */
	public double calculateWeeklyPay()
	{
		totalWeeklyPay = 0;
		
		// A for loop to calculate the weekly pay for each employee in the Arraylist and sum up the total. 
		for (int i =0 ; i <empList.size(); i++)
		{
			totalWeeklyPay += empList.get(i).calculateWeeklyPay();
		}
		
		return totalWeeklyPay;
	}
	
	
	/**
	 * Will return the total number of managers entered so far
	 * @return an int, the current number of managers
	 */
	public int getNumManagers()
	{
		return numManagers;	
	}
	
	
	/**
	 * Will return the total number of Clerks entered so far
	 * @return an int, the current number of Clerks
	 */
	public int getNumClerks()
	{
		return numClerks;	
	}
	
	
	/**
	 * Will return the total number of Vets entered so far
	 * @return an int, the current number of Vets
	 */
	public int getNumVets()
	{
		return numVets;	
	}
	
	
	/**
	 * Will return the total number of Stylists entered so far
	 * @return an int, the current number of Stylists
	 */
	public int getNumStylists()
	{
		return numStylists;
	}
	
	
	/**
	 * Will reorder the list of employees according to employee ID, with the lowest ID employee first in the list
	 */
	public void sort()
	{
		// An Employee object which will hold the employee with the lowest ID number 
		Employee lowestEmpID;
		
		int minI;
		
		// Will loop through the list of employees and for each iteration, it will place the employee with the lowest ID in the first position of the ArrayList. 
		for(int i = 0; i < empList.size(); i++)
		{
			lowestEmpID = empList.get(i);
			minI = i;
			
			for(int j=i+1; j<empList.size(); j++)
			{
				// will use the compareTo() method to determine if the next employee in the list has a higher or lower ID number.
				// If it has a lower ID number than the current lowest employee ID, then assign it to the lowestEmpID variable.  
				if(empList.get(j).compareTo(lowestEmpID) < 0)
				{
					lowestEmpID = empList.get(j);
					minI = j;
				}
			}
			// Swap the employees, so the employee with the lowest ID is placed higher on the list. 
			Employee temp = empList.get(i);
			empList.set(i, lowestEmpID);
			empList.set(minI, temp);
		}	
	}
		
	/**
	 * It will generates a summary of the weeks' pay, in the following format:
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
	public String generateWeeklyReport()
	{
		
		String str = "";
		
		str += "WEEKLY PAY REPORT FOR Pete's Pets\n"
			    + "\nEMPLOYEE" + "          " + "WEEKLY PAY\n";
		
		for (int i = 0 ; i < empList.size(); i ++)
		{
			str += empList.get(i).toString() + "\n";
		}
		
		str += "\nTotal payroll: " + defaultFormat.format(calculateWeeklyPay()) + "\n"
				+ "Total number of Managers paid: " + numManagers + "\n"
				+ "Total number of Clerks paid: " + numClerks + "\n"
				+ "Total number of Vets paid: " + numVets + "\n"
				+ "Total number of Stylists paid: " + numStylists + "\n";
		
		return str;
	}

}
