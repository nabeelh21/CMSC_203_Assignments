/**
* This program will calculate gas mileage in Miles per gallon. 
* 
* Name: Nabeel Hussain
* Class: CMSC203
* Professor: Jeannette Myers Kartchner
* Chapter 2 Lab - Tasks 5 & 6
* Date: 09/07/2015
*/

// Import statement to use the Scanner class
import java.util.Scanner;


// The class header is called Mileage. 
public class Mileage {

	public static void main(String[] args) {
		
		//Creating a Scanner object here
		Scanner keyboard = new Scanner(System.in);
		
		double miles;     // Declares variable to hold the number of miles the user has driven
		double gallons;   // Declares variable to hold the amount of gas used by the user
		double mpg;       // Declares variable to hold the miles per gallons
		
		//Title of the Program
		System.out.println("Gas Mileage Calculator");
		System.out.println();  // to leave a blank line
		
		//Asks user to enter the number of miles driven
		System.out.print("How many miles have you driven: ");
		miles = keyboard.nextDouble();
		
		//Asks the user to enter the amount of gas used
		System.out.print("How many gallons of gas have you used: ");
		gallons = keyboard.nextDouble();
		
		//Calculates the mile per gallon by dividing miles driven by gallons used. 
		mpg = miles/gallons;
		
		//prints the mpg to the user
		System.out.println("Your car is giving you " + mpg + " miles per gallon.");

	}

}
