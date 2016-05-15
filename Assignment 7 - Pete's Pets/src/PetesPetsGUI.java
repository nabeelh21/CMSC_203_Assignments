import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
* This program will implement a GUI application for displaying the Pete's Pets weekly employee pay information  
* 
* Name: Nabeel Hussain
* Class: CMSC203
* Professor: Jeannette Myers Kartchner
* Assignment 7 - Pete's Pets
* Date: 12/01/2015
* 
* @author Nabeel Hussain
*/

public class PetesPetsGUI extends Application {
	
	Label firstNameLabel = new Label();               // Declares variable to hold the label for a employees first name
	Label lastNameLabel = new Label();                // Declares variable to hold the label for a employees last name
	Label managerSalaryLabel = new Label();           // Declares variable to hold the label for a managers salary amount 
	Label clerkPayrateLabel = new Label();            // Declares variable to hold the label for a clerks hourly pay rate 
	Label clerkHoursLabel = new Label();              // Declares variable to hold the label for a clerks number of hours worked
	Label vetNumVaccinationsLabel = new Label();      // Declares variable to hold the label for the number of vaccination's administered by a veterinarian
	Label stylistPayRateLabel = new Label();          // Declares variable to hold the label for a stylist's pay rate
	Label stylistNumAppointmentsLabel = new Label();  // Declares variable to hold the label for a stylist's number of appointments    
	Label employeeIdLabel = new Label();              // Declares variable to hold the ID number for an employee. 
	
	
	String [] employeePositionLabels = {"Manager", "Clerk", "Vet", "Stylist"};  // Declares and initializes an array to hold the radio button labels for the employee types

	RadioButton[] radioButtons;  // Declares an array variable of RadioButton to hold the radio buttons for the employee titles
	
	TextField firstNameTextField = new TextField();     // Declares variable to hold the textfield for a employees first name
	TextField lastNameTextField = new TextField();      // Declares variable to hold the textfield for a employees last name
	TextField thirdInputTextField = new TextField();    // Declares variable to hold the textfield for inputing a managers salary, or clerks pay rate, or vet's number of vaccination's, or stylist's pay rate.
	TextField fourthInputTextField = new TextField();   // Declares variable to hold the textfield for inputting a clerks number of hours worked, or a stylist's number of appointments finished. 
	TextField employeeIdTextField = new TextField();    // Declares variable to hold the textfield for a employees ID number
	
	Button addEmployeeButton;   		// Declares variable to hold the "Add Employee" button
	Button readFileButton;  			// Declares variable to hold the "Read from File" button
	Button displaySummaryReportButton;  // Declares variable to hold the "Display Summary Pay Report" button
	Button writeSummaryReportButton;    // Declares variable to hold the "Write Summary Pay Report" button
	Button exitButton;        			// Declares variable to hold the "Exit" button
	
	
	Employees emp = new Employees();   // creates an Employee object to add employees and perform the data manager functions for the application to display the correct results. 
	
	
	/**
	 * Sets the layout of the GUI, with all the labels, textfields, and buttons that the Pete's Pets application
	 * will need to perform all its functions. 
	 */
	@Override
	public void start(Stage stage)
	{
		// Initialize all the label names
		firstNameLabel = new Label("First Name");
		lastNameLabel = new Label("Last Name");	
		managerSalaryLabel= new Label("Salary");
		clerkPayrateLabel= new Label("Payrate");
		clerkHoursLabel= new Label("Hours");
		vetNumVaccinationsLabel= new Label("# Vaccinations");
		stylistPayRateLabel = new Label("Payrate");
		stylistNumAppointmentsLabel= new Label("# Appointments"); 
		employeeIdLabel = new Label("Employee ID");
		
		
		// Initialize and set the size of all the textfields 
		firstNameTextField = new TextField();
		firstNameTextField.setPrefWidth(180);
		lastNameTextField = new TextField();
		lastNameTextField.setPrefWidth(180);		
		thirdInputTextField = new TextField();
		thirdInputTextField.setPrefWidth(180);
		fourthInputTextField = new TextField();
		fourthInputTextField.setPrefWidth(180);
		employeeIdTextField = new TextField();
		employeeIdTextField.setPrefWidth(180);
	
	
		// Initialize the buttons that will be used in the Pete's Pets GUI 
		addEmployeeButton = new Button("Add Employee");		
		readFileButton = new Button("Read from File");		
		displaySummaryReportButton = new Button("Display Summary Pay Report");		
		writeSummaryReportButton = new Button("Write Summary Pay Report");		
		exitButton = new Button("Exit");	
		
		
		// Sets event handlers on each button, which will perform different actions, depending on which button the user clicks. 
		addEmployeeButton.setOnAction(new AddEmployeeButtonEventHandler());
		readFileButton.setOnAction(new ReadFileButtonEventHandler());
		displaySummaryReportButton.setOnAction(new DisplaySummaryReportButtonEventHandler());
		writeSummaryReportButton.setOnAction(new WriteSummaryReportButtonEventHandler());
		exitButton.setOnAction(new ExitButtonEventHandler());
        
		
    	// When the program starts, display the labels and input fields for the manager employee by default. Set all the other employee label as invisible. 
	    firstNameLabel.setVisible(true);
	    firstNameTextField.setVisible(true);
	    lastNameLabel.setVisible(true); 
	    lastNameTextField.setVisible(true); 
	    thirdInputTextField.setVisible(true);
	    employeeIdLabel.setVisible(true);               
	    employeeIdTextField.setVisible(true);
	    managerSalaryLabel.setVisible(true);
	    
    	fourthInputTextField.setVisible(false);	
		clerkPayrateLabel.setVisible(false); 
		clerkHoursLabel.setVisible(false);
		vetNumVaccinationsLabel.setVisible(false);
		stylistPayRateLabel.setVisible(false); 
		stylistNumAppointmentsLabel.setVisible(false);   
		
		
		// Will create a horizontal box to hold the radio buttons for the different employee positions 
		HBox employeeRadioBox = new HBox(15);
		employeeRadioBox.setAlignment(Pos.CENTER);
		// Create the radio buttons and set their toggleGroup property. 
		ToggleGroup radiosGroup = new ToggleGroup();
		radioButtons = new RadioButton[employeePositionLabels.length];
		
		// Loop through the array, and create a radio button for each of the 4 employee positions in the employeePositionLabels array. 
		for( int i = 0; i < radioButtons.length; i++)
		{
			radioButtons[i] = new RadioButton(employeePositionLabels[i]);
			radioButtons[i].setToggleGroup(radiosGroup);
			
			radioButtons[i].setOnAction(e-> ButtonClicked(e));
		}
		// Add the radio buttons to the children of the employeeRadioBox horizontal box
		employeeRadioBox.getChildren().addAll(radioButtons);
		
		
		// Create a HBox with a gray border, and nest the employeeRadioBox into it
		HBox employeeSectionPane = new HBox(20);
		employeeSectionPane.setAlignment(Pos.CENTER);
		employeeSectionPane.setPadding(new Insets(25,15,25,15));
		employeeSectionPane.setStyle("-fx-border-color: gray;");
		employeeSectionPane.getChildren().addAll(employeeRadioBox);
		
		// Nest the employeeSectionPanee into another HBox, in order for the border to properly be shown and be displayed around the employee radiobox section of the GUI. 
		HBox employeePositionBox = new HBox();
		employeePositionBox.setAlignment(Pos.CENTER);
		employeePositionBox.setPadding(new Insets(40,0,0,0));
		employeePositionBox.getChildren().addAll(employeeSectionPane);
		
		
		// Stack all the employee labels that will use the thirdInputTextField for input. 
		StackPane stack1= new StackPane();
		stack1.setAlignment(Pos.CENTER_LEFT);
		stack1.getChildren().addAll(managerSalaryLabel,clerkPayrateLabel,vetNumVaccinationsLabel,stylistPayRateLabel);
		
		// Stack all the employee labels that will use the fourthInputTextField for input. 
		StackPane stack2= new StackPane();
		stack2.setAlignment(Pos.CENTER_LEFT);
		stack2.getChildren().addAll(clerkHoursLabel,stylistNumAppointmentsLabel);
		
		// Will create a HBox to place the employeeIdLabel. 
		HBox empIdLabel = new HBox();
		empIdLabel.setPadding(new Insets(25, 0,0,0));
		empIdLabel.setAlignment(Pos.CENTER_LEFT);
		empIdLabel.getChildren().addAll(employeeIdLabel);
		
		// Will create a HBox to place the employeeIdtextField, which will be used by the user to enter the ID numbers for all the employees. 
		HBox empIdTextfield = new HBox();
		empIdTextfield.setPadding(new Insets(25, 0,0,0));
		empIdTextfield.setAlignment(Pos.CENTER);
		empIdTextfield.getChildren().addAll(employeeIdTextField);
		
		
		// Will create a VBox to place all the employee labels in a column. 
		VBox employeeLabels = new VBox(15);
		employeeLabels.setAlignment(Pos.CENTER_LEFT);
		employeeLabels.getChildren().addAll(lastNameLabel,firstNameLabel,stack1, stack2, empIdLabel );
		
		// Will create a VBox to place all the employee textfields in a column.
		VBox employeeFields = new VBox();
		employeeFields.setAlignment(Pos.CENTER);
		employeeFields.getChildren().addAll(lastNameTextField,firstNameTextField,thirdInputTextField,fourthInputTextField, empIdTextfield);
		
		
		// Will create a HBox to place all employeeLabels and employeeFields next to each other. 
		HBox employeePane = new HBox(30);
		employeePane.setPadding(new Insets(60, 0, 35,0));
		employeePane.setAlignment(Pos.CENTER);
		employeePane.getChildren().addAll(employeeLabels,employeeFields);
		
	
		// Place the "Add Employee", "Read from File", and "Display Summary Pay Report" buttons in one horizontal row.   
		HBox row1Buttons = new HBox(15);
		row1Buttons.setAlignment(Pos.CENTER);
		row1Buttons.getChildren().addAll(addEmployeeButton, readFileButton,displaySummaryReportButton);	
		
		// Place the "Write Summary Pay Report" and "Exit" buttons in another horizontal row.
		HBox row2Buttons = new HBox(15);
		row2Buttons.setAlignment(Pos.CENTER);
		row2Buttons.getChildren().addAll(writeSummaryReportButton,exitButton);	
		

		// Place the row1Buttons on top of the row2Buttons, in a Vertical box pane. 
		VBox buttonPane = new VBox(15);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setPadding(new Insets(0,5,0,5));
		// Add the buttons to the children of the buttonPane horizontal box
		buttonPane.getChildren().addAll(row1Buttons,row2Buttons);		
		
		
		// Create a vertical box that will nest the employee radio buttons on top, followed by the employee labels and textfields, followed by the buttons on the bottom.   
		VBox contentPane = new VBox(30);
		contentPane.setAlignment(Pos.CENTER);
		contentPane.getChildren().addAll(employeePositionBox,employeePane, buttonPane);
		
		
		// Create a BorderPane to place the contentPane into the center of the GUI display.
		// contentPane contains all the nested Hbox's and Vbox's that were created to properly organize and display the contents of the GUI application.  
		BorderPane displayPane = new BorderPane();
		displayPane.setCenter(contentPane);
		
		// Place the displayPane onto the scene of the stage, and set the title of the stage
		Scene scene = new Scene(displayPane);
		stage.setTitle("Employee Paycheck Management");
		stage.setScene(scene);
		stage.show();	
	}
	
	// An event handler which will format the GUI display of the employee input fields, to allow a user to add the correct employee into the system. 
	public void ButtonClicked(ActionEvent e)
    {
		// If the user clicks on the "Manager" radio button, then display only the labels and inputs valid for that type of employee
		// Set all the other labels as invisible, and clear any info contained in the textfields from previous inputs. 
        if (e.getSource() == radioButtons[0])
        {
        	firstNameLabel.setVisible(true);
        	firstNameTextField.setVisible(true);
        	lastNameLabel.setVisible(true); 
        	lastNameTextField.setVisible(true); 
        	managerSalaryLabel.setVisible(true); 
        	thirdInputTextField.setVisible(true);
        	fourthInputTextField.setVisible(false);
           	employeeIdLabel.setVisible(true);               
        	employeeIdTextField.setVisible(true);
        	
        	firstNameTextField.clear();        	
        	lastNameTextField.clear();         	
        	thirdInputTextField.clear();       	
        	fourthInputTextField.clear();                    
        	employeeIdTextField.clear();
        	
        	clerkPayrateLabel.setVisible(false);
        	clerkHoursLabel.setVisible(false);
        	vetNumVaccinationsLabel.setVisible(false); 
        	stylistPayRateLabel.setVisible(false);  
        	stylistNumAppointmentsLabel.setVisible(false);  
        }
        
		// If the user clicks on the "Clerk" radio button, then display only the labels and inputs valid for that type of employee
		// Set all the other labels as invisible, and clear any info contained in the textfields from previous inputs.
        else if (e.getSource() == radioButtons[1])
        {	
           	firstNameLabel.setVisible(true);
        	firstNameTextField.setVisible(true);
        	lastNameLabel.setVisible(true); 
        	lastNameTextField.setVisible(true); 
        	clerkPayrateLabel.setVisible(true);
        	thirdInputTextField.setVisible(true);
        	clerkHoursLabel.setVisible(true);
        	fourthInputTextField.setVisible(true);
           	employeeIdLabel.setVisible(true);               
        	employeeIdTextField.setVisible(true);
        		
        	firstNameTextField.clear();        	
        	lastNameTextField.clear();         	
        	thirdInputTextField.clear();       	
        	fourthInputTextField.clear();                    
        	employeeIdTextField.clear();
        	
        	managerSalaryLabel.setVisible(false);
        	vetNumVaccinationsLabel.setVisible(false); 
        	stylistPayRateLabel.setVisible(false);  
        	stylistNumAppointmentsLabel.setVisible(false);      
        }
        
   		// If the user clicks on the "Vet" radio button, then display only the labels and inputs valid for that type of employee
		// Set all the other labels as invisible, and clear any info contained in the textfields from previous inputs.
        else if (e.getSource() == radioButtons[2])
        { 
           	firstNameLabel.setVisible(true);
        	firstNameTextField.setVisible(true);
        	lastNameLabel.setVisible(true); 
        	lastNameTextField.setVisible(true); 
        	vetNumVaccinationsLabel.setVisible(true);
        	thirdInputTextField.setVisible(true);
        	fourthInputTextField.setVisible(false);
           	employeeIdLabel.setVisible(true);               
        	employeeIdTextField.setVisible(true);
        	
        	firstNameTextField.clear();        	
        	lastNameTextField.clear();         	
        	thirdInputTextField.clear();       	
        	fourthInputTextField.clear();                    
        	employeeIdTextField.clear();
        	
        	managerSalaryLabel.setVisible(false);
        	clerkPayrateLabel.setVisible(false);
        	clerkHoursLabel.setVisible(false); 
        	stylistPayRateLabel.setVisible(false);  
        	stylistNumAppointmentsLabel.setVisible(false);    
        }
        
		// If the user clicks on the "Stylist" radio button, then display only the labels and inputs valid for that type of employee
		// Set all the other labels as invisible, and clear any info contained in the textfields from previous inputs.  
        else if (e.getSource() == radioButtons[3])
        {
           	firstNameLabel.setVisible(true);
        	firstNameTextField.setVisible(true);
        	lastNameLabel.setVisible(true); 
        	lastNameTextField.setVisible(true); 
        	stylistPayRateLabel.setVisible(true);
        	thirdInputTextField.setVisible(true);
        	stylistNumAppointmentsLabel.setVisible(true);
        	fourthInputTextField.setVisible(true);
           	employeeIdLabel.setVisible(true);               
        	employeeIdTextField.setVisible(true);
        	
        	firstNameTextField.clear();        	
        	lastNameTextField.clear();         	
        	thirdInputTextField.clear();       	
        	fourthInputTextField.clear();                    
        	employeeIdTextField.clear();
        	
        	managerSalaryLabel.setVisible(false);
        	clerkPayrateLabel.setVisible(false);
        	clerkHoursLabel.setVisible(false);
        	vetNumVaccinationsLabel.setVisible(false); 
        }
    }
  

	// Will take the information entered by the user, and add that employee to the Pete's Pets employee list. 
	class AddEmployeeButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			int payCode;
	     	String firstNameInput;
        	String lastNameInput;
        	int idNumber;
        	double salary;
        	double payRate;
        	int hoursWorked;
        	double numVaccines;
        	double pay;
        	int numAppointments;
			
			// Determine which employee position was selected from the radio buttons, and assign the string value to the selectedPosition variable. 
			String selectedPosition = null;
			
			for(RadioButton rb : radioButtons)
			{
				if(rb.isSelected())
				{
					selectedPosition = rb.getText();
				}	
			}
			
			// If the "Manager" option is selected, then extract the information from the manager textfields, and use it to add the manager employee into the list. 
			if(selectedPosition.equals("Manager"))
			{
				// assign the paycode as 1 for managers
				payCode = 1;
				
				// Extract the first name and last name from the input textfields
				firstNameInput = firstNameTextField.getText().trim();
				lastNameInput = lastNameTextField.getText().trim();
				
				// Extract the salary amount for the manager, and parse it into an Double value
				salary = Double.parseDouble(thirdInputTextField.getText().trim());
				
				// Extract the id number for the manager, and parse it into an int value 
				idNumber = Integer.parseInt(employeeIdTextField.getText().trim());
				
				// Use the extracted information for the manager to add the employee to the list. 
				emp.addEmployee(payCode, firstNameInput, lastNameInput, salary, 0, idNumber);						
			}
			// If the "Clerk" option is selected, then extract the information from the clerk textfields, and use it to add the clerk employee into the list.
			else if (selectedPosition.equals("Clerk"))
			{
				// assign the paycode as 2 for clerks
				payCode = 2;
				
				// Extract the first name and last name from the input textfields
				firstNameInput = firstNameTextField.getText().trim();
				lastNameInput = lastNameTextField.getText().trim();
				
				// Extract the pay rate for the clerk, and parse it into an Double value. 
				payRate = Double.parseDouble(thirdInputTextField.getText().trim());
				
				// Extract te hours worked for the clerk, and parse it into an int value
				hoursWorked = Integer.parseInt(fourthInputTextField.getText().trim());
				
				// Extract the id number for the clerk, and parse it into an int value 
				idNumber = Integer.parseInt(employeeIdTextField.getText().trim());
				
				// Use the extracted information for the clerk to add the employee to the list.
				emp.addEmployee(payCode, firstNameInput, lastNameInput, payRate, hoursWorked, idNumber);						
			}
			// If the "Vet" option is selected, then extract the information from the vet textfields, and use it to add the vet employee into the list.
			else if (selectedPosition.equals("Vet"))
			{
				// assign the paycode as 3 for clerks
				payCode = 3;
				
				// Extract the first name and last name from the input textfields
				firstNameInput = firstNameTextField.getText().trim();
				lastNameInput = lastNameTextField.getText().trim();
				
				// Extract the number of vaccinations for the vet, and parse it into an Double value. 
				numVaccines = Double.parseDouble(thirdInputTextField.getText().trim());
				
				// Extract the id number for the vet, and parse it into an int value
				idNumber = Integer.parseInt(employeeIdTextField.getText().trim());
				
				// Use the extracted information for the vet to add the employee to the list.
				emp.addEmployee(payCode, firstNameInput, lastNameInput, numVaccines, 0, idNumber);						
			}
			// If the "Stylist" option is selected, then extract the information from the stylist textfields, and use it to add the stylist employee into the list.
			else if (selectedPosition.equals("Stylist"))
			{
				// assign the paycode as 4 for stylist's
				payCode = 4;
				
				// Extract the first name and last name from the input textfields
				firstNameInput = firstNameTextField.getText().trim();
				lastNameInput = lastNameTextField.getText().trim();
				
				// Extract the pay rate for the stylist, and parse it into an Double value. 
				pay = Double.parseDouble(thirdInputTextField.getText().trim());
				
				// Extract the number of appointments for the stylist, and parse it into an Double value.
				numAppointments = Integer.parseInt(fourthInputTextField.getText().trim());
				
				// Extract the id number for the stylist, and parse it into an int value
				idNumber = Integer.parseInt(employeeIdTextField.getText().trim());
				
				// Use the extracted information for the stylist to add the employee to the list
				emp.addEmployee(payCode, firstNameInput, lastNameInput, pay, numAppointments, idNumber);
			}
		}
	}
	
	// Will read the employee information from a file, and add each employee into an ArrayList. 
	class ReadFileButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			File selectedFile = null;
			Scanner inputFile;
			ArrayList<String> data = new ArrayList<>();   // Declares a String ArrayList to hold the contents of the file being read.
			String[] empData = new String[6];
			
			// Will display a window box allowing the user to select a file from their computer to open, in order to read its data. 
			JFileChooser fileChooser = new JFileChooser();
			int status = fileChooser.showOpenDialog(null);
			
			if (status == JFileChooser.APPROVE_OPTION)
			{
				selectedFile = fileChooser.getSelectedFile();
			}
			
			try
			{
				inputFile = new Scanner(selectedFile);
				
				// Read each content, line by line from the .txt file into a String ArrayList
				while (inputFile.hasNext())
				{	
					data.add(inputFile.nextLine());
				}
				
		        for(int i = 0; i < data.size(); i++)
		        {
		        	String firstName;
		        	String lastName;
		        	int idNumber;
		        	double salary;
		        	double payRate;
		        	int hoursWorked;
		        	double numVaccines;
		        	double pay;
		        	int numAppointments;
		        	
		        	
		        	// Split the contents of each line and place them into the the String[] array
		        	empData= data.get(i).split(" ");
		        	
		        	// Parse the first content in the array into an int, to determine the employees paycode
	        		int payCode = Integer.parseInt(empData[0]);
		        	
		        	// If the extracted paycode number is 1, then it's a manager employee
		        	if(payCode == 1)
		        	{
		        		// Extract the rest of the data from the empData array, and place it into the appropriate variables for the manager
		        		firstName = empData[1];
		        		lastName = empData[2];
		        		salary = Double.parseDouble(empData[3]);
		        		idNumber = Integer.parseInt(empData[4]);
		        		
		        		// Use the info to add the employee to the list
		        		emp.addEmployee(payCode, firstName, lastName, salary, 0, idNumber);		     
		        	}
		        	// If the extracted paycode number is 2, then it's a clerk employee
		        	else if(payCode == 2)
		        	{
		        		// Extract the rest of the data from the empData array, and place it into the appropriate variables for the clerk
		        		firstName = empData[1];
		        		lastName = empData[2];
		        		payRate = Double.parseDouble(empData[3]);
		        		hoursWorked = Integer.parseInt(empData[4]);
		        		idNumber = Integer.parseInt(empData[5]);
		        		
		        		// Use the info to add the employee to the list
		        		emp.addEmployee(payCode, firstName, lastName, payRate, hoursWorked, idNumber);
		        	}
		        	// If the extracted paycode number is 3, then it's a vet employee
		        	else if(payCode == 3)
		        	{
		        		// Extract the rest of the data from the empData array, and place it into the appropriate variables for the vet
		        		firstName = empData[1];
		        		lastName = empData[2];
		        		numVaccines = Double.parseDouble(empData[3]);
		        		idNumber = Integer.parseInt(empData[4]);
		        		
		        		// Use the info to add the employee to the list
		        		emp.addEmployee(payCode, firstName, lastName, numVaccines, 0, idNumber);
		        	}
		        	// If the extracted paycode number is 4, then it's a stylist employee
		        	else if(payCode == 4)
		        	{
		        		// Extract the rest of the data from the empData array, and place it into the appropriate variables for the stylist
		        		firstName = empData[1];
		        		lastName = empData[2];
		        		pay = Double.parseDouble(empData[3]);
		        		numAppointments = Integer.parseInt(empData[4]);
		        		idNumber = Integer.parseInt(empData[5]);
		        		
		        		// Use the info to add the employee to the list
		        		emp.addEmployee(payCode, firstName, lastName, pay, numAppointments, idNumber);
		        	}
		        }
			}
			
			catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// Will print the employees weekly pay report onto the screen
	class DisplaySummaryReportButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			// call the method sort() from the employees class to order the list of employees by their id numbers. 
			emp.sort();
			// Displays the report by calling the method generateWeeklyReport() from the employees class. 
			JOptionPane.showMessageDialog(null, emp.generateWeeklyReport());
		}
	}
	
    // Will print the employees weekly pay report into a file specified by the user. 
	class WriteSummaryReportButtonEventHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			File selectedFile = null;
			PrintWriter outputFile;
			
			// Will display a window box allowing the user to select a file from their computer to open, in order to write data into.  
			JFileChooser fileChooser = new JFileChooser();
			int status = fileChooser.showOpenDialog(null);
			
			if (status == JFileChooser.APPROVE_OPTION)
			{
				selectedFile = fileChooser.getSelectedFile();
			}
			
			try {
				
				// It  will call the generateWeeklyReport() method and write the results into the selected file. 
				outputFile = new PrintWriter(selectedFile);
				outputFile.println(emp.generateWeeklyReport());

				// Close the file
				outputFile.close();
			}
			
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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