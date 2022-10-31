package KT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Process_Phone {
	
	private static Connection cn;
	
	public static Connection getCon() {
		// TODO Auto-generated method stub
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbphone","root","13012002");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			
		}
		return cn;
	}
	
	public boolean insertPhone(String ID, String Name, int Year, String Company, double Price ,  int Amount ) {
		// TODO Auto-generated method stub
		Connection cn = getCon();
		String sql= "insert into  tbphone (id, name, year, company, price, amount ) values (?,?,?,?,?,?)";

		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, ID);
			ps.setString(2, Name);
			ps.setInt(3, Year);
			ps.setString(4, Company);
			ps.setDouble(5, Price);
			ps.setInt(6, Amount);
			ps.executeUpdate();
			cn.close();
			return true;
		}catch(Exception e) {}

		return false;
	}

	
	
	
		
}
