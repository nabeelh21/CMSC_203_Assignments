/**
* This class is the Data Manager class, and will contain methods that will help the basketball team application keep track of the players on a team.   
* @author Nabeel Hussain 
*/ 

import java.util.ArrayList;

public class Team
{
	private String teamName;              //  Declares variable to hold the name of the basketball team. 
	
	private static int numPlayers;        // static variable to keep track of the number of players that have been added to the team. 
	private static int numCenters;        // static variable to keep track of the number of centers that have been added to the team.
	private static int numForwards;       // static variable to keep track of the number of forwards that have been added to the team.
	private static int numGuards;         // static variable to keep track of the number of guards that have been added to the team.
	
	private ArrayList<Player> currentPlayers;     // ArrayList of Player objects to keep track of the players that have been added to a team. 
	
	
	/**
	 * Constructor for the Player class. It will take in a sting parameter, which will be stored in the teamName variable.
	 * It will also initialize the numPlayers, numCenters, numForwards, and numGuards to 0.
	 * It will also create an ArrayList to hold the players thats will be added to the team.   
	 *  @param tm team name
	 */
	public Team (String tm)
	{
		teamName = tm;
		numPlayers = 0;
		numCenters = 0;
		numForwards = 0;
		numGuards = 0;	
		currentPlayers = new ArrayList<>();
	}
	
	/**
	 * A static method that will return the number of players that have been added to the team.
	 * @return number of players added to team
	 */
	public static int getNumPlayers()
	{
		return numPlayers;
	}
	
	
	/**
	 * Will add a players first name, last name, and position played into an ArrayList of type Players. 
	 * @param fName first name
	 * @param lName last name
	 * @param pos position played
	 *  
	 * @return null if a player is successfully added. Otherwise, it will return an error message, describing the reason why the player was not added. 
	 */
	public String addPlayer(String fName, String lName, String pos)
	{
		String errorMessage;
		
		// If the "Center" position is selected for a player being added, and there is already a center on the roster, then display error message. 
		if (numCenters >= 1 && pos.equals("Center"))
		{
			errorMessage = "There is already a center on this team\nPlayer not added";
			
			return errorMessage;
		}
		// If the "Forward" position is selected for a player being added, and there are already two forwards on the roster, then display error message.
		else if (numForwards >= 2 && pos.equals("Forward"))
		{
			errorMessage = "There are already two forwards on this team\nPlayer not added";
			
			return errorMessage;
		}
		// If the "Guard" position is selected for a player being added, and there are already two guards on the roster, then display error message.
		else if (numGuards >= 2 && pos.equals("Guard"))
		{
			errorMessage = "There are already two guards on this team\nPlayer not added";
			
			return errorMessage;
		}
		// If there are already 5 players on the roster, then display error message saying that more cannot be added. 
		else if (numPlayers >= 5)
		{
			errorMessage = "There are already five members on this team\nPlayer not added";
			
			return errorMessage;
		}
		
		// If the above conditions don't apply, then add the player to the currentplayers ArrayList, along with the position that was selected.  
		else
		{
			if(pos.equals("Center"))
			{
				Position c = Position.CENTER;
				
				currentPlayers.add(new Player(fName, lName, c));
				numCenters += 1; // Keeps track of the number of Centers added
			}
			else if (pos.equals("Forward"))
			{
				Position f = Position.FORWARD;
				currentPlayers.add(new Player(fName, lName, f));
				numForwards += 1; // Keeps track of the number of Forwards added
			}
			else if (pos.equals("Guard"))
			{
				Position g = Position.GUARD;
				currentPlayers.add(new Player(fName, lName, g));
				numGuards += 1; // Keeps track of the number of Guards added, each time this method is called
			}
			
			numPlayers++;  // Keeps track of the number of players added
			return null;
		}
	}
	
	/**
	 * Will print the team name, followed by the names and positions of all the players that were added to the team. 
	 * @return teamRoster a string containing the team roster
	 */
	public String printTeam()
	{
		String teamRoster = teamName+"\n";
		
		for(int i = 0; i < currentPlayers.size(); i ++)
		{
			teamRoster += currentPlayers.get(i) + "\n";
		}
		
		return teamRoster;	
	}
	
	
	/**
	 * Will print a string representation of the team roster.
	 * @return teamRoster a string representation of the team roster
	 */
	public String toString()
	{
		String teamRoster = teamName+"\n";
		
		for(int i = 0; i < currentPlayers.size(); i ++)
		{
			teamRoster += currentPlayers.get(i) + "\n";
		}
		
		return teamRoster;
	}
}
