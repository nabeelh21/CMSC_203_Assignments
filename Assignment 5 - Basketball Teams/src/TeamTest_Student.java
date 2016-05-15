import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUnit test program to test the Data Manager class - Team.
 * The following classes must be defined and implemented:
 * Position - enumeration
 * Player - data element
 * Team - data manager
 * 
 * STUDENT - Create another Team object.
 * Add players to your Team object.  The team name 
 * and players must be different than those already in TeamTest.java.  
 * Use YOUR Team object for the following tests:
 * public void testGetNumPlayersSTUDENT()
 * public void testAddPlayerSTUDENT()
 * public void testPrintTeamSTUDENT()
 * 
 * @author Nabeel Hussain
 */

public class TeamTest_Student {
	/**  A Team object reference used for testing */
	Team studentTeam;
	
	@Before
	/** This method is run before each individual test
	 *   Creates an object of Team and adds three
	 *   Players to the Team
	 */
	public void setUp() throws Exception {		
		/* STUDENT - create a new Team and add players to your team.  
		 * Use this team object in the STUDENT tests
		 * Example:
		   studentTeam = new Team("Horses");
		   studentTeam.addPlayer("Edward","Cullen", "Forward");
		*/
		studentTeam = new Team("Nabeel's Team");
		studentTeam.addPlayer("Nabeel", "Hussain","Forward");
		studentTeam.addPlayer("Otto", "Porter", "Forward");
		studentTeam.addPlayer("John", "Wall", "Guard");
		studentTeam.addPlayer("Bradley", "Beal", "Guard");
	}

	@After
	/** This method is run after each individual test
	 *   It sets the team reference to null so the garbage
	 *   collector can reclaim the memory used for the
	 *   Team object
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		/* STUDENT - set your team object to null */
		studentTeam = null;
	}

	@Test
	/**
	 * Test to 
	 * 1.  check if the number of players is originally 4
	 * 2.  Add another player, and check if number of players is 5
	 */
	/*  STUDENT test */
	public void testGetNumPlayersSTUDENT()
	{
		assertEquals(4,Team.getNumPlayers());
		studentTeam.addPlayer("Marcin", "Gortat", "Center");
		assertEquals(5, Team.getNumPlayers());
	}
	
	@Test
	/**
	 * Test to
	 * 1.  add a new player as a forward
	 *     check if recognizes there is already 2 forwards on the team
	 * 2.  add a new player as a guard
	 *     check if recognizes there is already 2 guards on the team
	 * 3.  add new player as a center - player is added
	 */
	public void testAddPlayerSTUDENT() {
		String result;
		result = studentTeam.addPlayer("Drew", "Gooden", "Forward");
		assertEquals("There are already two forwards on this team\nPlayer not added", result);
		result = studentTeam.addPlayer("Kobe", "Bryant", "Guard");
		assertEquals("There are already two guards on this team\nPlayer not added", result);
		result = studentTeam.addPlayer("Marcin", "Gortat", "Center");
		assertEquals(null, result);
	}

	
	@SuppressWarnings("resource")
	@Test
	/**
	 * Test to:
	 * 1.  Check if the team name is on the first line
	 * 2.  Check if Bradley is on the fifth line
	 * 3.  Add a center
	 * 4.  Check if the team name is on the first line
	 * 5.  Check if Bradley is on the fifth line
	 * 6.  Check if Marcin is on the sixth line
	 */
	/*  STUDENT test */
	public void testPrintTeamSTUDENT() {
		String result = studentTeam.printTeam();
		Scanner teamResults = new Scanner(result);
		assertEquals("Nabeel's Team",teamResults.nextLine()); 
		//extract four team players
		teamResults.nextLine();  //Nabeel Hussain     Position Forward
		teamResults.nextLine();  //Otto Porter     Position Forward
		teamResults.nextLine();  //John Wall     Position Guard
		assertEquals("Bradley",teamResults.next()); //Bradley
		//Now add a Center and test
		studentTeam.addPlayer("Marcin", "Gortat", "Center");
		
		result = studentTeam.printTeam();
		teamResults = new Scanner(result);
		assertEquals("Nabeel's Team",teamResults.nextLine()); 
		//extract four team players
		teamResults.nextLine();  //Nabeel Hussain     Position Forward
		teamResults.nextLine();  //Otto Porter     Position Forward
		teamResults.nextLine();  //John Wall     Position Guard
		assertEquals("Bradley",teamResults.next()); //John
		teamResults.nextLine(); //rest of Bradley Line
		assertEquals("Marcin",teamResults.next());
		teamResults.close();
	}
}