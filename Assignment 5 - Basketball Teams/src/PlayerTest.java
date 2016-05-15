import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * This is a JUnit test program to test the Data Element class - Player.
 * The following classes must be defined and implemented:
 * Position - enumeration
 * Player - data element
 *  
 * @author Nabeel Hussain
 */

public class PlayerTest {
	
	/**  A Player object and Position object reference used for testing */
	Player player;
	Position position;
	
	@Before
	/** Initializes a Player object with a players first name, last name, and their playing position. */
	public void setUp() throws Exception {
		position = Position.GUARD;
		player = new Player("Nabeel", "Hussain", position);	
	}

	@After
	/** This method is run after each individual test
	 *  It sets the player and position reference to null, so the garbage
	 *  collector can reclaim the memory used for the Player object
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		player = null;
		position = null;
	}

	@Test
	/**
	 * Test to:
	 * Check if the first name is Nabeel
	 */
	public void testGetFirstName() {
		String firstName;	
		firstName = player.getFirstName();
		assertEquals("Nabeel", firstName);	
	}

	@Test
	/**
	 * Test to:
	 * Check if the last name is Hussain
	 */
	public void testGetLastName() {
		String lastName;	
		lastName = player.getLastName();
		assertEquals("Hussain", lastName);
	}

	@Test
	/**
	 * Test to:
	 * Check if the players positiob is Guard
	 */
	public void testGetPosition() {
		String playerPosition;	
		playerPosition = player.getPosition();
		assertEquals("Guard", playerPosition);
	}

}
