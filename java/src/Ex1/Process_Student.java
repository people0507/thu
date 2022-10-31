package Ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Process_Student {

	//tao phuong thuc ket noi
		public static Connection getCon() {
			Connection cn = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbstudent","root","13012002");
			}
			catch(ClassNotFoundException | SQLException e)
			{
				
			}
			return cn;
			
		}

	
	//tim kiem co dieu kien
	public ArrayList<Student>  getStudent_by(String IDClass, String Gender){
		Connection cn = getCon();
		String sql= "select * from tb_student where idclass ='"+IDClass+"' and gender = '"+Gender +"'";
		ArrayList<Student> arrStudent = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student st = new Student();
				st.setID(rs.getString("id")); 
				st.setName(rs.getString("name"));
				st.setClassID(rs.getString("idclass"));
				st.setGender(rs.getString("gender"));
				st.setMark(rs.getDouble("mark"));
				arrStudent.add(st);
				
			}
			cn.close();
		}
		catch(SQLException e) {}
		
		return arrStudent;
	}
	// tim kiem 
	public ArrayList<Student> getListStudent() {
		
		Connection cn = getCon();
		String sql= "select * from tb_student ";
		ArrayList<Student> lists = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student st = new Student();
				st.setID(rs.getString("ID"));
				st.setName(rs.getString("Name"));
				st.setClassID(rs.getString("IDClass"));
				st.setGender(rs.getString("Gender"));
				st.setMark(rs.getDouble("Mark"));
				lists.add(st);
				
			}
			cn.close();
		}
		catch(SQLException e) {}
		
		return lists;
	}
	
	
	
	//them ban ghi vao du lieu
	public static Boolean insertStudent(String ID, String Name, String ClassID, String Gender, Double Mark) {
		Connection cn = getCon();
		String sql= "insert into dbstudent.tb_student (id, name, idclass, gender, mark) values (?,?,?,?,?)";

		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, ID);
			ps.setString(2, Name);
			ps.setString(3, ClassID);
			ps.setString(4, Gender);
			ps.setDouble(5, Mark);
			ps.executeUpdate();
				
			cn.close();
			return true;
		
		}catch(SQLException e) {}
		return false;
		
		
	}
	//xoa ban ghi tu bang du lieu
	public static boolean delStudent(String ID) {
		Connection cn = getCon();
		String sql= "delete from tb_student where id =? ";
		
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, ID);
			ps.executeUpdate();			
			cn.close();
			return true;
		}catch(SQLException e) {}
		return false;
	}
	
	 public static void main(String[] args) throws SQLException {
		getCon();
	}
	
		
		 
}

