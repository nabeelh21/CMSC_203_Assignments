import java.util.ArrayList;
import java.util.Scanner;

/** Polymorphism Lab
 *  Student Driver class
 *  Uses the CollegeStudent, ElementarySchoolStudent, HighSchoolStudent and Student classes
 * @author Nabeel Hussain
 */

public class StudentDriver {
	/**
	 * Prints a menu
	 * Print the following menu:
	 * Choose one of the following:
	 * 1.	Create an Elementary School Student
	 * 2.	Create a High School Student
	 * 3.	Create a College Student
	 * 4.	Print out all students
	 * 5.	Exit
	 * When user selects menu item 1 - 3
	 * Prompts user for data needed for type of student selected
	 * Creates an object of student type user selected
	 * Puts object into the ArrayList
	 * When the user selects menu item 4 - the students in the Arraylist are printed to the console
	 * When the user selects menu item 5 - the application terminates
	 * @param args - not used
	 */
   public static void main(String[] args)
   {
	   ArrayList<Student> students = new ArrayList<>();
	   
	   @SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	   
     // 1.  print out menu
     // 2.  user selects to create elementary
     //     school, college or high school student
     // 3.  prompts user for appropriate information
     // 4.  creates the appropriate object (calls constructor)
	 // 5.  put object into ArrayList students
     // 6.  print out all students when user selects 4. from the menu
	 // 7.  repeat until user selects “Exit” from menu
	   
	   int menuItem;
	   
	   // Creating a do-while loop, which will allow the program to run once, and then keep running for as long as the user wants to
	   // keep adding students or print out all the students information. It will stop once the user enters 5
		do
		{
			System.out.println("Please select type of object to create:");
			System.out.println(
					"1) Elementry School\n2) High School\n3) College Student\n4) Print out all students\n5) Exit");
			menuItem = Integer.parseInt(in.nextLine());
			System.out.println();
			
			while(menuItem < 1 || menuItem >5 )
			{
				System.out.println("Please enter a valid option.");
				System.out.println("Please select type of object to create:");
				System.out.println(
						"1) Elementry School\n2) High School\n3) College Student\n4) Print out all students\n5) Exit");
				menuItem = Integer.parseInt(in.nextLine());
				System.out.println();
			}
			
			if (menuItem == 1)
			{
				System.out.println(
						"You have selected to create a profile of a Elementry School Kid ..... ");
				System.out.println("Please enter the full name: ");
				String name = in.nextLine();
				System.out.println("Please enter the Age: ");
				int age = Integer.parseInt(in.nextLine());
				System.out.println(
						"Please enter the name of the Elementry School: ");
				String eschool = in.nextLine();
				System.out.println("Please enter the Address: ");
				String address = in.nextLine();
				System.out.println("Please enter the name of the Teacher: ");
				String tname = in.nextLine();
				System.out.println("Please enter the Room No.: ");
				int rno = Integer.parseInt(in.nextLine());
				students.add(new ElementarySchoolStudent(name, age, address, eschool,
						tname, rno));
				System.out.println();
			}
			else if (menuItem == 2)
			{
				System.out.println(
						"You have selected to create a profile of a High School Student ..... ");
				System.out.println("Please enter the full name: ");
				String name = in.nextLine();
				System.out.println("Please enter the Age: ");
				int age = Integer.parseInt(in.nextLine());
				System.out.println(
						"Please enter the name of the High School: ");
				String hschool = in.nextLine();
				System.out.println("Please enter the Address: ");
				String address = in.nextLine();
				System.out.println("Please enter the name of the Counselor: ");
				String cname = in.nextLine();
				System.out.println("Please enter the Year of Graduation: ");
				int yog = Integer.parseInt(in.nextLine());
				System.out.println("Please enter the GPA: ");
				double gpa = Double.parseDouble(in.nextLine());
				students.add(new HighSchoolStudent(name, age, address, hschool,
						cname, yog, gpa));
				System.out.println();
			}
			else if (menuItem == 3)
			{
				System.out.println(
						"You have selected to create a profile of a College Student ..... ");
				System.out.println("Please enter the full name: ");
				String name = in.nextLine();
				System.out.println("Please enter the Age: ");
				int age = Integer.parseInt(in.nextLine());
				System.out.println(
						"Please enter the name of the College: ");
				String cschool = in.nextLine();
				System.out.println("Please enter the Address: ");
				String address = in.nextLine();
				System.out.println("Please enter the Major: ");
				String major = in.nextLine();
				System.out.println("Please enter the GPA: ");
				double gpa = Double.parseDouble(in.nextLine());
				students.add(new CollegeStudent(name, age, address, cschool,
						major, gpa));
				System.out.println();
			}
			else if (menuItem == 4)
			{
				printReport(students);
				System.out.println();
			}		
		}
		while (menuItem != 5);
		
		if(menuItem == 5)
		{
			System.exit(0);	
		}
   }

   /**
    * Prints out the student object in the ArrayList using the printStudent method defined in each class
    * @param students The ArrayList of students entered by the user
    */
   public static void printReport(ArrayList<Student> students)
   {
      for(Student current : students)
	   System.out.println(current.printStudent());
   }
}


