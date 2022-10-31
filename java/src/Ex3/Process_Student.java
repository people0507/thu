package Ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class Process_Student implements IStudent {
	
	private static Connection cn;
	//private Student Student;

	@Override
	public boolean delStudent(String ID) {
		Connection cn = getCon();
		String sql = "delete from tbstudent where id = ?";
				try {
					PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
					ps.setString(1,ID);
					ps.executeUpdate();
					cn.close();
					return true;
				}catch(Exception e){
					return false;
			}
	}

	public static Connection getCon() {
		// TODO Auto-generated method stub
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

	@Override
	public ArrayList<Student> getListSyudent() {
		// TODO Auto-generated method stub
		Connection cn = getCon();
		String sql= "select * from tbstudent ";
		ArrayList<Student> lists = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student st = new Student();
				st.setID(rs.getString("ID"));
				st.setName(rs.getString("Name"));
				st.setClassID(rs.getString("IDClass"));
				st.setGender(rs.getBoolean("Gender"));
//				Boolean Gender;
//				if(rs.getString("Gender").equals("Nam")) {
//					Gender = true;
//				}
//				else
//				{
//					Gender = false;
//				}
				//st.setGender(Gender);
				st.setMark(rs.getDouble("Mark"));
				lists.add(st);
				
			}
			cn.close();
		}
		catch(SQLException e) {}
		
		return lists;
		
	}

	@Override
	public ArrayList<Student> getStudent_byClass(String ClassID) {
		// TODO Auto-generated method stub
		Connection cn = getCon();
		String sql= "select * from tbstudent where idclass = ?";
		ArrayList<Student> arrStudent = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, ClassID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student st = new Student();
				st.setID(rs.getString("id")); 
				st.setName(rs.getString("name"));
				st.setClassID(rs.getString("idclass"));
				st.setGender(rs.getBoolean("gender"));
//				if(rs.getString("gender").equals("Nam"))
//				{
//					st.setGender(true);
//				}
//				else {
//					st.setGender(false);
//				}
				st.setGender(rs.getBoolean("gender"));
				st.setMark(rs.getDouble("mark"));
				arrStudent.add(st);
				
			}
			cn.close();
		}
		catch(SQLException e) {}
		
		return arrStudent;
	
	}

	@Override
	public ArrayList<Student> getStudent_byClass_Gender(String ClassID, boolean Gender) {
		// TODO Auto-generated method stub
		Connection cn = getCon();
		String sql= "select * from tbstudent where idclass = ? and gender = ? ";
		ArrayList<Student> arrStudent = new ArrayList<>();
		
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, ClassID);
			ps.setBoolean(2, Gender);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student st = new Student();
				st.setID(rs.getString("id")); 
				st.setName(rs.getString("name"));
				st.setClassID(rs.getString("idclass"));
				st.setGender(rs.getBoolean("gender"));
				st.setMark(rs.getDouble("mark"));
				arrStudent.add(st);
				
			}
			cn.close();
		}
		catch(SQLException e) {}
		
		return arrStudent;
	}

	@Override
	public Student getStudent_byID(String ID) {
		// TODO Auto-generated method stub
		Connection cn = getCon();
		Student st = new Student();
		String sql= "select * from tbstudent where id = ?";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, ID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				st.setID(rs.getString("id")); 
				st.setName(rs.getString("name"));
				st.setClassID(rs.getString("idclass"));
				st.setGender(rs.getBoolean("gender"));
				st.setMark(rs.getDouble("mark"));
				return st;
				
			}
			cn.close();
		}
		catch(SQLException e) {}
		
		return null;
	}

	@Override
	public boolean insertStudent(String ID, String Name, boolean Gender, String ClassID, double Mark) {
		// TODO Auto-generated method stub
		Connection cn = getCon();
		String sql= "insert into dbstudent.tbstudent (id, name, idclass, gender, mark) values (?,?,?,?,?)";

		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, ID);
			ps.setString(2, Name);
			ps.setString(3, ClassID);
			ps.setBoolean(4, Gender);
			ps.setDouble(5, Mark);
			ps.executeUpdate();
			cn.close();
			return true;
		}catch(Exception e) {}

		return false;
	}


	@Override
	public boolean updateStudent(String ID, String Name, String ClassID, boolean Gender, double Mark) {
		// TODO Auto-generated method stub
		Connection cn = getCon();
		String sql = "update tbstudent set name = ?, idclass = ?,gender = ? , mark = ? where id = ?";	
	try {
		System.out.println("111");
		PreparedStatement ps =(PreparedStatement) cn.prepareStatement(sql);
		ps.setString(5,ID);
		ps.setString(1,Name);
		ps.setString(2,ClassID);
		ps.setBoolean(3,Gender);
		ps.setDouble(4,Mark);
		ps.executeUpdate();
		cn.close();
		return true;
	}catch (Exception e) {
		return false;
		}
		
	}

}
