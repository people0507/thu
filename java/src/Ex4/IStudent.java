package Ex4;

import java.sql.Connection;
import java.util.ArrayList;

public interface IStudent {
	public boolean delStudent(String ID);
	public Connection getCon();
	public boolean displayStudent(String ClassID);
	public boolean insertStudent(String ID, String Name, String ClassID,boolean Gender, double Mark );
	public boolean updateStudent(String ID, String Name, String ClassID, boolean Gender, double Mark);
}
