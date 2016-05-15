
/**
* This class will hold the calculations in order for the  movie theater application to perform its functions. It will hold each movies information,
* find which movie(s) have the highest and lowest average review, find out which movie(s) sales have increased from the previous week, and find the totals tickets
* sold for all the movies in a list.  
* @author Nabeel Hussain 
*/ 

import javax.swing.JOptionPane;
import java.util.ArrayList;


public class MovieTheater
{
	private ArrayList<Movie> information = new ArrayList<>();           // Declares an instance variable of an ArrayList of Movie, to hold all the movies information
	private ArrayList<Double> averageMovieReviews = new ArrayList<>();  // Declares an instance variable of an ArrayList of Double, to hold all the movies avg reviews.
	int totalSaleAmount;      // Declares a variable to hold the total tickets sold for all the movies in a list. 
	
	/**
	 * Will add a movies information into an ArrayList of type Movie
	 * Will also add the corresponding movies average review into an ArrayList of type Double. 
	 * @param x contains the information of a movie 
	 */
	public void addMovies( Movie x) 
	{
		// Add the information of a movie that is passed into from the parameter, into the ArrayList of Movie. 
		information.add(x);
		// Add the corresponding movies avg review, by calling the getAvgReview() method in the Movie class. 
		averageMovieReviews.add(x.getAvgReview());	
	}
	
	/**
	 * Will find the highest and lowest review of a movie in the movie list,
	 * and then display the movie(s) with the highest and lowest avg review in a JOptionPane box.   
	 * 
	 */
	public void highestAndLowestReview() 
	{
		// Find the highest average value
		// Start by assigning the highest average review to the first element in the ArrayList of Double. 
		double highest = averageMovieReviews.get(0);
		//For each element in the ArrayList of Double,if the current element is greater then the previous element, then assign it as the highest value. 
		for (int i = 1; i < averageMovieReviews.size(); i++)
		{
			if( averageMovieReviews.get(i) > highest)
			{
				highest = averageMovieReviews.get(i);
			}
		}
		//Finds the lowest average value
		// Start by assigning the lowest average review to the first element in the ArrayList of Double.
		double lowest = averageMovieReviews.get(0);
		//For each element in the ArrayList of Double,if the current element is less then the previous element, then assign it as the lowest value.
		for (int i = 1; i < averageMovieReviews.size(); i++)
		{
			if( averageMovieReviews.get(i) < lowest)
			{
				lowest = averageMovieReviews.get(i);
			}
		}
		
		// Declares variables to hold the movie(s) title with the highest and lowest avg review. 
		String highestReviewedMovies = ""; 
		String lowestReviewedMovies = "";
		
		//Finds the movies that contain the highest average and adds them to the highestReviewedMovies String variable.  
		for (int i = 0; i < information.size(); i++)
		{
			if (information.get(i).getAvgReview() == highest)
			{
				highestReviewedMovies += information.get(i).getMovieTitle() + ", ";
			}	
		}
				
		//Finds the movies that contain the lowest average and adds them to the lowestReviewedMovies String variable. 
		for (int i = 0; i < information.size(); i++)
		{
			if (information.get(i).getAvgReview() == lowest)
			{
				lowestReviewedMovies += information.get(i).getMovieTitle() + ", ";
			}	
		}
		
		// Displays the highest and lowest rated movie(s) title in a JOptionPane box. 
		JOptionPane.showMessageDialog(null,"Movies with the highest Average review of " + highest + ":\n"
					+ highestReviewedMovies +  "\nMovies with the lowest Average review of " + lowest + ":\n"
					+ lowestReviewedMovies);
	}
	
	/**
	 * Will compare the total tickets sold for each movie, from the previous week to the current week, and then display the 
	 * movie(s) that had an increase in the number of tickets sold. 
	 * @param prevWeekTicketsSold holds the number of tickets sold for each movie in the previous week, in an ArrayList of Double. 
	 */
	public void compareSales(ArrayList<Double> prevWeekTicketsSold) 
	{
		String increaseInSale = "";
		
		// For each element in the ArrayList of Movie, if the currents week sold tickets for a movie is greater then its previous weeks amount,
		// then add the movies title to the increaseInSale String variable. 
		for (int i = 0; i < information.size(); i++)
		{
			if (information.get(i).getnSoldTickets() > prevWeekTicketsSold.get(i))
			{
				increaseInSale += (information.get(i).getMovieTitle()) + "\n";
			}
		}
		
		// Displays the movie(s) with an increase in ticket sales in a JOptionPane box.
		JOptionPane.showMessageDialog(null,"Sale for the following movie(s) have increased: \n"
				+ increaseInSale );
	}
	
	/**
	 * Will calculate and return the total number of tickets sold of all the movies in the ArrayList of Movie.  
	 * @return the total number of tickets sold of all the movies 
	 */
	public int getTotalSale() 
	{
		totalSaleAmount = 0;
		
		// Will add the number of tickets sold for all the movies contained in the ArrayList of Movie.
		for (int i = 0; i < information.size(); i++)
		{
			totalSaleAmount +=  information.get(i).getnSoldTickets();
		}
		
		return totalSaleAmount;	
	}
}
	


