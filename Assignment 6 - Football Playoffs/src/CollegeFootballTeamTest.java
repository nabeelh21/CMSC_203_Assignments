import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CollegeFootballTeamTest {
	
	// Create a CollegeFootballTeam object to test.
	private CollegeFootballTeam team1;

	// Create a second CollegeFootballTeam object to test.
	private CollegeFootballTeam team2;

	@Before
	public void setUp() throws Exception {
		
		// Create a sample of 12 votes for team 1
		int [] team1Votes = {1,5,1,2,1,3,2,1,2,1,1,2};
		// Initialize team1 with sample information to test on 
		team1 = new CollegeFootballTeam ("Team 1", "ACC", team1Votes);
		
		// Create a sample of 12 votes for team 2
		int [] team2Votes = {2,2,5,3,2,4,3,2,2,2,3,3};
		// Initialize team2 with sample information to test on 
		team2 = new CollegeFootballTeam ("Team 2", "SEC", team2Votes);
	}

	@After
	public void tearDown() throws Exception {
		
		team1 = null;
		team2 = null;
		
	}

	// test for the getName() method
	@Test
	public void testGetName() {
		
		// Test 1
		String team1Name = team1.getName();
		assertEquals(team1Name,"Team 1");
		
		
		// Test 2
		String team2Name = team2.getName();
		assertEquals(team2Name,"Team 2");
		
	}
	
	// test for the getSumOfVotes() method
	@Test
	public void testGetSumOfVotes() {
		
		// Test 1
		team1.setSumOfVotes();
		int team1SumOfVotes = team1.getSumOfVotes();
		assertEquals(team1SumOfVotes,22,.001);
		
		
		// Test 2
		team2.setSumOfVotes();
		int team2SumOfVotes = team2.getSumOfVotes();
		assertEquals(team2SumOfVotes,33,.001);	
	}

	// test for the getVotes() method
	@Test
	public void testGetVotes() {

		// Test 1
		int[] team1Votes= team1.getVotes();
		assertEquals(team1Votes[0],1);
		assertEquals(team1Votes[5],3);
		
		
		// Test 2
		int[] team2Votes= team2.getVotes();
		assertEquals(team2Votes[0],2);	
		assertEquals(team2Votes[11],3);
	}

	@Test
	public void testGetConferenceName() {
		
		// Test 1
		String team1Conference = team1.getConferenceName();
		assertEquals(team1Conference,"ACC");
		
		
		// Test 2
		String team2Conference = team2.getConferenceName();
		assertEquals(team2Conference,"SEC");
	}
}
