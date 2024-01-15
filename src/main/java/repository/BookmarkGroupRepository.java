package repository;

import entity.BookmarkGroup;
import mapper.BookmarkGroupMapper;
import util.DataBaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookmarkGroupRepository {
    public int add(String name, int order) {
        Connection connection = null;
        PreparedStatement statement = null;
        int rowCount = 0;
        try {
            connection = DataBaseConnector.getConnection();
            String sql = " INSERT INTO bookmark_group (" +
                    "name, " +
                    "[order], " +
                    "reg_date_time) " +
                    "VALUES (?, ?, ?) ";
            // create a database connection
            statement = connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setInt(2, order);
            statement.setString(3, LocalDateTime.now().toString());

            rowCount += statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
            return rowCount;
        }
    }

    public List<BookmarkGroup> getList() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<BookmarkGroup> list = new ArrayList<>();
        try {
            connection = DataBaseConnector.getConnection();
            String sql = "select id, name, [order], reg_date_time, update_date_time from bookmark_group order by [order] asc;";
            statement = connection.prepareStatement(sql);

            rs = statement.executeQuery();
            while(rs.next()){
                list.add(BookmarkGroupMapper.resultSetToBookmarkGroup(rs));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
            return list;
        }
    }

    public BookmarkGroup getById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        BookmarkGroup bookmarkGroup = null;
        try {
            connection = DataBaseConnector.getConnection();
            String sql = "select id, name, [order], reg_date_time, update_date_time from bookmark_group WHERE id=?;";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while(rs.next()){
                bookmarkGroup = BookmarkGroupMapper.resultSetToBookmarkGroup(rs);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
            return bookmarkGroup;
        }
    }

    public int editByIdAndNameAndOrder(int id, String name, int order) {
        Connection connection = null;
        int rowCount = 0;
        try {
            connection = DataBaseConnector.getConnection();
            String sql = "update bookmark_group set name = ?, [order] = ?, update_date_time = ? where id = ?";
            // create a database connection
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setInt(2, order);
            statement.setString(3, LocalDateTime.now().toString());
            statement.setInt(4, id);

            rowCount += statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
            return rowCount;
        }
    }

    public int deleteById(int id) {
        Connection connection = null;
        int rowCount = 0;
        try {
            connection = DataBaseConnector.getConnection();
            String sql = "DELETE FROM bookmark_group WHERE id=?";
            // create a database connection
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
                // connection close failed.
                System.err.println(e.getMessage());
            }
            return rowCount;
        }
    }
}
