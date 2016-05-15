/**
 * This program will implement a GUI application for displaying movie information, and also contain buttons to compare them with each other.  
 * 
 * Name: Nabeel Hussain
 * Class: CMSC203
 * Professor: Jeannette Myers Kartchner
 * Assignment 4 - Movie Theater
 * Date: 10/15/2015
 * 
 * @author Nabeel Hussain
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javax.swing.JFileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class ipicMovieTheater extends Application {
	
	Label titleLabel;                // Declares variable to hold the label for the title of the application
	Label movieNameLabel;            // Declares variable to hold the label for the movie name column
	Label movieRatingLabel;          // Declares variable to hold the label for the movie rating column
	Label movieReviewsLabel;         // Declares variable to hold the label for the movie reviews column
	Label avgOfReviewsLabel;         // Declares variable to hold the label for the movies averageg review.
	Label nTicketsSoldLabel;		 // Declares variable to hold the label for the number of tickets sold column
	Label totalTicketsSoldLabel;	 // Declares variable to hold the label for the total tickets sold for all the movies. 
	
	int ROWS = 20;
	TextField [] movieNameTextField = new TextField [ROWS];       // Declares an array variable to hold the textfields for the movies   
	TextField [] movieRatingTextField = new TextField [ROWS];     // Declares an array variable to hold the textfields for the movie ratings
	TextField [] movieReviewsTextField = new TextField [ROWS];    // Declares an array variable to hold the textfields for the movie reviews      
	TextField [] avgOfReviewsTextField = new TextField [ROWS];    // Declares an array variable to hold the textfields for the movies average review
	TextField [] nTicketsSoldTextField = new TextField [ROWS];    // Declares an array variable to hold the textfields for the movies number of tickets sold 
	TextField totalTicketsSoldTextField;                         // Declares a variable to hold the textfields for the total tickets sold for all the movies
	
	
	Button loadMoviesButton;   // Declares variable to hold the "Load Movies" button
	Button reviewsButton;      // Declares variable to hold the "High/Low Reviews" button
	Button compareButton;      // Declares variable to hold the "Compare" button
	Button totalSaleButton;    // Declares variable to hold the "Total Sale" button
	Button exitButton;         // Declares variable to hold the "Exit" button
	
	
	MovieTheater stats = new MovieTheater( );                 // An instance of the MovieTheater class, to be used to execute the program.
	ArrayList<String> dataCurrent = new ArrayList<>();        // An ArrayList that will hold the content read in from currWeekSale.txt
	ArrayList<Movie> movieInfo = new ArrayList<>();           // An ArrayList of Movie that will hold the information for the movies. 
	ArrayList<String> dataPrevious = new ArrayList<>();       // An ArrayList that will hold the content read in from prevWeekSale.txt
	ArrayList <Double> prevWeekTickets = new ArrayList<>();   // An ArrayList of Double that will hold the number of tickets sold in the previous week for the movies
	
	//Creating an instance of the NumberFormat class, so I can format the total number of movie tickets sold, to incorporate commas in them. 
	NumberFormat defaultFormat = NumberFormat.getNumberInstance();
	
	/**
	 * Sets the layout of the GUI, with all the labels, textfields, and buttons that the movie theater application
	 * will need to perform all its functions. 
	 */
	@Override
	public void start(Stage stage)
	{
		// Create label for the title of the application. Set the color of the text to blue, and the size of the font to 30 px. 
		titleLabel = new Label("iPic Theater Weekly Movie Information");
		titleLabel.setTextFill(Color.BLUE);
		titleLabel.setFont(new Font(30));
		
		// Create labels for the input fields		
		movieNameLabel = new Label("NAME");		
		movieRatingLabel = new Label("RATE");		
		movieReviewsLabel = new Label("REVIEWS");		
		avgOfReviewsLabel = new Label("AVERAGE");
		nTicketsSoldLabel = new Label("SOLD TICKETS");
		totalTicketsSoldLabel = new Label("Total");
		
		// Using a for loop to create the textfields for the labels for each row of the GUI display.
		// Also make sure that all the textfields are non-editable.
		for (int i = 0; i < ROWS; i++)
		{
			movieNameTextField[i] = new TextField();
			movieNameTextField[i].setPrefWidth(350);
			
			movieRatingTextField[i] = new TextField();
			movieRatingTextField[i].setPrefWidth(100);
			
			movieReviewsTextField[i] = new TextField();
			movieReviewsTextField[i].setPrefWidth(160);
			
			avgOfReviewsTextField[i] = new TextField();
			avgOfReviewsTextField[i].setPrefWidth(50);
			
			nTicketsSoldTextField[i] = new TextField();
			nTicketsSoldTextField[i].setPrefWidth(140);
			
			movieNameTextField[i].setEditable(false);
			movieRatingTextField[i].setEditable(false);
			movieReviewsTextField[i].setEditable(false);
			avgOfReviewsTextField[i].setEditable(false);
			nTicketsSoldTextField[i].setEditable(false);
		}
		
		// Creating a textfield for total tickets sold label. 
		totalTicketsSoldTextField = new TextField();
		totalTicketsSoldTextField.setPrefWidth(163);
		totalTicketsSoldTextField.setEditable(false);
		
		// Create the buttons for the movie theater GUI 
		loadMoviesButton = new Button("Load Movies");		
		reviewsButton = new Button("High/Low Reviews");		
		compareButton = new Button("Compare");		
		totalSaleButton = new Button("Total Sale");		
		exitButton = new Button("Exit");	
		
		// Start the program with only the "Load" Movie and "Exit" buttons enabled, while the rest are disabled. 
		reviewsButton.setDisable(true);
		compareButton.setDisable(true);
		totalSaleButton.setDisable(true);
		
		// Sets event handlers on each button, which will perform different actions, depending on which button the user clicks. 
		loadMoviesButton.setOnAction(new LoadMoviesButtonEventHandler());
		reviewsButton.setOnAction(new ReviewsButtonEventHandler());
		compareButton.setOnAction(new CompareButtonEventHandler());
		totalSaleButton.setOnAction(new TotalSaleButtonEventHandler());
		exitButton.setOnAction(new ExitButtonEventHandler());
		
		
		// Create a horizontal box that will hold the title of the movie theater application. 
		HBox guiTitle = new HBox(5);
		guiTitle.setAlignment(Pos.CENTER);
		guiTitle.setPadding(new Insets(5, 0, 0, 0));
		// Add the title to the children of the guiTitle horizontal box
		guiTitle.getChildren().addAll(titleLabel);
		
		
		// Create a vertical box that will hold all the textfields for the movie names.
		VBox movieNameFields = new VBox(3);
		movieNameFields.setAlignment(Pos.CENTER);
		// A for loop to add the  movie name textfields to the children of the movieNameFields vertical box
		for(int i = 0; i < ROWS; i++)
		{
			movieNameFields.getChildren().addAll(movieNameTextField[i]);
		}
		// Create a vertical box that will contain the movie name label on top, followed by the movie name textfields.   
		VBox movieNameColumn = new VBox(5);
		movieNameColumn.setAlignment(Pos.CENTER_LEFT);
		// Add the  movie name label and textfields to the children of the movieNameColumn vertical box
		movieNameColumn.getChildren().addAll(movieNameLabel, movieNameFields );
			
		
		// Create a vertical box that will hold all the textfields for the movie ratings
		VBox movieRatingFields = new VBox(3);
		movieRatingFields.setAlignment(Pos.CENTER);
		// A for loop to add the movie rating textfields to the children of the movieRatingFields vertical box
		for(int i = 0; i < ROWS; i++)
		{
			movieRatingFields.getChildren().addAll(movieRatingTextField[i]);
		}
		// Create a vertical box that will contain the movie rating label on top, followed by the movie rating textfields. 
		VBox movieRatingColumn = new VBox(5);
		movieRatingColumn.setAlignment(Pos.CENTER_LEFT);
		// Add the movie rating label and textfields to the children of the movieRatingColumn vertical box
		movieRatingColumn.getChildren().addAll(movieRatingLabel, movieRatingFields );	
		
		
		// Create a vertical box that will hold all the textfields for the movie reviews.
		VBox movieReviewsFields = new VBox(3);
		movieReviewsFields.setAlignment(Pos.CENTER);
		// A for loop to add the movie reviews textfields to the children of the movieReviewsFields vertical box
		for(int i = 0; i < ROWS; i++)
		{
			movieReviewsFields.getChildren().addAll(movieReviewsTextField[i]);
		}
		// Create a vertical box that will contain the movie reviews label on top, followed by the movie reviews textfields. 
		VBox movieReviewsColumn = new VBox(5);
		movieReviewsColumn.setAlignment(Pos.CENTER_LEFT);
		// Add the movie reviews label and textfields to the children of the movieReviewsColumn vertical box
		movieReviewsColumn.getChildren().addAll(movieReviewsLabel, movieReviewsFields );
		
		
		// Create a vertical box that will hold all the textfields for the movie review averages.
		VBox avgOfReviewsFields = new VBox(3);
		avgOfReviewsFields.setAlignment(Pos.CENTER);
		// A for loop to add the movie review avg textfields to the children of the avgOfReviewsFields vertical box
		for(int i = 0; i < ROWS; i++)
		{
			avgOfReviewsFields.getChildren().addAll(avgOfReviewsTextField[i]);
		}
		// Create a vertical box that will contain the movies avg review label on top, followed by the movies avg review textfields.
		VBox avgOfReviewsColumn = new VBox(5);
		avgOfReviewsColumn.setAlignment(Pos.CENTER_LEFT);
		// Add the movie review avg label and textfields to the children of the avgOfReviewsColumn vertical box
		avgOfReviewsColumn.getChildren().addAll(avgOfReviewsLabel, avgOfReviewsFields );				
		
		
		// Create a vertical box that will hold all the textfields for the number of tickets sold of each movie.
		VBox nTicketsSoldFields = new VBox(3);
		nTicketsSoldFields.setAlignment(Pos.CENTER);
		// A for loop to add the number of tickets sold textfields to the children of the nTicketsSoldFields vertical box
		for(int i = 0; i < ROWS; i++)
		{
			nTicketsSoldFields.getChildren().addAll(nTicketsSoldTextField[i]);
		}
		// Create a vertical box that will hold the movies nTicketsSold label on top, followed by the movies nTicketsSold textfields.
		VBox nTicketsSoldColumn = new VBox(5);
		nTicketsSoldColumn.setAlignment(Pos.CENTER_LEFT);
		// Add thenumber of tickets sold label and textfields to the children of the nTicketsSoldColumn vertical box
		nTicketsSoldColumn.getChildren().addAll(nTicketsSoldLabel, nTicketsSoldFields );				
		
		
		// Create a Horizontal box to nest all the VBox panes that were created for the columns of the movie name, movie rating, movie review,
		// movies avg review, and number of tickets sold.
		HBox tablePane = new HBox(15);
		tablePane.setAlignment(Pos.CENTER);
		tablePane.getChildren().addAll(movieNameColumn, movieRatingColumn, movieReviewsColumn, avgOfReviewsColumn, nTicketsSoldColumn);
		
		// Create a horizontal box that will hold the label and textfield for the totalTicketsSold of all the movies.
		HBox totalTicketsPane = new HBox(5);
		totalTicketsPane.setAlignment(Pos.CENTER);
		totalTicketsPane.setPadding(new Insets(0, 0, 0, 670));
		// Add the total tickets sold label and textfield to the children of the totalTicketsPane horizontal box
		totalTicketsPane.getChildren().addAll(totalTicketsSoldLabel, totalTicketsSoldTextField);
		
		// Create a horizontal box, that will place the buttons next to each other.
		HBox buttonPane = new HBox(20);
		buttonPane.setAlignment(Pos.CENTER);
		// Add the buttons to the children of the buttonPane horizontal box
		buttonPane.getChildren().addAll(loadMoviesButton,reviewsButton,compareButton,totalSaleButton,exitButton);			
				
		// Create a vertical box that will nest the tablePane on top, followed by the totalTicketsPane, followed by the buttonPane. 
		VBox contentPane = new VBox(30);
		contentPane.setAlignment(Pos.CENTER);
		// Add the inputPane and buttonPane into the contentPance vertical box.
		contentPane.getChildren().addAll(tablePane,totalTicketsPane, buttonPane);
		
		// Create a BorderPane to place the labels, textfields, and buttons, which have been stored in the contentPane 
		BorderPane displayPane = new BorderPane();
		// Place contentPane in the center region of the BorderPane.
		displayPane.setTop(guiTitle);
		displayPane.setCenter(contentPane); 
		
		// Set displayPane as root of scene and set the scene on the stage
		Scene scene = new Scene(displayPane, 1000, 900);
		stage.setTitle("ipic Theater");
		stage.setScene(scene);
		stage.show();	
	}
	
	// 
	class LoadMoviesButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// Will display a window box allowing the user to select a file from their computer to open, in order to read its data. 
			JFileChooser fileChooser = new JFileChooser();
			int status = fileChooser.showOpenDialog(null);
			if (status == JFileChooser.APPROVE_OPTION)
			{
				File selectedFile = fileChooser.getSelectedFile();
				String filename = selectedFile.getPath();
				JOptionPane.showMessageDialog(null, "You selected " + filename);
				
				try
				{

					Scanner inputFile = new Scanner(selectedFile);
					
					// Read each content, line by line from the .txt file into a String ArrayList
					while (inputFile.hasNext())
					{	
						dataCurrent.add(inputFile.nextLine());
					}
					
					// Place the data read from the .txt file into the appropriate textfields of the GUI. 
					for( int i = 0, y = 0; y < dataCurrent.size()/4; i +=4, y++)
					{
						//Every 4th line starting from the first line of the .txt will be a movie name.
						movieNameTextField[y].setText(String.valueOf(dataCurrent.get(i)));
						//Every 4th line starting from the second line of the .txt file will be the movies rating.
						movieRatingTextField[y].setText(String.valueOf(dataCurrent.get(i + 1)));
						//Every 4th line starting from the third line of the .txt file will be the movies reviews.
						movieReviewsTextField[y].setText(String.valueOf(dataCurrent.get(i + 2)));
						//Every 4th line starting from the 4th line of the .txt file will be the movies number of tickets sold amount.
						nTicketsSoldTextField[y].setText(String.valueOf(dataCurrent.get(i + 3)));
						
						// Get the movie name from the String ArrayList and place it into a string variable. 
						String movieName = dataCurrent.get(i);
						// Get the movie rating from the String ArrayList and place it into a string variable.
						String movieRating = dataCurrent.get(i + 1);
						
						// Get the movie reviews from the String ArrayList and place it into a string variable.
						String movieReviews = dataCurrent.get(i + 2);
						// Split the string into separate string numbers, using the " " to distinguish between each review.
						// Place each review into a string array.
				        String[] reviews = movieReviews.split(" ");
				        // Parse the String array of the 10 reviews into an int array
				        int[] results = new int[reviews.length];
				        
				        for (int m = 0; m < reviews.length; m++)
				        {
				            try
				            {
				                results[m] = Integer.parseInt(reviews[m]);
				            } 
				            catch (NumberFormatException nfe) {};
				        }
				        
				        // Get the number of tickets sold from the String ArrayList and place it into a string variable.  
						String nTicketsSold = dataCurrent.get(i + 3);
						// Parse the String number into an int. 
						int nTickets = Integer.parseInt(nTicketsSold);
						
						// Create an instance of the Movie object using the parameters String movieName, String movieRating, int[] results,
						// and int nTickets of each movie of the current iteration of the loop. 
						Movie m = new Movie(movieName, movieRating, results, nTickets);
						
						// Add the movies information into the ArrayList of Movie, during each iteration of the loop. 
						movieInfo.add(m);
						
						// Place the movies average review in the avgOfReviewsTextField in the GUI, for the current iteration of the loop of a movie. 
						avgOfReviewsTextField[y].setText(String.valueOf(m.getAvgReview()));
						
						//Using the instance of the MovieTheater class, add the information of the movie during the current iteration
						// of the loop, into an ArryList of type Movie. 
						stats.addMovies(m);
					}
					// Close the .txt file that was opened. 
					inputFile.close();
				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();		
				}
				
				// Once the load movies button is pressed, enable the rest of the buttons.   
				reviewsButton.setDisable(false);
				compareButton.setDisable(false);
				totalSaleButton.setDisable(false);
			}
		}
	}
	
	// Will display the movie(s) that had the highest average review and lowest average review. 
	class ReviewsButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{ 
			// Call the highestAndLowestReview() method from the MovieTheater class to display the movie(s) that had the highest and lowest avg review.
			stats.highestAndLowestReview();	
		}
	}
	
	// Will compare the total tickets sold for each movie, from the previous week to the current week, and then display the 
	// movie(s) that had an increase in the number of tickets sold. 
	class CompareButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			ArrayList <Double> prevWeekTickets = new ArrayList<>();
			
			// Will display a window box allowing the user to select a file from their computer to open, in order to read its data.
			JFileChooser fileChooser = new JFileChooser();
			int status = fileChooser.showOpenDialog(null);
			if (status == JFileChooser.APPROVE_OPTION)
			{
				File selectedFile = fileChooser.getSelectedFile();
				String filename = selectedFile.getPath();
				JOptionPane.showMessageDialog(null, "You selected " + filename);
				try
				{
					Scanner inputFile = new Scanner(selectedFile);
					
					// Read each content, line by line from the .txt file into a String ArrayList called dataPrevious
					while (inputFile.hasNext())
					{	
						dataPrevious.add(inputFile.nextLine());
					}
					
					// Convert the string contents in the dataPrevious ArrayList into a type Double number,
					// and then add that number into a ArrayList of type Double, called prevWeekTickets
					for( int i = 0; i < dataPrevious.size(); i +=2)
					{      
						String nTicketsSold = dataPrevious.get(i + 1);
						double nTickets = Double.parseDouble(nTicketsSold);
						
						prevWeekTickets.add(nTickets);
					}

					inputFile.close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();		
				}
				
				// Call the compareSales method from the MovieTheater class to display the movies that had an increase in tickets sold from the previous week. 
				stats.compareSales(prevWeekTickets);
			}
		}
	}
	
    // Will add all the tickets sold for the movies in the list, and then display it in the total tickets sold textfield.  
	class TotalSaleButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// Call the getTotalSale() method from the MovieTheater class to display the sum of the tickets sold of all the movies in the list.
			// Add the total to the totalTicketsSoldTextField.
			totalTicketsSoldTextField.setText(String.valueOf(defaultFormat.format(stats.getTotalSale())));
				
		}
	}
	
	// Will exit the program, if user clicks the "Exit" button. 
	class ExitButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			System.exit(0);		
		}
	}
	
	// Will launch the GUI for the Movie Theater application. 
	public static void main(String[] args) {
        launch(args);
    }
	
}
	