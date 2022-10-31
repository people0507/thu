package Ex4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Process_Student implements IStudent{

	@Override
	public boolean delStudent(String ID) {
		// TODO Auto-generated method stub
		Connection cn = getCon();
		String sql = "delete from tb_student where id = ?";
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

	@Override
	public Connection getCon() {
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
	public boolean insertStudent(String ID, String Name, String ClassID, boolean Gender, double Mark) {
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

	@Override
	public boolean displayStudent(String ClassID) {
		// TODO Auto-generated method stub
		
		return false;
	}

}
