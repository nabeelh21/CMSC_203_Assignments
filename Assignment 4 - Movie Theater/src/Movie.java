/**
* This class will hold the information of a movie, and also calculate the movies average review.  
* @author Nabeel Hussain 
*/ 

public class Movie {
	
	private String movieTitle;                      // Declares an instance variable for a movies title
	private String rating;                          // Declares an instance variable for a movies rating
	private int [] movieReviews = new int [10];     // Declares an instance variable for an int[] array, holding a movies reviews
	int nSoldTickets;                               // Declares an instance variable for a movies number of tickets sold. 
	double avgReviews;                              // Declares a variable to hold a movies average review. 
	
	/**
	 * A constructor for the Movie class. It will store a movies information. 
	 * @param title movie title
	 * @param movieRating movie rating
	 * @param reviews  an int[] array of 10 reviews of the movie
	 * @param nSoldTickets number of tickets sold for the movie
	 */
	public Movie(String title, String movieRating, int[] reviews, int numSoldTickets)
	{
		movieTitle = title;
		rating = movieRating;
		movieReviews = reviews;
		nSoldTickets = numSoldTickets ;	
	}
	
	/**
	 * A copy constructor for the Movie class.
	 * @param info a Movie object variable, containing the movies information
	 */
	public Movie( Movie info)
	{
		movieTitle = info.movieTitle;
		rating = info.rating;
		movieReviews = info.movieReviews;
		nSoldTickets = info.nSoldTickets;				
	}
	
	/**
	 * Will calculate and return a movies average review from its int[] array of reviews.  
	 * @return the average review of the movie
	 */
	public double getAvgReview()
	{
		double total = 0;
		
		for(int i = 0; i < movieReviews.length; i++)
		{
			total += movieReviews[i];
			
			avgReviews = total/ movieReviews.length;
		}	
		
		return avgReviews;
	}
	
	/**
	 * Will return a movies title  
	 * @return the movies title
	 */
	public String getMovieTitle()
	{
		return movieTitle;
	}
	
	/**
	 * Will return a movies number of tickets sold  
	 * @return the number of tickets sold for a movie
	 */
	public int getnSoldTickets()
	{
		return nSoldTickets;
	}
}











