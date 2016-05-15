/**
* This class will hold a players information, including their first name, last name, and the position that they play.  
* @author Nabeel Hussain 
*/ 

public class Player {
	
	private String firstName;            // Declares variable to hold a players first name
	private String lastName;             // Declares variable to hold a players last name
	private Position playerPosition;     // Declares variable to hold a players position played
	
	/**
	 * Constructor for the Player class. It will store the first and last name of a player and their position 
	 *  @param first first name
	 *  @param last last name
	 *  @param pos players position
	 */
	public Player(String first, String last, Position pos)
	{
		firstName = first;
		lastName = last;
		playerPosition = pos;
	}
	
	/**
	 * A copy constructor for the Player class
	 * @param info a Player object variable, containing the players name and position played 
	 */
	public Player( Player info)
	{
		firstName = info.firstName;
		lastName = info.lastName;
		playerPosition = info.playerPosition;			
	}
	
	/**
	 * Will return the players first name 
	 *  @return the first name
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * Will return the players last name
	 *  @return the last name
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * Will return the players position
	 *  @return the last name
	 */
	public String getPosition()
	{
		return playerPosition.getPositionName();
	}
	
	/**
	 * Will return the players full name and position in string representation 
	 *  @return a string with the players full name followed by the position they play 
	 */
	public String toString()
	{
		String playerInfo =  firstName + " " + lastName + "  " + "Position: " + playerPosition;
		
		return playerInfo;		
	}
	
}