/**
 * This program will implement a GUI application for adding basketball players to a team, and then displaying the team roster.   
 * 
 * Name: Nabeel Hussain
 * Class: CMSC203
 * Professor: Jeannette Myers Kartchner
 * Assignment 5 - Basketball Teams
 * Date: 10/23/2015
 * 
 * @author Nabeel Hussain
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import java.util.ArrayList;


public class BasketballTeamGUI extends Application {
	
	Label titleLabel;             // Declares variable to hold the label for the main header title for the application
	Label teamNameLabel;          // Declares variable to hold the label for the team name
	Label firstNameLabel;         // Declares variable to hold the label for a players first name
	Label lastNameLabel;          // Declares variable to hold the label for a players last name
	Label positionsTitleLabel;    // Declares variable to hold the label for the title of the of the player position section. 
	Label teamRosterLabel;        // Declares variable to hold the label for the title of the section that prints the team roster
	
	String [] playerPositionLabels = {"Forward", "Center", "Guard"};  // Declares and initializes an array to hold the radio button labels for the player positions. 
	RadioButton[] radioButtons;    // Declares an array variable to hold the radio buttons for the three playing positions. 
	
	TextField teamNameTextField;     // Declares variable to hold the textfield for the team name
	TextField firstNameTextField;    // Declares variable to hold the textfield for a players first name
	TextField lastNameTextField;     // Declares variable to hold the textfield for a players last name
	
	TextArea teamRosterTextArea;     // Declares variable to hold the text area for showing the teams roster
	TextArea errorMessagesTextArea;  // Declares variable to hold the text area for showing any error messages
	
	Button addPlayerButton;   // Declares variable to hold the "Add Player" button
	Button printTeamButton;   // Declares variable to hold the "Print Team" button
	Button clearButton;       // Declares variable to hold the "Clear" button
	Button newTeamButton;     // Declares variable to hold the "New Team" button
	Button exitButton;        // Declares variable to hold the "Exit" button
	

	//Creating an instance of the Team class by declaring an object called name. 
	Team name;
	
	ArrayList<Player> currentPlayers = new ArrayList<>();
	
	/**
	 * Sets the layout of the GUI, with all the labels, textfields, and buttons that the movie theater application
	 * will need to perform all its functions. 
	 */
	@Override
	public void start(Stage stage)
	{
		// Create label for the title of the application.  
		titleLabel = new Label("Basketball Teams");
		//titleLabel.setTextFill(Color.BLUE);
		titleLabel.setFont(new Font(18));
		
		// Create the text for for the input fields	labels	
		teamNameLabel = new Label("Team: ");		
		firstNameLabel = new Label("First Name: ");		
		lastNameLabel = new Label("Last Name: ");
		
		// Create the label text for the Position selection area of the application. 
		positionsTitleLabel = new Label("Positions");
		positionsTitleLabel.setFont(new Font(18));
		
		// Create the label text for the team roster display area of the application.
		teamRosterLabel = new Label("Team Roster");
		teamRosterLabel.setFont(new Font(18));
		
		// Create the textfields for the team name, first name, and last name labels.  
		teamNameTextField = new TextField();
		teamNameTextField.setPrefWidth(180);
		firstNameTextField = new TextField();
		firstNameTextField.setPrefWidth(180);
		lastNameTextField = new TextField();
		lastNameTextField.setPrefWidth(180);
		
		// Create the TextArea box, where the team roster will we displayed. 
		teamRosterTextArea = new TextArea();
		teamRosterTextArea.setPrefWidth(500);
		teamRosterTextArea.setPrefHeight(120);
		
		// Create the TextArea box, where the error messages will be displayed, if too many of the same positions or players are added to the team. 
		errorMessagesTextArea = new TextArea();
		errorMessagesTextArea.setStyle("-fx-text-fill: red");
		errorMessagesTextArea.setPrefWidth(400);
		errorMessagesTextArea.setPrefHeight(10);
		
		// Create the buttons that will be used in the basketball team GUI 
		addPlayerButton = new Button("Add Player");		
		printTeamButton = new Button("Print Team");		
		clearButton = new Button("Clear");		
		newTeamButton = new Button("New Team");		
		exitButton = new Button("Exit");	
		
		// Start the program with only the "New Team" and "Exit" buttons enabled, while the rest are disabled.
		// All the input text fields and text areas are disabled as well when the program starts. 
		addPlayerButton.setDisable(true);
		printTeamButton.setDisable(true);
		clearButton.setDisable(true);
		teamNameTextField.setEditable(false);
		firstNameTextField.setEditable(false);
		lastNameTextField.setEditable(false);
		errorMessagesTextArea.setEditable(false);
		teamRosterTextArea.setEditable(false);
		
		// Sets event handlers on each button, which will perform different actions, depending on which button the user clicks. 
		addPlayerButton.setOnAction(new AddPlayerButtonEventHandler());
		printTeamButton.setOnAction(new PrintTeamButtonEventHandler());
		clearButton.setOnAction(new ClearButtonEventHandler());
		newTeamButton.setOnAction(new NewTeamButtonEventHandler());
		exitButton.setOnAction(new ExitButtonEventHandler());
		
		// Set event handler on the team name textfield
		teamNameTextField.setOnAction(new TeamNameTextFieldEventHandler());
		
		
		// Displays an image of a basketball and add it into a horizontal box pane. 
		HBox image = new HBox();
		// I uploaded the Basketball_small.jpg image onto the internet, and used its image URL as the location of the file. 
		Image img = new Image("http://i60.tinypic.com/2q36qs8.jpg");
		ImageView imgView = new ImageView(img);
		// Sets the image to a size of 85x85
		imgView.setFitHeight(85);
		imgView.setFitWidth(85);
		
        image.getChildren().addAll(imgView);
        
		// Create a horizontal box that will nest the box containing the basketball image next to the title of the gui application.
		HBox title = new HBox(10);
		title.setAlignment(Pos.CENTER_LEFT);
		title.setPadding(new Insets(15,0,30,130));
		// Add the title to the children of the Title horizontal box
		title.getChildren().addAll(image, titleLabel);
        
		
		// Create a vertical box that will hold the team, first name, and last name labels
		VBox playerInfoLabels = new VBox(30);
		playerInfoLabels.setAlignment(Pos.CENTER_RIGHT);
		playerInfoLabels.getChildren().addAll(teamNameLabel,firstNameLabel, lastNameLabel);
		
		// Create a vertical box that will hold the team, first name, and last name textfields
		VBox playerInfoFields = new VBox(20);
		playerInfoFields.setAlignment(Pos.CENTER);
		playerInfoFields.getChildren().addAll(teamNameTextField,firstNameTextField, lastNameTextField);
		
		// Create a horizontal box, that will nest the playerInfoLabels and playerInfoFields next to each other for the team.
		HBox playerInfoPane = new HBox(20);
		playerInfoPane.setPadding(new Insets(0, 0, 0, 15));
		playerInfoPane.setAlignment(Pos.CENTER_LEFT);
		// Add the buttons to the children of the buttonPane horizontal box
		playerInfoPane.getChildren().addAll(playerInfoLabels,playerInfoFields);			

		
		// Will create a vertical box to hold the position options as radio buttons. 
		VBox positionsRadioBox = new VBox(25);
		positionsRadioBox.setAlignment(Pos.CENTER_LEFT);
		positionsRadioBox.setPadding(new Insets(0,15,15,15));
		// Create the radio buttons and set their toggleGroup property. 
		ToggleGroup radiosGroup = new ToggleGroup();
		radioButtons = new RadioButton[playerPositionLabels.length];
		
		// Loop through the array, and create a radio button for each of the three positions in the playerPositionLabels array. 
		for( int i = 0; i < radioButtons.length; i++)
		{
			radioButtons[i] = new RadioButton(playerPositionLabels[i]);
			radioButtons[i].setToggleGroup(radiosGroup);
		}
		// Add the radio buttons to the children of the positionsRadioBox vertical box
		positionsRadioBox.getChildren().addAll(radioButtons);
		
		// nest the positionsRadioBox VBox into another VBox
		VBox radioButtons = new VBox();
		radioButtons.setAlignment(Pos.CENTER_LEFT);
		radioButtons.getChildren().addAll(positionsRadioBox);
		
		// Create a VBox with a gray border, and nest the title of the Position selection area of the GUI, followed by the radio buttons below. 
		VBox positionSectionPane = new VBox(20);
		positionSectionPane.setAlignment(Pos.CENTER_LEFT);
		positionSectionPane.setPadding(new Insets(15,15,15,15));
		positionSectionPane.setStyle("-fx-border-color: gray;");
		positionSectionPane.getChildren().addAll(positionsTitleLabel, radioButtons);
		
		// Nest the positionSectionPane into another VBox, in order for the border to properly be shown and be displayed around the Position section area of the GUI. 
		VBox playerPositionBox = new VBox();
		playerPositionBox.setAlignment(Pos.CENTER_LEFT);
		playerPositionBox.setPadding(new Insets(0,15,0,15));
		playerPositionBox.getChildren().addAll(positionSectionPane);	
		

		// Create a horizontal box, that will place all the buttons next to each other, that will be used in the GUI.
		HBox buttonPane = new HBox(25);
		buttonPane.setAlignment(Pos.CENTER);
		// Add the buttons to the children of the buttonPane horizontal box
		buttonPane.getChildren().addAll(addPlayerButton,printTeamButton,clearButton,newTeamButton,exitButton);			

		// Create a vertical box that will hold the label for the Team Roster display section in the GUI
		VBox rosterlabel = new VBox();
		rosterlabel.setAlignment(Pos.CENTER_LEFT);
		rosterlabel.setPadding(new Insets(5, 0, 0, 15));
		rosterlabel.getChildren().addAll(teamRosterLabel);

		// Create a vertical box that will nest the playerInfoPane on top, followed by the player position selection options, followed by the buttons,
		// and then followed by the team roster label.   
		VBox contentPane1 = new VBox(30);
		contentPane1.setAlignment(Pos.CENTER);
		contentPane1.setPadding(new Insets(0, 0, 15, 0));
		contentPane1.getChildren().addAll( playerInfoPane,playerPositionBox, buttonPane, rosterlabel);
		
		
		// Create a vertical box that will hold the text area of the Team Roster in the GUI.
		// Add a background color, and set the padding of the box to 10 all around, to create a small border space around the text area box. 
		VBox rosterBox = new VBox();
		rosterBox.setPadding(new Insets(10, 10, 10, 10));
		rosterBox.setStyle("-fx-background-color: gainsboro;");
		rosterBox.setAlignment(Pos.CENTER_LEFT);
		rosterBox.getChildren().addAll(teamRosterTextArea);
	    
		
		// Create a vertical box that will hold the text area, displaying the error messages in the GUI.
		// Add a background color, and set the padding of the box to 10 all around, to create a small border space around the text area box.
		VBox errorBox1 = new VBox(10);
		errorBox1.setPadding(new Insets(10, 10, 10, 10));
		errorBox1.setStyle("-fx-background-color: gainsboro;");
		errorBox1.setAlignment(Pos.CENTER);
		errorBox1.getChildren().addAll(errorMessagesTextArea);
		
		// Create a box that will nest the errorBox1, containing the errorMessagesTextArea.
		// This will ensure that the border that was created inside the nested pane, wont touch the edge of the GUI screen. 
		VBox errorBox2 = new VBox(10);
		errorBox2.setPadding(new Insets(0, 15, 0, 15));
		errorBox2.setAlignment(Pos.CENTER);
		errorBox2.getChildren().addAll(errorBox1);
		
		// Create a VBox to nest the contentPane box (containing the player info textfields, radio buttons, buttons, and rosterTeam label) on top.
		// followed by the rosterBox (containing the roster team text area).
		VBox contentPane2 = new VBox();
		contentPane2.setAlignment(Pos.CENTER);
		contentPane2.setPadding(new Insets(0, 0, 15, 0));
		contentPane2.getChildren().addAll( contentPane1, rosterBox);
		
		// Create a VBox to nest contentPane2 pane on top followed by the errorBox2 pane (containing the errox box text area)
		VBox contentPane3 = new VBox();
		contentPane3.setAlignment(Pos.CENTER);
		contentPane3.setPadding(new Insets(0, 0, 15, 0));
		contentPane3.getChildren().addAll( contentPane2, errorBox2);
		
		
		// Create a BorderPane to place contentPane3 into the center of the GUI display.
		// contentPane3 contains all the nested Hbox's and Vbox's that were created to properly organize and display the contents of the GUI application.  
		BorderPane displayPane = new BorderPane();
		// Place the contentPane in the center region of the BorderPane.
		displayPane.setCenter(contentPane3); 
		
		// Place the HBox containing the basketball image and title of the GUI application at the top of the BorderPane.
		displayPane.setTop(title);
		
		// Set displayPane as root of scene and set the scene on the stage
		Scene scene = new Scene(displayPane);
		stage.setTitle("Create Basketball Team");
		stage.setScene(scene);
		stage.show();	
	}
	
	
	// Will add a player to the team, using their name and position info. 
	class AddPlayerButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// Extract the first name and last name from the input textfields
			String firstNameInput = firstNameTextField.getText().trim();
			String lastNameInput = lastNameTextField.getText().trim();
			
			// Determine which position was selected from the radio buttons, and assign the string value to the selectedPosition variable. 
			String selectedPosition = null;
			for(RadioButton rb : radioButtons)
			{
				if(rb.isSelected())
				{
					selectedPosition = rb.getText();
				}	
			}
			
			// Everytime the add button is selected, if there is an error, then display the error message in the error text area box.
			errorMessagesTextArea.setText(name.addPlayer(firstNameInput, lastNameInput, selectedPosition));
		}
	}
	
	// Will print and display the team roster in the teamRoster text area box, with the players that were added to the team.
	class PrintTeamButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// calling the printTeam() method from the Team class to display the roster. 
			teamRosterTextArea.setText(name.printTeam());
			
		}
	}
	
	// Will clear the first name and last name text fields and any error messages that were shown.
	class ClearButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// Clear the first name and last name textfields
			// Also clear any error messages
			firstNameTextField.clear();
			lastNameTextField.clear();
		}
	}
	
    // Will enable the user to enter the team name in the textfield box. 
	class NewTeamButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// Once the button is clicked, make the teamName, first name, and last name textbox's editable. Also clear the team name, first name, and last name fields.
			// Clear the text area for the team roster and any error messages as well. 
			teamNameTextField.setEditable(true);
			firstNameTextField.setEditable(true);
			lastNameTextField.setEditable(true);
			teamNameTextField.clear();
			firstNameTextField.clear();
			lastNameTextField.clear();
			teamRosterTextArea.clear();
			errorMessagesTextArea.clear();
		}
	}
	
	// This is the event handler for the teamName textbox.
	// It will create an instance of the Team class, using the name entered in the team name textfield area. 
	class TeamNameTextFieldEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// Extract the team name from the input textfield
			String teamNameInput = teamNameTextField.getText().trim();
			
			// Creating a new Team object, using the team name that was entered. 
			name = new Team (teamNameInput);
			
			// Make the team name textbox uneditable, and also make the addPlayer, printTeam, and clear buttons enabled. 
			teamNameTextField.setEditable(false);
			addPlayerButton.setDisable(false);
			printTeamButton.setDisable(false);
			clearButton.setDisable(false);
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
	