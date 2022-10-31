package QLCB;

import java.sql.Connection;

public interface ICanbo {
    public Connection getCon();
    public void insertCB(int SoTK, String Hoten, String GT, String Diachi, int Luong);
}
