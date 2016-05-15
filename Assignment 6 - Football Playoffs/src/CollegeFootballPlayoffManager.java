import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The CollegeFootballPlayoffManager class will contain the methods that will help the CollegeFootballGUI application perform all its functions.
 * It will rank the teams from the highest ranked to the lowest, based on the sum of each teams total votes.   
 * @author Nabeel Hussain
 */
public class CollegeFootballPlayoffManager implements CFPManagerInterface {
	
	private final int NUM_TEAMS = 10;    // Declares a static variable holding the number of teams that will be ranked.
	private final int NUM_VOTERS = 12;   // Declares a static variable holding the number of voters who will give each team a rating. 
	private String[] teamConferences = new String [NUM_TEAMS];   	  // Declares a String array variable to hold each teams conference.
	private String[] teamNames = new String [NUM_TEAMS];         	  // Declares a String array variable to hold each teams name.
	private int[][] voteRecord = new int[NUM_VOTERS][NUM_TEAMS];  	  // Declares a two-dimensional array to hold all the votes for the 10 teams, by each of the 12 voters. 
	private ArrayList<CollegeFootballTeam> teams = new ArrayList<>(); // Declares an ArrayList of CollegeFootballTeam to hold all the information for each of the 10 teams. 

	
	 //Declares a String two dimensional array to hold all the votes, being read from the file.
    String[][] v = new String [NUM_VOTERS][NUM_TEAMS]; 
	
    // no-arg constructor for the CollegeFootballPlayoffManager class. 
	public CollegeFootballPlayoffManager()
	{
	}

	/**
	 * The readVotes method opens a file and reads its content, creating instances of the Team class for each column of data.
	 * The file contains the names of the teams and the votes of each committee member in ASCII format. Each member votes on each team.
	 * @param inFile the file provided by the user. The file's format is ASCII, with the first line being a comma-delimited string of 10 team names
	 * and the second line being a comma-delimited string of the corresponding 10 team conferences. The subsequent 12 lines are comma-delimited strings
	 * of integers representing the ranking of each of 12 committee members for the 10 teams, in the order listed in the first line. Lower numbers
	 * represent a higher ranking.
	*/
	public void readVotes(File inFile)
	{
		ArrayList<String> data = new ArrayList<>(); // Declares a String ArrayList to hold the contents of the file being read. 
		
		teams.clear();
		
		Scanner inputFile;
		
		try {
			inputFile = new Scanner(inFile);
			
			// Read each content, line by line from the .txt file into a String ArrayList
			while (inputFile.hasNext())
			{	
				data.add(inputFile.nextLine());
			}
		
			// Splits the first line of the file, containing all the teams names, and place them into the teamNames String array. 
			teamNames = data.get(0).split(",");
	        
			// Splits the second line of the file, containing the name of each teams conference, and place them into the teamConferences String array.  
	        teamConferences = data.get(1).split(",");
	      
	        
	        for(int row = 0; row < NUM_VOTERS; row++)
	        {	
	        	// Beginning from the third line of the file that was read in, split the numbers in each line and place them into the rows of the String[][] array
	        	v[row] = data.get(row+2).split(",");
	        	
	        	for(int col = 0; col < NUM_TEAMS; col++)
	        	{
	        		// Parse the String values from the String[][] array into integers, and place them into the int[][] array
	        		voteRecord[row][col] = Integer.parseInt(v[row][col]);
		        }
	        }
	        
		    for(int i = 0; i < NUM_TEAMS; i++)
		    {
		    	// Declares an int array to hold the votes for each individual team.
		        int[] teamsVotes = new int[NUM_VOTERS];  
		        
		    	// Adding the votes for each individual team into an int[] array, from the 12 voters.  
		    	for(int j=0; j<NUM_VOTERS; j++)
		    	{
		    		// Places the int votes from each of the 12 voters for a team, from the int[][] array, into an int[] array for each individual team. 
		    		teamsVotes[j] = voteRecord[j][i];
		    		//System.out.print(teamsVotes[j] + ",");
		    	}
		    	//System.out.println();
		    	
		    	// Creates a CollegeFootbalTeam object, which will store the information from each individual team and then add it into an ArrayList.
		    	// It will repeat this 10 times, to add all 10 teams information into the ArrayList. 
		    	CollegeFootballTeam t = new CollegeFootballTeam(teamNames[i], teamConferences[i],teamsVotes);
		    	
		    	//Sums the votes for each team being added into the ArrayList
		    	t.setSumOfVotes();
		    	//t.setVotes(teamsVotes);
		    
		    	// Add the team into the teams ArrayList.
		    	teams.add(t);	
		    }	   
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * The rankTeams method accesses existing votes for each team, sums the votes, and ranks the teams from lower to higher scores.
	 * The teams are placed in a new ArrayList by increasing total score.
	 * @return an ArrayList sorted with the lowest-voted team first, increasing to the highest-voted (last-ranked) team last.
	*/
	public ArrayList<CollegeFootballTeam> rankTeams()
	{
		ArrayList<CollegeFootballTeam> rankedTeams = new ArrayList<>();
		
		// Calls the selection sort method, which ranks the teams from lower to higher scores based on the sum of their votes.
		// The teams are placed into a new ArrayList. 
		rankedTeams = selectionSort(teams);
		
		return rankedTeams;
	}
	
	
	/**
	 * The sortTeams method sorts the list of Teams into ascending order of cumulative votes, i.e., 
	 * lower score is better, or higher ranking.  Uses a selection sort.
	 * @param list the ArrayList<Team> to be sorted
	 * @return the sorted ArrayList<Team>
	*/
	public ArrayList<CollegeFootballTeam> selectionSort(ArrayList<CollegeFootballTeam> list)
	{
		CollegeFootballTeam highestRankedTeam;
		int maxI;
		for(int i = 0; i < list.size(); i++)
		{
			highestRankedTeam = list.get(i);
			maxI = i;
			for(int j=i+1; j<list.size(); j++)
			{
				if(list.get(j).getSumOfVotes() < highestRankedTeam.getSumOfVotes())
				{
					highestRankedTeam = list.get(j);
					maxI = j;
				}
			}
			CollegeFootballTeam temp = list.get(i);
			list.set(i, highestRankedTeam);
			list.set(maxI, temp);
		}
		return list;
	}
	
	/**
	 * Will add a new team into the existing list of teams
	 * @param name the teams name
	 * @param conf the teams conference
	 * @param v an array holding the 12 votes for the team 
	 * @return the ArrayList of teams after a new team has been added
	*/
	public ArrayList<CollegeFootballTeam> addTeam(String name, String conf, int[] v)
	{
		CollegeFootballTeam newTeam = new CollegeFootballTeam(name,conf, v);
		newTeam.setSumOfVotes();
		
		teams.add(newTeam);
	
		return teams;
	}

	/**
	 * Get the ArrayList of CollegeFootballTeams previously read in.
	 * @return the current ArrayList of teams read in, and possibly sorted by votes
	*/
	public ArrayList<CollegeFootballTeam> getTeamList()
	{
		return teams;
	}
	
	
	/**
	 * The getTeamNames method retrieves each Team from the ArrayList and puts its team name in an array of Strings, to be returned.
	 * @return an array of String[10] with each team name
	*/
	public String[] getTeamNames()
	{
		
		String[] names = new String[NUM_TEAMS];
		
		for(int i = 0; i < teams.size(); i++)
		{
			names[i] = teams.get(i).getName();	
		}

		return names;
	}
	
	
	/**
	 * Will print a string representation of all the teams in the ArrayList.
	 * @return teamRoster a string representation of the college football teams.
	 */
	public String toString()
	{
		String teamRoster = "";
		
		for(int i = 0; i < teams.size(); i ++)
		{
			teamRoster += teams.get(i) + " ";
		}	
		return teamRoster;
	}
}





