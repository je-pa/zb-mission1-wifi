package util;

import java.sql.*;

public final class DataBaseConnector {
    // 커넥션 객체 생성
    static public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection("jdbc:sqlite:C:/Program Files/SQLiteStudio/wifi");
    }
}
