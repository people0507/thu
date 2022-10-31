package Ex2;

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
	//private Student Student;
		// 	
			public ArrayList<Student> getListStudent() {
				
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
						Boolean Gender;
						if(rs.getString("Gender").equals("Nam")) {
							Gender = true;
						}
						else
						{
							Gender = false;
						}
						st.setGender(Gender);
						st.setMark(rs.getDouble("Mark"));
						lists.add(st);
						
					}
					cn.close();
				}
				catch(SQLException e) {}
				
				return lists;
			}
	//tim kiem lop va gioi tinh
		public ArrayList<Student>  getStudent_by(String IDClass, String Gender){
				Connection cn = getCon();
				String sql= "select * from tbstudent where idclass =?, gender = ?";
				ArrayList<Student> arrStudent = new ArrayList<>();
				try {
					PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Student st = new Student();
						st.setID(rs.getString("id")); 
						st.setName(rs.getString("name"));
						st.setClassID(rs.getString("idclass"));
						if(rs.getString("gender").equals("Nam"))
						{
							st.setGender(true);
						}
						else {
							st.setGender(false);
						}
						
						st.setMark(rs.getDouble("mark"));
						arrStudent.add(st);
						
					}
					cn.close();
				}
				catch(SQLException e) {}
				return arrStudent;
				
			}
	// xoa
		public static boolean delStudent(String IDClass) {
			Connection cn = getCon();
			String sql= "delete from tb_student where idclass =? ";
			
			try {
				PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
				ps.setString(1, IDClass);
				ps.executeUpdate();			
				cn.close();
				return true;
			}catch(SQLException e) {}
			return false;
		}
	// tim kiem theo lop
		/*	public ArrayList<Student>  getStudent_byClass(String IDClass){
				Connection cn = getCon();
				String sql= "select * from tb_student where idclass = ?";
				ArrayList<Student> arrStudent = new ArrayList<>();
				try {
					PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Student st = new Student();
						st.setID(rs.getString("id")); 
						st.setName(rs.getString("name"));
						st.setClassID(rs.getString("idclass"));
						//st.setGender(rs.getString("gender"));
						st.setMark(rs.getDouble("mark"));
						arrStudent.add(st);
						
					}
					cn.close();
				}
				catch(SQLException e) {}
				return arrStudent;
				
			}
		// tiem kiem theo id
			public Student  getStudent_byID(String ID){
				Connection cn = getCon();
				String sql= "select * from tb_student where id = ?";
				try {
					PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Student st = new Student();
						st.setID(rs.getString("id")); 
						st.setName(rs.getString("name"));
						st.setClassID(rs.getString("idclass"));
						//st.setGender(rs.getString("gender"));
						st.setMark(rs.getDouble("mark"));z
						
					}
					cn.close();
				}
				catch(SQLException e) {}
				return Student;
				
			}
		
		*/
		public ArrayList<Student> getStudent_byClass_Gender(String iDClass, Boolean gender) {
			// TODO Auto-generated method stub
			return null;
		}
		
			
}
