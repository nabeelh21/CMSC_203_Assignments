/**
* This is a class that I created, called SlotMoneyTracker, which keeps track of all the money bet and won
* by the user, while playing the game. It also keeps track of the different payouts of the slot machine, depending
* on the spin results.
*/
public class SlotMoneyTracker {
	
	private double totalAmountWon;
	private double totalAmountBet;
	private double prizeWon;
	
	// Will store the users bet amount during the spin, to the total of the previous spins, in the totalAmountBet field. 
	public void totalBetted(double amount)
	{
		totalAmountBet += amount;
	}
	
	// Will store the users prize amount won during the spin, to the total prize winnings from the previous spins, in the totalAmountWon field.
	public void totalWon(double amountWon)
	{
		totalAmountWon += amountWon;
	}
	
	// Will return the value stored in the totalAmountBet field. 
	public double getTotalBetted()
	{
		return totalAmountBet;
	}
	
	// Will return the value stored in the totalAmountWon field.
	public double getTotalWon()
	{
		return totalAmountWon;
	}
	
	// Calculates the prize payout for the slot machine, depending on the matches of the words that are randomly display, and stores it in the prizeWon field. 
	public void results(double amount, String[] images)
	{	
		// If all four words that represent the images in the slot machine, are the same, then calculate 8 times the amount bet.
		// However, If all the 4 words are "Lucky 7" then calculate 8 times the amount bet plus $1,000 bonus.
		if(images[0].equals(images[1]) && images[0].equals(images[2]) && images[0].equals(images[3]))
		{
			if( images[0].equals("Lucky 7") && images[1].equals("Lucky 7") && images[2].equals("Lucky 7") && images[3].equals("Lucky 7"))
			{
				System.out.println("You hit the grand prize! You got all 4 words that say Lucky 7, and have won 8 times the amount you bet plus a $1,000 bonus.");				
				prizeWon = amount*8 + 1000;
			}
			else
			{
				System.out.println("You got all 4 words that match, and have won 8 times the amount you bet.");				
				prizeWon = amount*8;
			}
		}
		// If three of the words are matching in a row, then calculate 3 times the amount bet. 
		else if((images[0].equals(images[1]) && images[0].equals(images[2])) ||
				(images[1].equals(images[2]) && images[2].equals(images[3])))
		{
			System.out.println("You got 3 words that match, and have won 3 times the amount you bet. ");				
			prizeWon = amount*3;
		}
		// if two of the images match and are in a row, then the user wins back the amount they bet.
		// However, if there are two pairs of words that match and are in a row, then calculate twice the amount the user bet. 
		else if(images[0].equals(images[1]) || images[1].equals(images[2]) || images[2].equals(images[3]) )
		{
			if(images[0].equals(images[1]) && images[2].equals(images[3]))
			{
				System.out.println("You got 2 pairs of words that match, and have doubled the amount you bet.");				
				prizeWon = amount*2;		
			}
			else
			{
				System.out.println("You got 1 pair of words that match, and have won back the amount you bet.");
				prizeWon = amount*1;
			}
		}
		// If none of the words match in a row, then the user loses the amount they bet. 
		else
		{
			System.out.println("There is no match. You have lost your bet.");
			prizeWon = amount*0;
		}
	}
	// Will return the value stored in the prizeWon field. 
	public double getPrizeMoney()
	{
		return prizeWon;
	}

}

