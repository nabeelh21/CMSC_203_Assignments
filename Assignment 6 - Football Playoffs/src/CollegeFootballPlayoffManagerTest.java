

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CollegeFootballPlayoffManagerTest {
	
	
	private File newFile;
	private PrintWriter output;
	private CFPManagerInterface mgr;
	
	// Used for Student test 1
	private File newFileStudent;
	private PrintWriter outputStudent;
	private CFPManagerInterface mgrStudent;
	
	// Used for Student test 2
	private File newFileStudent2;
	private PrintWriter outputStudent2;
	private CFPManagerInterface mgrStudent2;
	
	@Before
	public void setUp() throws Exception {
		newFile = new File("CFPTest");
		try {
			output = new PrintWriter(newFile);
			
			output.println("MissState,FloridaSt,Auburn,OleMiss,Oregon,Alabama,TCU,MichSt,KState,NotreDm");
			output.println("SEC,ACC,SEC,SEC,Pac-12,SEC,Big12,BigTen,Big12,Indep");
			output.println("4,1,9,10,7,12,13,11,5,6");
			output.println("1,2,10,4,5,14,7,8,16,6");
			output.println("1,2,6,8,5,14,7,4,10,3");
			output.println("1,4,2,3,5,8,7,6,10,16");
			output.println("2,4,9,3,5,8,12,14,10,16");
			output.println("1,4,2,6,5,8,12,9,16,10");
			output.println("1,9,3,2,5,14,12,4,7,10");
			output.println("1,2,3,8,4,5,12,14,7,6");
			output.println("4,1,3,8,2,5,12,14,7,13");
			output.println("1,2,8,4,6,5,7,14,13,9");
			output.println("1,2,6,4,5,14,7,12,13,8");
			output.println("1,2,10,4,5,14,7,12,13,8");

			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mgr = new CollegeFootballPlayoffManager();
		
		
		// My Student Test1 File
		newFileStudent = new File("CFPTestStudent");
		try {
			outputStudent = new PrintWriter(newFileStudent);
			
			outputStudent.println("A,D,E,B,H,J,G,I,C,F");
			outputStudent.println("SEC,ACC,SEC,SEC,Pac-12,SEC,Big12,BigTen,Big12,Indep");
			outputStudent.println("1,4,5,2,8,10,7,9,3,6");
			outputStudent.println("1,4,5,2,8,10,7,9,3,6");
			outputStudent.println("1,4,5,2,8,10,7,9,3,6");
			outputStudent.println("1,4,5,2,8,10,7,9,3,6");
			outputStudent.println("1,4,5,2,8,10,7,9,3,6");
			outputStudent.println("1,4,5,2,8,10,7,9,3,6");
			outputStudent.println("1,4,5,2,8,10,7,9,3,6");
			outputStudent.println("1,4,5,2,8,10,7,9,3,6");
			outputStudent.println("1,4,5,2,8,10,7,9,3,6");
			outputStudent.println("1,4,5,2,8,10,7,9,3,6");
			outputStudent.println("1,4,5,2,8,10,7,9,3,6");
			outputStudent.println("1,4,5,2,8,10,7,9,3,6");

			outputStudent.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mgrStudent = new CollegeFootballPlayoffManager();
			
		
		// My Student Test2 File
		newFileStudent2 = new File("CFPTestStudent2");
		try {
			outputStudent2 = new PrintWriter(newFileStudent2);
			
			outputStudent2.println("Team 1,Team 2,Team 3,Team 4,Team 5,Team 6,Team 7,Team 8,Team 9,Team 10");
			outputStudent2.println("SEC,ACC,SEC,SEC,Pac-12,SEC,Big12,BigTen,Big12,Indep");
			outputStudent2.println("10,4,5,2,8,10,7,9,3,6");
			outputStudent2.println("10,5,5,2,8,10,7,8,4,6");
			outputStudent2.println("9,4,5,2,8,9,7,9,3,6");
			outputStudent2.println("10,4,5,1,8,10,7,9,4,5");
			outputStudent2.println("10,5,5,2,8,10,7,9,3,6");
			outputStudent2.println("8,4,5,1,8,9,7,9,3,6");
			outputStudent2.println("9,5,5,2,1,10,7,9,4,5");
			outputStudent2.println("6,5,5,1,3,9,7,9,3,6");
			outputStudent2.println("10,4,5,2,2,10,7,8,3,6");
			outputStudent2.println("9,5,5,2,1,10,7,9,3,4");
			outputStudent2.println("8,5,5,2,1,10,7,9,3,6");
			outputStudent2.println("10,5,5,2,1,10,7,9,3,6");

			outputStudent2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mgrStudent2 = new CollegeFootballPlayoffManager();	
	}

	@After
	public void tearDown() throws Exception {
		mgr = null;
		mgrStudent = null;
		mgrStudent2 = null;
	}

	@Test
	public void testReadVotes() {
		File inFile = new File("CFPTest");
		mgr.readVotes(inFile);
		ArrayList<CollegeFootballTeam> list = mgr.getTeamList();
		assertEquals(list.get(1).getName(),"FloridaSt");
		assertEquals(list.get(4).getName(),"Oregon");
		assertTrue(list.get(2).getSumOfVotes()==71);
		assertTrue(list.get(5).getSumOfVotes()==121);
		if(list.get(1).getProfessional()==true) {
			fail(list.get(1).getName()+" should not be a professional team");	
		}
	}
	
	// My student test for the readVotes method.
	@Test
	public void testReadVotesSTUDENT() {
		File inFileStudent = new File("CFPTestStudent");
		mgrStudent.readVotes(inFileStudent);
		ArrayList<CollegeFootballTeam> listStudent = mgrStudent.getTeamList();
		assertEquals(listStudent.get(1).getName(),"D");
		assertEquals(listStudent.get(4).getName(),"H");
		assertTrue(listStudent.get(2).getSumOfVotes()==60);
		assertTrue(listStudent.get(5).getSumOfVotes()==120);
		if(listStudent.get(1).getProfessional()==true) {
			fail(listStudent.get(1).getName()+" should not be a professional team");
		}
		assertEquals(listStudent.get(0).getVotes()[0],1,.001);

		
		// Student test 2
		File inFileStudent2 = new File("CFPTestStudent2");
		mgrStudent2.readVotes(inFileStudent2);
		ArrayList<CollegeFootballTeam> listStudent2 = mgrStudent2.getTeamList();
		assertEquals(listStudent2.get(1).getName(),"Team 2");
		assertEquals(listStudent2.get(4).getName(),"Team 5");
		assertTrue(listStudent2.get(2).getSumOfVotes()==60);
		assertTrue(listStudent2.get(5).getSumOfVotes()==117);
		if(listStudent2.get(1).getProfessional()==true) {
			fail(listStudent2.get(1).getName()+" should not be a professional team");
		}
		assertEquals(listStudent2.get(9).getVotes()[11],6,.001);
	}

	@Test
	public void testRankTeams() {
		File inFile = new File("CFPTest");
		mgr.readVotes(inFile);
		ArrayList<CollegeFootballTeam> rankings = mgr.rankTeams();
		assertEquals(rankings.get(5).getName(),"NotreDm");
		assertEquals(rankings.get(8).getName(),"MichSt");
		assertEquals(rankings.get(2).getSumOfVotes(),59,.001);
		assertEquals(rankings.get(4).getSumOfVotes(),71,.001);
		assertEquals(rankings.get(3).getVotes()[6],2,.001);
	}
	
	// My student test for the rankTeams method.
	@Test
	public void testRankTeamsSTUDENT() {
		File inFileStudent = new File("CFPTestStudent");
		mgrStudent.readVotes(inFileStudent);
		ArrayList<CollegeFootballTeam> rankingsStudents = mgrStudent.rankTeams();
		assertEquals(rankingsStudents.get(5).getName(),"F");
		assertEquals(rankingsStudents.get(8).getName(),"I");
		assertEquals(rankingsStudents.get(2).getSumOfVotes(),36,.001);
		assertEquals(rankingsStudents.get(4).getSumOfVotes(),60,.001);
		assertEquals(rankingsStudents.get(5).getConferenceName(),"Indep");
		assertEquals(rankingsStudents.get(5).getVotes()[2],6,.001);
		
		
		// Student test 2
		File inFileStudent2 = new File("CFPTestStudent2");
		mgrStudent2.readVotes(inFileStudent2);
		ArrayList<CollegeFootballTeam> rankingsStudents2 = mgrStudent2.rankTeams();
		assertEquals(rankingsStudents2.get(5).getName(),"Team 10");
		assertEquals(rankingsStudents2.get(8).getName(),"Team 1");
		assertEquals(rankingsStudents2.get(2).getSumOfVotes(),55,.001);
		assertEquals(rankingsStudents2.get(4).getSumOfVotes(),60,.001);
		assertEquals(rankingsStudents2.get(5).getConferenceName(),"Indep");
		assertEquals(rankingsStudents2.get(5).getVotes()[3],5,.001);
	}
	
	@Test
	public void testGetTeamList() {
		File inFile = new File("CFPTest");
		mgr.readVotes(inFile);
		ArrayList<CollegeFootballTeam> tmList = mgr.getTeamList();
		assertEquals(tmList.get(5).getName(),"Alabama");
		assertEquals(tmList.get(5).getConferenceName(),"SEC");
		assertEquals(tmList.get(2).getSumOfVotes(),71,.001);
	}
	
	// My student tests for the rankTeams method.
	// It will return the current list of teams that were read in from the file.
	// The list of teams will not be sorted by votes, unless the rankTeams() method was called prior to calling the getTeamList() method.
	@Test
	public void testGetTeamListSTUDENT() {
		File inFileStudent = new File("CFPTestStudent");
		mgrStudent.readVotes(inFileStudent);
		ArrayList<CollegeFootballTeam> tmListStudent = mgrStudent.getTeamList();
		assertEquals(tmListStudent.get(5).getName(),"J");
		assertEquals(tmListStudent.get(5).getConferenceName(),"SEC");
		assertEquals(tmListStudent.get(2).getSumOfVotes(),60,.001);
		
		// Student test 2
		File inFileStudent2 = new File("CFPTestStudent2");
		mgrStudent2.readVotes(inFileStudent2);
		ArrayList<CollegeFootballTeam> tmListStudent2 = mgrStudent2.getTeamList();
		assertEquals(tmListStudent2.get(5).getName(),"Team 6");
		assertEquals(tmListStudent2.get(5).getConferenceName(),"SEC");
		assertEquals(tmListStudent2.get(2).getSumOfVotes(),60,.001);
	}
	
	// My student tests for the addTeam method, to see if new teams are correctly being added into the ArrayList of CollegeFootballTeam.
	@Test
	public void testAddTeamSTUDENT() {
		File inFileStudent = new File("CFPTestStudent");
		mgrStudent.readVotes(inFileStudent);
		ArrayList<CollegeFootballTeam> tmListStudent = mgrStudent.getTeamList();
		int [] newTeamsVotes = {11,11,11,11,11,11,11,11,11,11,11,11};
		tmListStudent = mgrStudent.addTeam("K", "ACC", newTeamsVotes );
		assertEquals(tmListStudent.get(10).getName(),"K");
		assertEquals(tmListStudent.get(10).getConferenceName(),"ACC");
		assertEquals(tmListStudent.get(10).getSumOfVotes(),132,.001);
		
		
		// Student test 2
		File inFileStudent2 = new File("CFPTestStudent2");
		mgrStudent2.readVotes(inFileStudent2);
		ArrayList<CollegeFootballTeam> tmListStudent2 = mgrStudent2.getTeamList();
		int [] newTeamsVotes2 = {12,12,12,12,12,12,12,12,12,12,12,12};
		tmListStudent2 = mgrStudent2.addTeam("Team 11", "SEC", newTeamsVotes2 );
		assertEquals(tmListStudent2.get(10).getName(),"Team 11");
		assertEquals(tmListStudent2.get(10).getConferenceName(),"SEC");
		assertEquals(tmListStudent2.get(10).getSumOfVotes(),144,.001);
	}
	
	// My student tests for the getTeamNames method, to see if it reads back the names correctly from the file read in. 
		@Test
		public void testGetTeamNamesSTUDENT() {
			File inFileStudent = new File("CFPTestStudent");
			mgrStudent.readVotes(inFileStudent);
			String [] teamNames = mgrStudent.getTeamNames();
			assertEquals(teamNames[0],"A");
			assertEquals(teamNames[5],"J");
			assertEquals(teamNames[9],"F");
			
			
			// Student test 2
			File inFileStudent2 = new File("CFPTestStudent2");
			mgrStudent2.readVotes(inFileStudent2);
			String [] teamNames2 = mgrStudent2.getTeamNames();
			assertEquals(teamNames2[0],"Team 1");
			assertEquals(teamNames2[5],"Team 6");
			assertEquals(teamNames2[9],"Team 10");
		}		
}
