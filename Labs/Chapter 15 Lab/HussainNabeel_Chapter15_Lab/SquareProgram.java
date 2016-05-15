/**
 * This program will calculate the square of a number that the user enters.
 * 
 * Name: Nabeel Hussain
 * Class: CMSC203
 * Professor: Jeannette Myers Kartchner
 * Chapter 15 Lab (Programming Challenge 2 - Nested Layouts 2, on page 1038 of textbook)
 * Date: 09/21/2015
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class SquareProgram extends Application {
	
	Label inputNumberLabel;        	    // Declares variable to hold the input label display          
	Label outputNumberLabel;         	// Declares variable to hold the output label display
	TextField inputNumberTextField;     // Declares variable to hold the input textfield    
	TextField outputNumberTextField;    // Declares variable to hold the output textfield
	           
	
	@Override
	public void start(Stage stage)
	{
		// Create labels for the input and output fields.
		inputNumberLabel = new Label("Number: ");
		outputNumberLabel = new Label("Square of Number: ");
		
		// Create textfields to input a number and display the square of that number.
		inputNumberTextField = new TextField();
		outputNumberTextField = new TextField();
		inputNumberTextField.setPrefColumnCount(4);
		outputNumberTextField.setPrefColumnCount(4);
		
		// The output field cannot be edited, since it will only display the results. 
		outputNumberTextField.setEditable(false);
		
		// Sets an event handler on the inputNumber textfield, which will calculate the square of
		// the number that the user enters. It will then display the result in the outputNumber textfield.    
		inputNumberTextField.setOnAction(new InputNumberEventHandler());
	
		// Create a horizontal box which will hold the input number label and textfield. 
		HBox inputPane = new HBox(10);
		// Left align the text
		inputPane.setAlignment(Pos.CENTER_LEFT);
		inputPane.setPadding(new Insets(10));
		// Add the input label and textfield to the children of the inputPane horizontal box
		inputPane.getChildren().addAll(inputNumberLabel, inputNumberTextField);
		
		// Create a horizontal box which will hold the output label and textfield.
		HBox outputPane = new HBox(10);
		// Left align the text
		outputPane.setAlignment(Pos.CENTER_LEFT);
		outputPane.setPadding(new Insets(10));
		// Add the output label and textfield to the children of the outputPane horizontal box
		outputPane.getChildren().addAll(outputNumberLabel, outputNumberTextField);
		
		// Create a BorderPane to place the input and output labels and textfields, which are nested inside horizontal boxes.  
		BorderPane displayPane = new BorderPane();
		// Place the horizontal box with the input text field in the top region of the BorderPane.
		displayPane.setTop(inputPane); 
		// Place the horizontal box with the output text field in the bottom region of the BorderPane.
		displayPane.setBottom(outputPane);
		// Set a padding of 10px around the labels and textfields, to create some spacing. 
		displayPane.setPadding(new Insets(10));
	
		// Set the displayPane as root of scene and set the scene on the stage
		stage.setScene(new Scene(displayPane));
		stage.setTitle("Squares");
		stage.show();	
	}
	
	// This class will execute, once the user enters a number into the inputNumber textfield and press's enter.
	// It will calculate the square of that number and return it to the outputNumber textfield.  
	class InputNumberEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// Extract the number from the input text field.
			String numberInput = inputNumberTextField.getText().trim();
			double number = Double.parseDouble(numberInput);
			
			// Calculate the square of the number the user enters.
			double numberSquared = number*number;
			
			// display the squared number in the outputNumber textfield. 
			outputNumberTextField.setText(String.valueOf(numberSquared));
		}
	}
	
	// Main method, which launches and executes the program. 
	public static void main(String[] args)
	{
		launch(args);	
	}
}