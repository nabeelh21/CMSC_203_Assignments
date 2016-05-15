/**
 * The CollegeFootballTeam class holds information about a college football team, i.e., name, sport, whether or not it is a professional,
 * what conference it plays in, and its votes. 
 * @author Nabeel Hussain
 */
public class CollegeFootballTeam extends Team {
	
	private String conference;     // Declares variable to hold the conference in which the team plays in 
	private int sumOfVotes = 0;    // Declares variable to hold the sum of all the votes for a team.
	private int[] votes = new int[12];   // Declares variable to hold all the integer votes for a team
	
	
	/**
	 * Constructor for the class CollegeFootballTeam, which takes in the teams name, conference, and array of integer votes as arguments.
	 * It also sets the sport as College Football,  
	 * @param name teams name
	 * @param conf the teams conference in which it plays in.
	 * @param v an array of integer votes used to rank the team.  
	 */
	public CollegeFootballTeam(String name, String conf, int[] v)
	{
		super(name, "College Football");
		super.setProfessional(false);
		super.getSport();
		conference = conf;
		votes = v;
	}
	
	/**
	 * A no-arg constructor for the class CollegeFootballTeam.    
	 */
	public CollegeFootballTeam()
	{
		super(null, null);
		super.setProfessional(false);
		conference = null;
		votes = null;
	}

	/**
	 * It will override the getName method in the superclass Team.
	 * @return the name of the team, which is stored in the superclass Team.   
	 */
	public String getName()
	{
		return super.getName();
	}
	
	/**
	 * It will override the setName method in the superclass Team. It will take the name of each college football team,
	 * and call the setName method from the superclass.
	 * @param name teams name 
	 */
	public void setName(String name)
	{
		super.setName(name);
	}

	/**
	 * It will return the sum of all the votes for each college football team.
	 * @return the sum of each college football teams votes   
	 */
	public int getSumOfVotes()
	{
		return sumOfVotes;
	}
	
	
	/**
	 * It will set the sum of the votes for each college football team.
	 * @param sumOfVotes the sum of all the college football teams votes  
	 */
	public void setSumOfVotes(int sumOfVotes)
	{
		this.sumOfVotes = sumOfVotes;
	}
	
	
	/**
	 * It will set the sum of the votes for each college football team, by adding up all of its votes being held in the int[] array.  
	 */
	public void setSumOfVotes()
	{
		for(int i = 0; i< votes.length; i++)
		{
			sumOfVotes += votes[i];
		}	
	}
	
	/**
	 * It will return the votes for each college football team.
	 * @return votes an array of integers that holds the votes of a college football team  
	 */
	public int[] getVotes()
	{
		
		return votes;
	}
	
	/**
	 * It will set the votes for each college football team.
	 * @param votes an array of integers that holds the votes of each college football team
	 */
	public void setVotes(int[] votes)
	{
		this.votes = votes;
	}
	
	/**
	 * It will set the conference name for each college football team.
	 * @param conference the teams conference in which it plays in
	 */
	public void setConferenceName(String conference)
	{
		this.conference = conference;
	}
	
	/**
	 * It will set the conference name for each college football team.
	 * @return conference the teams conference in which it plays in
	 */
	public String getConferenceName()
	{
		return conference;
	}
	
	
	/**
	 * Will print a string representation of the team.
	 * @return teamInfo a string representation of a college teams info and votes. 
	 */
	public String toString()
	{
		String teamInfo = super.getName() + "\n";
		teamInfo += conference + "\n";
		
		for(int i = 0; i < votes.length; i ++)
		{
			teamInfo += votes[i] + "\n";
		}	
		return teamInfo;
	}
}


