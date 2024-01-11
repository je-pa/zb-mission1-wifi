package util;

import java.sql.*;

public class DataBaseConnector {
    // 커넥션 객체 생성
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:C:/Program Files/SQLiteStudio/wifi");
    }
}
