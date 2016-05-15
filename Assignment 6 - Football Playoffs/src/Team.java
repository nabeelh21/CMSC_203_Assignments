/**
 * The Team class holds information about a team, i.e., name, 
 * what sport it plays, and whether or not it is professional
 * @author R Alexander
 */
public class Team {
	
	private String name;
	private String sport;
	private boolean professional;
	
	
	/**
	 * The no-arg Team constructor
	 */
	Team() {
		setName(null);
		setSport(null);
		setProfessional(true);
	}
	
	/**
	 * Team constructor that takes the team name and the sport it plays
	 * @param name the String college team name
	 * @param sports the sport the team plays
	 */
	Team(String name, String sport) {
		setName(name);
		setSport(sport);
		setProfessional(true);
	}
	
	/**
	 * Will return the name of the team
	 * @return the college football teams name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Will take the String parameter passed in, and assign that as the name of the team
	 * @param name the college football teams name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Will return the name of the team
	 * @return the college football teams name
	 */
	public String getSport() {
		return sport;
	}

	/**
	 * Will take the String parameter passed in, and assign that as the sport the team plays
	 * @param sport the sport the team plays
	 */
	public void setSport(String sport) {
		this.sport = sport;
	}
	
	/**
	 * Will return a boolean expression on whether the team is a professional team or not. 
	 * @return the college football teams name
	 */
	public boolean getProfessional() {
		return professional;
	}
	
	
	/**
	 * Will take the boolean expression passed in, and use it to tell whether the team is professional or not. 
	 * @param sport the sport the team plays
	 */
	public void setProfessional(boolean professional) {
		this.professional = professional;
	}
}


