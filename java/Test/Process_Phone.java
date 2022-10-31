package Test;

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
	
	public boolean delPhone(String Company, double Amount) {
		Connection cn = getCon();
		String sql = "delete from tb_phone where company =?  and amount = ? ";
				try {
					PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
					ps.setString(1,Company);
					ps.setDouble(2, Amount);
					ps.executeUpdate();
					cn.close();
					return true;
				}catch(Exception e){
					return false;
			}
	}
}
