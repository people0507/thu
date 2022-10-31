package Ex3;

import java.sql.Connection;
import java.util.ArrayList;

public interface IStudent {
	public boolean delStudent(String ID);
	public static Connection getCon() {return null;};
	public ArrayList<Student> getListSyudent();
	public ArrayList<Student> getStudent_byClass(String ClassID);
	public ArrayList<Student> getStudent_byClass_Gender(String ClassID, boolean Gender);
	public Student getStudent_byID(String ID);
	public boolean insertStudent(String ID, String Name,boolean Gender, String ClassID, double Mark );
	public boolean updateStudent(String ID, String Name, String ClassID, boolean Gender, double Mark);
}
