import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.stage.FileChooser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for the Employees class
 */
public class EmployeesTest {

	private String fname;
	private String lname;
	private Employees employees;
	// STUDENT - This is the object you will use for the STUDENT test
	private Employees employeesSTUDENT;

	@Before
	public void setUp() throws Exception {
		//add a list of employees 
		employees = new Employees(); //ArrayList<Employee>();
		employees.addEmployee(2, "Bubba", "Jones", 10, 40, 2);
		employees.addEmployee(4, "Bill", "Williams", 50, 10, 4);
		employees.addEmployee(4, "Mary", "Mary", 40, 10, 5);
		employees.addEmployee(1, "Joe", "Smith", 1000, 0, 1);
		employees.addEmployee(3, "SueEllen", "Wilson", 10, 0, 6);
		employees.addEmployee(2, "Cindy", "Jones", 10, 45, 3);
		
		//STUDENT - add employees to your employeesSTUDENT object
		//they must be different than the employees above
		
		employeesSTUDENT = new Employees(); //ArrayList<Employee>();
		employeesSTUDENT.addEmployee(1, "Nabeel", "Hussain", 1200, 0, 1);
		employeesSTUDENT.addEmployee(2, "John", "Smith", 15, 45, 2);
		employeesSTUDENT.addEmployee(3, "Eric", "Williams", 20, 0, 3);
		employeesSTUDENT.addEmployee(4, "Michael", "Westbrook", 20, 15, 4);
		employeesSTUDENT.addEmployee(2, "Jamie", "King", 8.75, 35, 5);
		employeesSTUDENT.addEmployee(2, "Sarah", "Richards", 10, 50, 6);
		employeesSTUDENT.addEmployee(1, "Keith", "Davis", 800, 0, 7);
	}

	@After
	public void tearDown() throws Exception {
		employees = null;
		//STUDENT - set your employeesSTUDENT object to null
		employeesSTUDENT = null;
	}

	@Test
	/**
	 * Test the Add Employee method
	 * Add a new employee and then check that the number of
	 * the type of employee that was added has increased
	 */
	public void testAddEmployee() {
		assertEquals(2, employees.getNumStylists());
		employees.addEmployee(4,"Tanya","Tucker", 40, 10, 3);
		assertEquals(3, employees.getNumStylists());
		assertEquals(1,employees.getNumVets());	
	}
	/**
	 * Test the Add Employee method using the employeesSTUDENT object
	 * Add a new employee and then check that the number of
	 * the type of employee that was added has increased
	 */
	@Test
	public void testAddEmployeeSTUDENT() {
		assertEquals(1, employeesSTUDENT.getNumStylists());
		employeesSTUDENT.addEmployee(4,"Marc","Hayes", 12.50, 35, 10);
		assertEquals(2, employeesSTUDENT.getNumStylists());
		assertEquals(2,employeesSTUDENT.getNumManagers());
	}

	/**
	 * Test the calculateWeeklyPay method
	 * Test the weekly pay before adding a new employee
	 * Add a new employee
	 * Test the weekly pay after adding a new employee
	 */
	@Test
	public void testCalculateWeeklyPay() {
		assertEquals(3612.5,employees.calculateWeeklyPay(),1.0);
		employees.addEmployee(4, "Tanya", "Tucker", 40, 10, 3);
		assertEquals(4012.5,employees.calculateWeeklyPay(),1.0);
	}
	
	/**
	 * Test the calculateWeeklyPay method for the employeesSTUDENT object
	 * Test the weekly pay before adding a new employee
	 * Add a new employee
	 * Test the weekly pay after adding a new employee
	 */
	@Test
	public void testCalculateWeeklyPaySTUDENT() {
		assertEquals(4743.75,employeesSTUDENT.calculateWeeklyPay(),1.0);
		employeesSTUDENT.addEmployee(1, "John", "Doe", 2000, 0, 11);
		assertEquals(6743.75,employeesSTUDENT.calculateWeeklyPay(),1.0);
	}

	/**
	 * Test the generateWeeklyReport method 
	 */
	@Test
	public void testGenerateWeeklyReport() {
		
		String report = employees.generateWeeklyReport();
		String[] reportArray = report.split("\n");
		assertTrue(reportArray[0].contains("Pete's Pets"));
		assertTrue(reportArray[2].contains("EMPLOYEE"));
		assertTrue(reportArray[2].contains("WEEKLY PAY"));
		assertTrue(reportArray[4].contains("4 Bill Williams"));
		assertTrue(reportArray[5].contains("$400.00"));
		assertTrue(reportArray[7].contains("6 SueEllen Wilson"));
		assertTrue(reportArray[10].contains("$3,612.50"));
		assertTrue(reportArray[11].contains("Total number of Managers paid"));
		assertTrue(reportArray[13].contains("Total number of Vets paid"));
		}
	
	/**
	 * Test the generateWeeklyReport method for the employeeSTUDENT object
	 */
	@Test
	public void testGenerateWeeklyReportSTUDENT() {
		String reportSTUDENT = employeesSTUDENT.generateWeeklyReport();
		String[] reportArraySTUDENT = reportSTUDENT.split("\n");
		assertTrue(reportArraySTUDENT[0].contains("Pete's Pets"));
		assertTrue(reportArraySTUDENT[2].contains("EMPLOYEE"));
		assertTrue(reportArraySTUDENT[2].contains("WEEKLY PAY"));
		assertTrue(reportArraySTUDENT[4].contains("2 John Smith"));
		assertTrue(reportArraySTUDENT[5].contains("$875.00"));
		assertTrue(reportArraySTUDENT[7].contains("5 Jamie King"));
		assertTrue(reportArraySTUDENT[11].contains("$4,743.75"));
		assertTrue(reportArraySTUDENT[12].contains("Total number of Managers paid"));
		assertTrue(reportArraySTUDENT[14].contains("Total number of Vets paid"));
	}
}
