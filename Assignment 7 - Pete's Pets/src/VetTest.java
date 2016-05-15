import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for the Vet class
 */
public class VetTest {
	
	// Create instances of the Vet class
	private Vet employee1;
	private Vet employee2;
	private Vet employee3;
	
	@Before
	public void setUp() throws Exception {
		
		// Creating three different Vet employees to use for testing
		employee1 = new Vet(3, "Nabeel", "Hussain", 20, 1111);
		employee2 = new Vet(3, "Josh", "Smith", 15, 2222);
		employee3 = new Vet(3, "John", "Doe", 30, 3333); 

	}

	@After
	public void tearDown() throws Exception {
		employee1 = null;
		employee2 = null;
		employee3 = null;
	}

	
	@Test
	/**
	 * Tests the calculate weekly pay method
	 * Check to see if the weekly pay for each of the veterinarians are calculated correctly.
	 */
	public void testCalculateWeeklyPay() {
		//Employee 1 should have weekly pay of 875
		assertEquals(875, employee1.calculateWeeklyPay(), .01);
		//Employee 2 should have weekly pay of 856.25
		assertEquals(856.25, employee2.calculateWeeklyPay(), .01);
		//Employee 3 should have weekly pay of 912.50
		assertEquals(912.50,employee3.calculateWeeklyPay(), .01);	
	}
	
	@Test
	/**
	 * Tests the compareTo method
	 */
	public void testCompareTo() {
		// Employee1 has a lower ID number then employee2, therefore it should return a -1, based on the compareTo() method defined in the Employee class's. 
		assertEquals(-1, employee1.compareTo(employee2));
		
		// Employee2 has a lower ID number then employee3, therefore it should return a -1, based on the compareTo() method defined in the Employee class's.  
		assertEquals(-1, employee2.compareTo(employee3));
	
		// Employee3 has a higher ID number then employee1, therefore it should return a 1, based on the compareTo() method defined in the Employee class's.  
		assertEquals(1, employee3.compareTo(employee1));
	}
	
	@Test
	/**
	 * Tests the getFirstName method
	 */
	public void testGetFirstName() {
		
		//Employee 1 should return "Nabeel" as its first name
		assertEquals("Nabeel", employee1.getFirstName());
		
		//Employee 2 should return "Josh" as its first name
		assertEquals("Josh", employee2.getFirstName());
	
		//Employee 3 should return "John" as its first name
		assertEquals("John",employee3.getFirstName());
	}
	
	
	@Test
	/**
	 * Tests the getLastName method
	 */
	public void testGetLasttName() {
		//Employee 1 should return "Hussain" as its last name
		assertEquals("Hussain", employee1.getLastName());
		
		//Employee 2 should return "Smith" as its last name
		assertEquals("Smith", employee2.getLastName());
		
		//Employee 3 should return "Doe" as its last name
		assertEquals("Doe",employee3.getLastName());
	}
	
	@Test
	/**
	 * Tests the getIdNumber method
	 */
	public void testGetIdNumber() {
		//Employee 1 should return 1111 as its id number
		assertEquals(1111, employee1.getIdNumber());
		
		//Employee 2 should return 2222 as its id number
		assertEquals(2222, employee2.getIdNumber());
	
		//Employee 3 should return 3333 as its id number
		assertEquals(3333,employee3.getIdNumber());
	}
	
	
	@Test
	/**
	 * Tests the toString method
	 */
	public void testToString() {

		assertEquals("1111 Nabeel Hussain $875.00", employee1.toString());
		
		assertEquals("2222 Josh Smith $856.25", employee2.toString());
	
		assertEquals("3333 John Doe $912.50",employee3.toString());
	}

}
