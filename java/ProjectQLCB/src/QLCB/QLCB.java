package QLCB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QLCB implements ICanbo {
    @Override
    public Connection getCon() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlcb", "root", "123456789");

        } catch (Exception e) {
            System.out.println("Error." + e);

        }

        return conn;
    }

    @Override
    public void insertCB(int SoTK, String Hoten, String GT, String Diachi, int Luong) {
        Connection conn = getCon();
        PreparedStatement statement = null;

        try {
            String query = "INSERT INTO `qlcb`.`tbcanbo` (`SoTK`, `Hoten`, `GT`, `Diachi`, `Luong`) VALUES (?, ?, ?, ?, ?);";
            statement = conn.prepareCall(query);
            statement.setInt(1, SoTK);
            statement.setString(2, Hoten);
            statement.setString(3, GT);
            statement.setString(4, Diachi);
            statement.setInt(5, Luong);

            statement.execute();
            System.out.print("Them thanh cong");

        } catch (SQLException ex) {
            System.out.print("Them khong thanh cong");
        }
    }
}
