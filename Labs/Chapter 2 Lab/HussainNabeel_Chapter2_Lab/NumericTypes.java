/**
* This program demonstrates how numeric types and operators behave in Java
* 
* Name: Nabeel Hussain
* Class: CMSC203
* Professor: Jeannette Myers Kartchner
* Chapter 2 Lab
* Date: 09/07/2015
*/


//TASK #2  (Alternate) Add import statement to use JOptionPane class
import javax.swing.JOptionPane; 

//TASK #4  Add import statement here to use the Math class
import java.lang.Math;

//Import statement to use the Scanner class
import java.util.Scanner;

public class NumericTypes
{
	public static void main (String [] args)
	{
		//TASK #2 Create a Scanner object here (not used for alternate)
		Scanner keyboard = new Scanner(System.in);
	
		//identifier declarations
		final int NUMBER = 2 ;		   // number of scores
		final int SCORE1 = 100;		   // first test score
		final int SCORE2 = 95;		   // second test score
		final int BOILING_IN_F = 212;  // boiling temperature
		double fToC;				   // temperature in Celsius
		double average;				   // arithmetic average
		String output;				   // line of output to print out
		
		//TASK #2 (Alternate Version) declare variables used here
		String firstName;   // Declares variable to hold the first name of the user
		String lastName;    // Declares variable to hold the last name of the user
		String fullName;    // Declares variable to hold the full name of the user
		
		//TASK #3 declare variables used here
		char firstInitial;   // Declares variable to hold the first initial of the user
		int stringSize;      // Declares variable to hold the length or size of the users full name
		
		//TASK #4 declare variables used here
		double diameter;   // Declares variable to hold the diameter of a sphere
		double radius;     // Declares variable to hold the radius of the sphere
		double volume;     // Declares variable to hold the volume of the sphere

		// Find an arithmetic average
		average = (SCORE1 + SCORE2) / (double) NUMBER;  //Casting the int variable NUMBER to a double, so the average gives a floating point value
		output = SCORE1 + " and " + SCORE2 + " have an average of "
				+ average;
		System.out.println(output);

		// Convert Fahrenheit temperatures to Celsius
		fToC = ((double)5/9)* (BOILING_IN_F - 32);  //Casting the integer 5 to a double, so the result gives a floating point value
		output = BOILING_IN_F + " in Fahrenheit is " + fToC
			     + " in Celsius.";
		System.out.println(output);
		System.out.println();		// to leave a blank line

		
		// ADD LINES FOR TASK #2 HERE
		
		// prompt the user for first name
		// read the user's first name
		firstName = JOptionPane.showInputDialog("Please enter your first name: "); 
		
		// prompt the user for last name
		// read the user's last name
		lastName = JOptionPane.showInputDialog("Please enter your last name: "); 
		
		// concatenate the user's first and last names
		fullName = firstName + " " + lastName;
		
		// print out the user's full name in a message dialog box
		JOptionPane.showMessageDialog(null, "Your full name is " + fullName + "."); 
		
		
		// ADD LINES FOR TASK #3 HERE
		
		// get the first character from the user's first name
		firstInitial = firstName.charAt(0);
		// print out the user's first initial
		System.out.println(firstInitial);
		// convert the user's full name to all capital letters
		fullName = fullName.toUpperCase();
		// print out the user's full name in all capital letters
		System.out.println(fullName);
		// get the value of the users full name and how many characters are in it.
		stringSize = fullName.length();
		//print out the value of the users full name and how many characters are in it.
		System.out.println(stringSize);
		
		System.out.println();		// to leave a blank line
		
		
		// ADD LINES FOR TASK #4 HERE
		
		// prompt the user for a diameter of a sphere
		System.out.print("Please enter the diameter of a sphere: ");
		// read the diameter
		diameter = keyboard.nextDouble();
		// calculate the radius
		radius = (diameter/ 2);
		// calculate the volume 
		volume = ((double)4 / 3) * Math.PI * Math.pow(radius, 3);
		// print out the volume
		System.out.println("The volume of the sphere is " + volume + ".");
		
		System.exit(0); 
	}
}




