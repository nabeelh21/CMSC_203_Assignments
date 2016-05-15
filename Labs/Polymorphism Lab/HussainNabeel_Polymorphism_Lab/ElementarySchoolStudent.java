/**
* This class will hold the methods and information needed for a elementary school student.
* @author Nabeel Hussain
*/ 
public class ElementarySchoolStudent extends Student
{
	private String elementarySchoolName;
	private String teacherName;
	private int roomNumber;


	/**
	 * Constructor for the ElementarySchoolStudent class.
	 * @param n students name
	 * @param a students age
	 * @param add address of school
	 * @param elementarysch school name
	 * @param teacher the name of the teacher, for the student
	 * @param room students classroom number
	 */
	public ElementarySchoolStudent(String n, int a, String add, String elementarysch, String teacher, int room)
	{
		super(n, a, add);
		elementarySchoolName = elementarysch;
		teacherName = teacher;
		roomNumber = room;	
	}

	/**
	 * A no-arg constructor for the ElementarySchoolStudent class.
	 */
	public ElementarySchoolStudent()
	{
		this(null,0,null,null,null,0);
	}

	/**
	 * Will return the teachers name
	 * @return the name of the students teacher
	 */
	public String getTeacher()
	{
		return teacherName;
	}
	   
	/**
	 * Will return the room number of the students classroom
	 * @return the students classroom number
	 */
	 public int getRoomNumber()
	 {
		 return roomNumber;
	 }
	  
	 /**
	 * Will return the name of the elementary school that the student attends
	 * @return the name of the elementary school
	 */
	 public String getElementarySchoolName()
	 {
		 return elementarySchoolName;
	 }
	 
	
	/**
	* Will print the students name, age, school name, teacher name, and classroom number
	* @return a string containing the students information
	*/ 
	public String printStudent()
	{
		String report = getName() + "  Age: " + getAge()+
	                 "  Attends: " + elementarySchoolName + "  Elementary School Teacher: " + teacherName +
	                 "  Room No.: " + roomNumber;
	               
		return report;
	}
	
	/**
	* Will print a string representation of the students information
	* @return a string representation of the students information
	*/
	public String toString()
	{
		String report = getName() + "  Age: " + getAge()+
	                 "  Attends: " + elementarySchoolName + "  Elementary School Teacher: " + teacherName +
	                 "  Room No.: " + roomNumber;
		return report;
	}

}

