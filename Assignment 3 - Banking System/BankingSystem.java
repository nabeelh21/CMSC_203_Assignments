/**
 * This program will implement a GUI application for a bank to support its banking needs.
 * A customer should be able to conduct typical banking transactions, such as making deposits,
 * withdrawing cash, and obtaining account balance.  
 * 
 * Name: Nabeel Hussain
 * Class: CMSC203
 * Professor: Jeannette Myers Kartchner
 * Assignment 3 - Banking System
 * Date: 09/21/2015
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javax.swing.JOptionPane;
import java.text.NumberFormat;


public class BankingSystem extends Application {
	
	Label firstNameLabel;                // Declares variable to hold the first name label display
	Label lastNameLabel;                 // Declares variable to hold the last name label display
	Label transactionAmtLabel;           // Declares variable to hold the transaction amount label display
	Label balanceLabel;                  // Declares variable to hold the account balance label display
	
	TextField firstNameTextField;        // Declares variable to hold the first name textfield   
	TextField lastNameTextField;         // Declares variable to hold the last name textfield 
	TextField transactionAmtTextField;   // Declares variable to hold the transaction amount textfield        
	TextField balanceTextField;          // Declares variable to hold the account balance textfield 
	
	Button newAccountButton;             // Declares variable to hold the "Create New Account" button
	Button depositButton;                // Declares variable to hold the "Deposit" button
	Button withdrawButton;               // Declares variable to hold the "Withdraw" button
	Button clearButton;                  // Declares variable to hold the "Clear" button
	Button exitButton;                   // Declares variable to hold the "Exit" button
	
	// An object of the BankAccount class
	BankAccount accUser;
	
	//Creating an instance of the NumberFormat class, so I can format the number into currency, for the banking system. 
	NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
	
	/**
	 * Sets the layout of the GUI, with all the labels, textfields, and buttons that the banking application
	 * will need to perform all the banking transactions. 
	 */
	@Override
	public void start(Stage stage)
	{
		// Create labels for the input fields		
		firstNameLabel = new Label("First Name: ");		
		lastNameLabel = new Label("Last Name: ");		
		transactionAmtLabel = new Label("Transacation Amount: ");		
		balanceLabel = new Label("Balance: ");		
		
		// Create textfields for the labels
		firstNameTextField = new TextField();
		lastNameTextField = new TextField();
		transactionAmtTextField = new TextField();
		balanceTextField = new TextField();
		
		// Create the buttons for the banking system
		newAccountButton = new Button("Create New Account");		
		depositButton = new Button("Deposit");		
		withdrawButton = new Button("Withdraw");		
		clearButton = new Button("Clear");		
		exitButton = new Button("Exit");	
		
		// Start the program with only the first name and last name textfields editable, while the other fields are disabled. 
		// Also make sure that initially the "Create New Account" works only, while the rest of the buttons do not, until a new account is created.
		transactionAmtTextField.setEditable(false);
		balanceTextField.setEditable(false);
		depositButton.setDisable(true);
		withdrawButton.setDisable(true);
		clearButton.setDisable(true);
		exitButton.setDisable(true);
		
		// Sets event handlers on each button, which will perform different actions, depending on which button the user clicks. 
		newAccountButton.setOnAction(new NewAccountButtonEventHandler());
		depositButton.setOnAction(new DepositButtonEventHandler());
		withdrawButton.setOnAction(new WithdrawButtonEventHandler());
		clearButton.setOnAction(new ClearButtonEventHandler());
		exitButton.setOnAction(new ExitButtonEventHandler());
		
		// Create a vertical box that will hold all the labels 
		VBox labelPane = new VBox(30);
		labelPane.setAlignment(Pos.CENTER_RIGHT);
		// Add the labels to the children of the labelPane vertical box
		labelPane.getChildren().addAll(firstNameLabel, lastNameLabel, transactionAmtLabel, balanceLabel);
		
		// Create a vertical box that will hold all the textfields.
		VBox textFieldPane = new VBox(20);
		textFieldPane.setAlignment(Pos.CENTER);
		// Add the textfields to the children of the textFieldPane vertical box
		textFieldPane.getChildren().addAll(firstNameTextField, lastNameTextField,transactionAmtTextField, balanceTextField);
				
		// Create a horizontal box, and nest the label and textfield boxes next to each other, so the appropriate label matches the correct textfield. 
		HBox inputPane = new HBox(15);
		inputPane.setPadding(new Insets(0, 130, 0, 0));
		inputPane.setAlignment(Pos.CENTER);
		// Add the labelPane and the textFieldPane to the children of the inputPane horizontal box
		inputPane.getChildren().addAll(labelPane, textFieldPane);
				
		// Create a horizontal box, that will place the the buttons next to each other. 
		HBox buttonPane = new HBox(20);
		buttonPane.setAlignment(Pos.CENTER);
		// Add the buttons to the children of the buttonPane horizontal box
		buttonPane.getChildren().addAll(newAccountButton,depositButton,withdrawButton,clearButton,exitButton);
		
		// Create a vertical box that will hold the labels and their textfields first, and the buttons underneath. 
		VBox contentPane = new VBox(50);
		contentPane.setAlignment(Pos.CENTER);
		// Add the inputPane and buttonPane into the contentPance vertical box.
		contentPane.getChildren().addAll(inputPane, buttonPane);
		
		// Create a BorderPane to place the labels, textfields, and buttons, which have been stored in the contentPane 
		BorderPane displayPane = new BorderPane();
		// Place contentPane in the center region of the BorderPane.
		displayPane.setCenter(contentPane); 
		
		
		// Set displayPane as root of scene and set the scene on the stage
		Scene scene = new Scene(displayPane, 600, 350);
		stage.setTitle("Java Bank and Trust");
		stage.setScene(scene);
		stage.show();	
	}
	
	// Extract the first name and last name from the text boxes, and create a BankAccount object.
	class NewAccountButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			//Get the name from the input text field
			String firstNameInput = firstNameTextField.getText().trim();
			String lastNameInput = lastNameTextField.getText().trim();
			
			//Creating a BankAccount object, using the users first and last name that is entered. 
			accUser = new BankAccount (firstNameInput, lastNameInput);
			
			// Once the new account is created, disable the first and last name input textfields, as well as disable the create new account button. 
			// Then, enable the transaction amount textfield and enable the rest of the buttons in the banking system program. 
			firstNameTextField.setEditable(false);
			lastNameTextField.setEditable(false);
			transactionAmtTextField.setEditable(true);
			newAccountButton.setDisable(true);
			depositButton.setDisable(false);
			withdrawButton.setDisable(false);
			clearButton.setDisable(false);
			exitButton.setDisable(false);
			
			balanceTextField.setText(String.valueOf(defaultFormat.format(accUser.getBalance())));	
		}
	}
	
	// Will add the amount of money the users enters in the transaction amount field, to the total balance.
	class DepositButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// Get the number from the transaction amount input text field, and parse it into a number.
			String transactionAmtInput = transactionAmtTextField.getText().trim();
			double amount = Double.parseDouble(transactionAmtInput);
			
			// If user enters a negative number to deposit, display message saying they must enter a positive number.
			if( amount <= 0)
			{
				JOptionPane.showMessageDialog(null, "You must enter a transaction amount greater than 0, for it to be deposited into your account. \n"
						+ "Please try again.");	
			}
			else
			{
				// Calls the deposit method from the BankAccount class to perform the deposit calculation for the customer.
				accUser.deposit(amount);
				
				// Will display the resulting balance in the balance textfield. 
				balanceTextField.setText(String.valueOf(defaultFormat.format(accUser.getBalance())));
			}
		}
	}
	
	 // Will subtract the amount of money the users enters in the transaction amount field, from the total balance. 
	class WithdrawButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// Get the number from the transaction amount input textfield, and parse it into a number. 
			String transactionAmtInput = transactionAmtTextField.getText().trim();
			double amount = Double.parseDouble(transactionAmtInput);
			
			// If user enters a negative number to withdraw, display message saying they must enter a positive number. 
			if( amount <= 0)
			{
				JOptionPane.showMessageDialog(null, "You must enter a transaction amount greater than 0, for it to be withdrawn from your account. \n"
						+ "Please try again.");		
			}
			else if(amount > accUser.getBalance())
			{
				JOptionPane.showMessageDialog(null, "You must enter a transaction amount that is less than your current balance, \n"
						+ "inorder to withdraw money from your account. Please try again.");
			}
			else
			{
			// Calls the withdraw method from the BankAccount class to perform the withdrawal calculation ofr the customer. 
			accUser.withdraw(amount);
			
			// Will display the resulting balance in the balance textfield.
			balanceTextField.setText(String.valueOf(defaultFormat.format(accUser.getBalance())));	
			}
		}
	}
	
    // Will clear the amount in the transaction amount text box, if user clicks the "Clear" button. 
	class ClearButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			transactionAmtTextField.clear();
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
	
	// Will launch and execute the program. 
	public static void main(String[] args)
	{
		launch(args);
	}
}
	



