package repository;

import entity.LocationHistory;
import mapper.LocationHistoryMapper;
import util.DataBaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LocationHistoryRepository {
    public int addHistory(double lat, double lnt) {
        Connection connection = null;
        int rowCount = 0;
        try {
            connection = DataBaseConnector.getConnection();
            String sql = " INSERT INTO location_history (" +
                    "latitude, " +
                    "longitude, " +
                    "search_date_time) " +
                    "VALUES (?, ?, ?) ";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setDouble(1, lat);
            statement.setDouble(2, lnt);
            statement.setString(3, LocalDateTime.now().toString());

            rowCount += statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            return rowCount;
        }
    }

    public List<LocationHistory> getList() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<LocationHistory> list = new ArrayList<>();
        try {
            connection = DataBaseConnector.getConnection();
            String sql = "select * from location_history;";
            statement = connection.prepareStatement(sql);

            rs = statement.executeQuery();
            while(rs.next()){
                list.add(LocationHistoryMapper.resultSetToLocationHistory(rs));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            return list;
        }
    }

    public int deleteById(int id) {
        Connection connection = null;
        int rowCount = 0;
        try {
            connection = DataBaseConnector.getConnection();
            String sql = "DELETE FROM location_history WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            rowCount += statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            return rowCount;
        }
    }
}
