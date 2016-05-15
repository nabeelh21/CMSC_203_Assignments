/*The purpose of this class is to model a television
 * Nabeel Hussain
 * 9/12/2015
 */

public class Television {
	
	private String MANUFACTURER;  // Declares variable to hold the brand name of the tv
	private int SCREEN_SIZE;      // Declares variable to hold the size of the tv
	private boolean powerOn;      // Declares variable to hold the value true if the power is on, and false if the power is off 
	private int channel;          // Declares variable that will hold the value of the station that the tv is on
	private int volume;           // Declares variable that will hold a number value representing the loudness (0 being no sound)
	
	// Constructor created, and will be used to create an instance of the Television. 
	public Television(String brand, int size )
	{
		MANUFACTURER = brand;
		SCREEN_SIZE = size;
		powerOn = false;
		volume = 20;
		channel = 2;
	}
	
	// Will return the value stored in the the volume field.
	public int getVolume()
	{
		return volume;
	}
	
	// Will return the value stored in the channel field. 
	public int getChannel()
	{
		return channel;
	}
	
	// Will return the constant value stored in the MANUFACTURER field. 
	public String getManufacturer()
	{
		return MANUFACTURER;
	}
	
	// Will return the constant value stored in the SCREEN_SIZE field. 
	public int getScreenSize()
	{
		return SCREEN_SIZE;
	}
	
	// Will store the desired station in the channel field. 
	public void setChannel( int channelNumber)
	{
		channel = channelNumber;
	}
	
	// Will toggle the power of the tv between on and off, changing the value
	//stored in the powerOn field from true to false or from false to true. 
	public boolean power()
	{
		return powerOn = !powerOn;
	}
	
	// Will increase the volume stored in the volume field by 1.
	public void increaseVolume ()
	{
		volume += 1;
	}
	
	// Will decrease the volume stored in the volume field by 1.
	public void decreaseVolume ()
	{
		volume -= 1;
	}

}



















