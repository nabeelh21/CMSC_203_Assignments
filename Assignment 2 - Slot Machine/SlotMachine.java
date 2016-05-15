/**
* This assignment is to create a Java program that simulates a slot machine.
* Get the amount to be bet as input from the user, and then display the output of the randomly
* selected words from the spin. Depending on the matches of the output, display the
* prize amount won, total amount that has been bet so far, and the total amount won so far.  
*   
* Name: Nabeel Hussain
* Class: CMSC203
* Professor: Jeannette Myers Kartchner
* Assignment 2: Slot Machine
* Date: 09/15/2015
*/
import java.util.Random;
import java.util.Scanner;
 

public class SlotMachine
{
	public static void main (String [] args)
	{
		Scanner keyboard = new Scanner(System.in);
		Random random = new Random();
		SlotMoneyTracker amount = new SlotMoneyTracker();
				
		double bettingAmount;
		char playAgain;
		
		String results;
		final int OUTPUT_SIZE = 4;
		String[] output =  new String[OUTPUT_SIZE];  //Declare an array that will hold the 4 randomly selected words representing the images of the slot machine output.
		
		//I am using do-while statement to execute the slot machine program at least once,
		// and then keeping executing it, as long as the user wants to keep playing.
		do
		{
			System.out.println("Slot Machine ");
			System.out.println();
			
			// Ask the user how much they want to bet
			System.out.print("Enter your betting amount: ");
			bettingAmount = keyboard.nextDouble();
			
			// If the amount entered is below $1 or above $20, ask the user to re-enter until an acceptable bid is entered. 
			while(bettingAmount < 1 || bettingAmount >20)
			{
				System.out.print("You must enter a bid between $1 and $20. Please re-enter: ");
				bettingAmount = keyboard.nextDouble();
			}
			
			
			// Randomly pick a number between 0-6, and depending on the number that is selected, then assign it with one of the 7 words in the slot machine.
			// If 0 (Cherry), 1 (Orange), 2 (Plum), 3 (Bell), 4 (Melon), 5 (Bar), 6 (Lucky 7).
			// Perform this 4 times, so there are 4 randomly chosen words each time the program executes. 
			for(int count = 0; count < 4; count ++)
			{
				
				if (random.nextInt(7) == 0)
					results = "Cherry";
				   
				else if (random.nextInt(7) == 1)
					results = "Orange";
				   
				else if (random.nextInt(7) == 2)
					results = "Plum";
						
				else if (random.nextInt(7) == 3)
					results = "Bell";
					
				else if (random.nextInt(7) == 4)
					results = "Melon";
					
				else if (random.nextInt(7) == 5)
					results = "Bar";
					
				else
					results = "Lucky 7";
				
				//Place the randomly picked word in the array called output, and keep adding to it each time the loop repeats, resulting in 4 words in the array.
				output[count] = results;
			}
			
			//Display each word in the array next to each other, which will represent the slot machine displaying the 4 images during each spin.   
			System.out.print(output[0] + ", " + output[1] + ", " + output[2] + ", " + output[3]);
			System.out.println();
			
			// Uses the SlotMoneyTracker Class that I created, and the results method in it, to calculate the
			// winning prize amount for the current spin, depending on the randomly chosen words displayed. 
			amount.results(bettingAmount, output);
			
			// Uses the SlotMoneyTracker Class that I created, and the totalBetted method in it, to
			// calculate a running total of the total amount bet since the user started playing. Keeps 
			// adding for as long as the user wishes to play. 
			amount.totalBetted(bettingAmount);
			
			// Uses the SlotMoneyTracker Class that I created, and the totalWinnings method in it, to
			// calculate a running total of the total amount won since the user started playing. Keeps
			// adding for as long as the user wishes to play. 
			amount.totalWon(amount.getPrizeMoney());
			
			System.out.println();
			
			// Display the amount won during the current spin, formatted to 2 decimal places. 
		    System.out.printf( "You win $%.2f \n", amount.getPrizeMoney());
		    // Display the total amount bet so far, since the user started playing, formatted to 2 decimal places. 
		    System.out.printf( "The total amount you have bet so far is: $%.2f \n", amount.getTotalBetted());
		    // Display the total amount won so far, since the user started playing, formatted to 2 decimal places.
		    System.out.printf( "The total amount you have won so far is: $%.2f \n", amount.getTotalWon());
		    System.out.println();
	
		    // Ask the user if they want to play again.
		    System.out.println("Do you want to play again? (Y/N)");
		    System.out.print("Enter Y for yes or N for no: ");
		    String input = keyboard.next(); // Read a string.
		    // Read the first letter in the users response, and if it's a 'Y' or 'y', then assign it to the char variable playAgain. 
		    playAgain = input.charAt(0); // Get the first character.
		    
		    System.out.println();
		    System.out.println();
		
		}
		
		//Keep repeating the program for as long as the user chooses to play again.
		while (playAgain == 'Y' || playAgain == 'y');

	}
}
