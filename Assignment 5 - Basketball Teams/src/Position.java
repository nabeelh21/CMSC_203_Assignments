/**
* This enumerated class will help to identify the valid values of basketball positions, which are “Guard”, “Center”, and “Forward”.  
* @author Nabeel Hussain 
*/ 

public enum Position
{
	CENTER ("Center"), FORWARD ("Forward"), GUARD ("Guard");
	
	private String positionName;
	
	/**
	 * Constructor
	 * @param name of position
	 */
	Position(String pos)
	{
		positionName = pos;
	}
	
	
	/**
	 * Returns the string value 
	 * @return string value of the position name.
	 */
	public String getPositionName()
	{
		return positionName;
	}
	
	
	/**
	 * Returns the string value
	 * @return string representation of the position name.
	 */
	public String toString()
	{
		return positionName;
	}
	
}
