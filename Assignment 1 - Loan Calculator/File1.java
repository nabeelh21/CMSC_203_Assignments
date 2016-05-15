/**
* This program will calculate a monthly loan re-payment amount for a user,
depending on the starting amount of the loan, interest rate, and the number of payments desired.
 
* Name: Nabeel Hussain
* Class: CMSC203
* Professor: Jeannette Myers Kartchner
* Assignment 1: Loan Calculator
* Date: 09/03/2015
*/

// Import statement to use the Scanner class
import java.util.Scanner;

// Import statement to use the Math class for the the math.pow function in the loan calculation.
import java.lang.Math;


// The class is named File1 for this first assignment.
public class File1 {

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		double loanAmount;    // Declares variable for the loan amount user wants payments for. 
		double interestRate;  // Declares variable for the interest rate being used to calculate the payments. 
		double nPayments;     // Declares variable for the number of payments desired.
		double payment;       // Declares variable that will show how much the user will pay monthly for the loan. 
		final double NUM_MONTHS_IN_YEAR = 12;  // Constant variable for the number of months in a year. 
		
		// Title of the Loan Calculator 
		System.out.println("Loan Caluculator");
		System.out.println();   // to leave a blank line
		System.out.println();   // to leave a blank line
		
		// Asks user to input loan amount.
		System.out.print("Please enter the loan amount you want calculated: ");
		loanAmount = keyboard.nextDouble();
		
		// Reminds the user that the loan amount must be greater than 0, and keeps asking them until a positive number is entered. 
		while(loanAmount <= 0)
		{
			System.out.print("You must enter a loan amount greater than 0. Please try again: ");
			loanAmount = keyboard.nextDouble();
		}
		
		// Asks user to input the interest rate that will be used.
		System.out.print("Please enter the interest rate: ");
		interestRate = keyboard.nextDouble();
		
		// Reminds the user that the interest rate must be greater than 0, and keeps asking them until a positive number is entered.
		while(interestRate <= 0)
		{
			System.out.print("You must enter an interest rate greater than 0. Please try again: ");
			interestRate = keyboard.nextDouble();
		}
		// divides the interest rate by 100 to receive the decimal form of the interest rate. 
		interestRate /= 100;
		
		// Asks user to input the number of payments they want to have in order to payback the loan. 
		System.out.print("Please enter the number of payments you would like: ");
		nPayments = keyboard.nextDouble();
		
		// Reminds the user to enter a number greater than 0, and keeps asking them until a positive number is entered.
		while(nPayments <= 0)
		{
			System.out.print("The number of payments must be greater than 0. Please try again:  ");
			nPayments = keyboard.nextDouble();
		}
		
		// Calculates the loan payment amount in monthly payments, using the equation given in the instructions. 
		payment = loanAmount * ( (interestRate/NUM_MONTHS_IN_YEAR) / ( 1 - (Math.pow((1 + (interestRate/NUM_MONTHS_IN_YEAR)), -nPayments))));
		
		// Displays the Payment amount to the user. 
		System.out.println();  // to leave a blank line
		System.out.println("Total monthly payment for a loan of $" + loanAmount + " is: $" + payment + "." );
	}
}
