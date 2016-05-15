/**
 /**
 * This program will implement a GUI application for displaying the college football team playoff rankings.  
 * 
 * Name: Nabeel Hussain
 * Class: CMSC203
 * Professor: Jeannette Myers Kartchner
 * Assignment 6 - College Football Playoffs
 * Date: 11/10/2015
 * 
 * @author Nabeel Hussain
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.io.File;
import java.util.ArrayList;


public class CollegeFootballGUI extends Application {

	
	Button readVotesButton;     // Declares variable to hold the "Load Movies" button
	Button rankTeamsButton;     // Declares variable to hold the "High/Low Reviews" button
	Button showDetailsButton;   // Declares variable to hold the "Compare" button
	Button exitButton;          // Declares variable to hold the "Exit" button
	
	
	final int TEAMS = 10;  
	final int VOTERS = 12;
	
	Label [] teamNamesLabel = new Label[TEAMS];              // Will hold the labels for the team names
	Label [] teamConferencesLabel = new Label[TEAMS];        // Will hold the labels for the conferences of the teams
	Label [] sumOfVotesLabel = new Label[TEAMS];           	 // will hold the sum of the votes for each team
	Label [][] votesTableLabel = new Label[VOTERS][TEAMS];   // Will hold all the votes for each of the 10 teams. 12 voters give a vote to each of the 10 teams. 
	Label infoMessageLabel = new Label();                    // Will hold the label to display the message that "Low Score is Higher Ranking" for the teams
	

	GridPane gridSumOfVotes = new GridPane();   // Declares a Grdipane to display the sum of the votes for each team in the GUI
	GridPane gridVotes = new GridPane();        // Declares a GridPane to display all the votes for each team in the GUI. 
	
	           
	CFPManagerInterface mgr = new CollegeFootballPlayoffManager(); // Will create an object of the CollegeFootballPlayoffManager class to perform the ranking operations in the GUI. 
	ArrayList<CollegeFootballTeam> list;  // Declares an ArrayList of CollegeFootballTeam to hold all the teams info from the file read in, which will be ranked. 

	/**
	 * Sets the layout of the GUI, with all the labels, textfields, and buttons that the movie theater application
	 * will need to perform all its functions. 
	 */
	@Override
	public void start(Stage stage)
	{
		// Will prompt the user at the beginning of the application to choose a file to read. 
		JOptionPane.showMessageDialog(null,"Select 'Read Votes' to begin...");
		
		// Create the buttons for the CollegeFootball rankings GUI 
		readVotesButton = new Button("Read Votes");
		readVotesButton.setPadding(new Insets(5, 20, 5, 20));
		rankTeamsButton = new Button("Rank Teams");
		rankTeamsButton.setPadding(new Insets(5, 20, 5, 20));
		showDetailsButton = new Button("Show Details");
		showDetailsButton.setPadding(new Insets(5, 20, 5, 20));
		exitButton = new Button("Exit");
		exitButton.setPadding(new Insets(5, 20, 5, 20));
		
		// Start the program with Rank Teams and Show Details buttons disabled, until the user read a file in. 
		rankTeamsButton.setDisable(true);
		showDetailsButton.setDisable(true);
		
		
		// Sets event handlers on each button, which will perform different actions, depending on which button the user clicks. 
		readVotesButton.setOnAction(new ReadVotesButtonEventHandler());
		rankTeamsButton.setOnAction(new RankTeamsButtonEventHandler());
		showDetailsButton.setOnAction(new ShowDetailsButtonEventHandler());
		exitButton.setOnAction(new ExitButtonEventHandler());
		
		infoMessageLabel.setFont(Font.font("Arial",FontWeight.BOLD,14));
		

		// Creating Labels to display the names of each team, and place them in a HBox, so the names will be shown
		// next to each other in the same row. 
	    HBox teamNames = new HBox(30);
	    teamNames.setAlignment(Pos.CENTER);
		for(int i = 0; i < TEAMS; i++)
		{
			teamNamesLabel[i] = new Label();
			teamNamesLabel[i].setFont(Font.font("Arial",FontWeight.BOLD,14));
			teamNames.getChildren().addAll(teamNamesLabel[i]);	
		}
		
		// Creating Labels to display the conferences of each team, and place them in a HBox, so they will be shown
		// next to each other in the same row.
	    HBox teamConferences = new HBox(45);
	    teamConferences.setAlignment(Pos.CENTER);
		// A for loop to add the 
		for(int i = 0; i < TEAMS; i++)
		{
			teamConferencesLabel[i] = new Label();
			teamConferencesLabel[i].setFont(Font.font("Arial",FontWeight.BOLD,14));
			teamConferences.getChildren().addAll(teamConferencesLabel[i]);	
		}
		
		// Creating a GridPane to hold the sum of the teams votes
	    gridSumOfVotes.setAlignment(Pos.CENTER);
		gridSumOfVotes.setStyle(" -fx-grid-lines-visible: false");
		gridSumOfVotes.setPadding(new Insets(10, 10, 10, 10));
		// Specify the column sizes for the grid.
        for(int i = 0; i < TEAMS; i++) {
            ColumnConstraints column = new ColumnConstraints(80);
            gridSumOfVotes.getColumnConstraints().add(column);
        }
        // Specify the row sizes for the grid.
        for(int i = 0; i < 1; i++) {
            RowConstraints row = new RowConstraints(60);
            gridSumOfVotes.getRowConstraints().add(row);
        }
        
        // Place the sumOfVotes labels into the correct row and column positions in the Gridpane. 
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < TEAMS; j++)
            {
            	sumOfVotesLabel[j] = new Label();
            	GridPane.setHalignment(sumOfVotesLabel[j], HPos.CENTER);
            	gridSumOfVotes.add(sumOfVotesLabel[j],j,i);
            }
        }
        
        // Create a VBox to display the infoMessageLabel below the sumOfVotes grid. 
        VBox SumAndInfo = new VBox();
        SumAndInfo.setAlignment(Pos.CENTER);
		// Add the buttons to the children of the buttonPane horizontal box
        SumAndInfo.getChildren().addAll(gridSumOfVotes, infoMessageLabel);		
		
		
        // Creating a GridPane to hold the 12 votes for each of the 10 teams. 
        gridVotes.setAlignment(Pos.CENTER);
        gridVotes.setStyle(" -fx-grid-lines-visible: false");
        gridVotes.setPadding(new Insets(10, 10, 10, 10));
        
        // Specify the column sizes for the grid. 
        for(int i = 0; i < TEAMS; i++) {
            ColumnConstraints column = new ColumnConstraints(80);
            gridVotes.getColumnConstraints().add(column);
        }
        // Specify the row sizes for the grid.
        for(int i = 0; i < VOTERS; i++) {
            RowConstraints row = new RowConstraints(60);
            gridVotes.getRowConstraints().add(row);
        }
        // Place the team votes labels into the correct row and column positions in the Gridpane holding all the votes for each team. 
        for (int i = 0; i < TEAMS; i++) {
            for (int j = 0; j < VOTERS; j++)
            {
            	votesTableLabel[j][i] = new Label();
            	GridPane.setHalignment(votesTableLabel[j][i], HPos.CENTER);
            	gridVotes.add(votesTableLabel[j][i],i,j);
            }
        }
        
        // Stack the pane holding the sumOfVotes and the gridpane containing all the votes for the teams.
        // This will help with the display when the user switches back and forth between the Rank Teams and Show Details buttons. 
        StackPane stack = new StackPane();
        stack.getChildren().addAll(SumAndInfo,gridVotes);
        
		
		// Create a horizontal box, that will place the buttons next to each other.
		HBox buttonPane = new HBox(10);
		buttonPane.setPadding(new Insets(15, 0, 0, 0));
		buttonPane.setAlignment(Pos.CENTER);
		// Add the buttons to the children of the buttonPane horizontal box
		buttonPane.getChildren().addAll(readVotesButton,rankTeamsButton,showDetailsButton,exitButton);			
		
		
		// Create a vertical box that will hold the conference names row, the sumOfVotes row, and the Votes table. 
		VBox confAndVotes = new VBox(15);
		confAndVotes.setAlignment(Pos.CENTER);
		confAndVotes.getChildren().addAll(teamConferences,stack);
	
		
		// Create a vertical box that will display all of the content to be display in the GUI. The buttons, followed by the team names, followed by the sums, etc... 
		VBox contentPane = new VBox(30);
		contentPane.setAlignment(Pos.CENTER);
		// Add the 
		contentPane.getChildren().addAll(buttonPane,teamNames,confAndVotes);
		
		// Create a BorderPane to place the contents of the GUI in the top section of the pane. 
		BorderPane displayPane = new BorderPane();
		// Place contentPane in the Top region of the BorderPane.
		displayPane.setTop(contentPane); 
		
		// Set displayPane as root of scene and set the scene on the stage
		Scene scene = new Scene(displayPane,900,950);
		stage.setTitle("College Football Playoff Selection");
		stage.setScene(scene);
		stage.show();	
	}
	
	// It will ask the user to enter a file, and then read its info. 
	class ReadVotesButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// Reset the counter to zero, which will be used in the Rank teams button, if the user clicks that button for a second time. 
			count = 0;
			
			// Will display a window box allowing the user to select a file from their computer to open, in order to read its data. 
			JFileChooser fileChooser = new JFileChooser();
			int status = fileChooser.showOpenDialog(null);
			
			if (status == JFileChooser.APPROVE_OPTION)
			{
				File selectedFile = fileChooser.getSelectedFile();
				
				mgr.readVotes(selectedFile);
			}
			
			// Make sure all the labels and gridlines are not visible, after the user enters a file to read in. 
			for(int i = 0; i < TEAMS; i++)
			{
				teamNamesLabel[i].setVisible(false);
				teamConferencesLabel[i].setVisible(false);
			}
			
			rankTeamsButton.setDisable(false);
			showDetailsButton.setDisable(false);
			infoMessageLabel.setVisible(false);
			
			gridSumOfVotes.setStyle("-fx-grid-lines-visible: false");
			gridSumOfVotes.setVisible(false);
			gridVotes.setStyle("-fx-grid-lines-visible: false");
			gridVotes.setVisible(false);
		}
	}
	
		
	int count = 0; 	// Initialize a counter, so when the user clicks the Rank Teams button for a second time, it will ask the user to read in a new file, and then the ranked results will be displayed for that new file.

	// It will rank the teams in order from the highest ranked team to the lowest ranked team, and display the team name, conference, and sum of their votes. 
	class RankTeamsButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{		
			if (count == 0)
			{
				list = mgr.rankTeams();
				for(int i = 0; i < TEAMS; i++)
				{
				teamNamesLabel[i].setVisible(true);
				teamConferencesLabel[i].setVisible(true);
				
				teamNamesLabel[i].setText(String.valueOf(list.get(i).getName()));
				teamConferencesLabel[i].setText(String.valueOf(list.get(i).getConferenceName()));
				sumOfVotesLabel[i].setText(String.valueOf(list.get(i).getSumOfVotes()));
				}
					
				infoMessageLabel.setText(String.valueOf("Low Score is Higher Ranking"));	
			}
			
			// If the user clicks the button for a second time or more, then ask them to enter a new file to rank teams. 
			else
			{
				JFileChooser fileChooser = new JFileChooser();
				int status = fileChooser.showOpenDialog(null);
				
				if (status == JFileChooser.APPROVE_OPTION)
				{
					File selectedFile = fileChooser.getSelectedFile();
					
					mgr.readVotes(selectedFile);
				}
				list = mgr.rankTeams();
				for(int i = 0; i < TEAMS; i++)
				{
				teamNamesLabel[i].setVisible(true);
				teamConferencesLabel[i].setVisible(true);
				
				teamNamesLabel[i].setText(String.valueOf(list.get(i).getName()));
				teamConferencesLabel[i].setText(String.valueOf(list.get(i).getConferenceName()));
				sumOfVotesLabel[i].setText(String.valueOf(list.get(i).getSumOfVotes()));
				}
					
				infoMessageLabel.setText(String.valueOf("Low Score is Higher Ranking"));	
			}
			
			infoMessageLabel.setVisible(true);
			gridSumOfVotes.setStyle("-fx-grid-lines-visible: true");
			gridSumOfVotes.setVisible(true);
			gridVotes.setStyle("-fx-grid-lines-visible: false");
			gridVotes.setVisible(false);
			
			
			count++;
			
		}
	}
	
	// It will show the votes for each team, and display the results inside a gridpane. 
	class ShowDetailsButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{	
			list = new ArrayList<CollegeFootballTeam>();
			list = mgr.rankTeams();
			
			for(int i = 0; i < TEAMS; i++)
			{
				teamNamesLabel[i].setVisible(true);
				teamConferencesLabel[i].setVisible(true);
				
				teamNamesLabel[i].setText(String.valueOf(list.get(i).getName()));
				teamConferencesLabel[i].setText(String.valueOf(list.get(i).getConferenceName()));
				sumOfVotesLabel[i].setText(String.valueOf(list.get(i).getSumOfVotes()));
			}

			for(int i = 0; i < TEAMS; i++)
			{
				for(int j = 0; j < VOTERS; j++)
				{
					votesTableLabel[j][i].setText(String.valueOf(list.get(i).getVotes()[j]));
				}
			}
			gridSumOfVotes.setStyle("-fx-grid-lines-visible: false");
			gridSumOfVotes.setVisible(false);
			gridVotes.setStyle("-fx-grid-lines-visible: true");
			gridVotes.setVisible(true);
			infoMessageLabel.setVisible(false);
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