package repository;

import dto.BookmarkDto;
import mapper.BookmarkMapper;
import util.DataBaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookmarkRepository {
    public int add(String wifiManageNo, int bookmarkGroupId) {
        Connection connection = null;
        PreparedStatement statement = null;
        int rowCount = 0;
        try {
            connection = DataBaseConnector.getConnection();
            String sql = " INSERT INTO bookmark (" +
                    "bookmark_group_id, " +
                    "manage_no, " +
                    "reg_date_time) " +
                    "VALUES (?, ?, ?) ";
            statement = connection.prepareStatement(sql);

            statement.setInt(1, bookmarkGroupId);
            statement.setString(2, wifiManageNo);
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

    public BookmarkDto getById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        BookmarkDto bookmarkDto = null;
        try {
            connection = DataBaseConnector.getConnection();
            String sql = "select b.id as id, bg.name as bookmark_name, w.main_name as wifi_name, w.manage_no as wifi_manage_no, b.reg_date_time as reg_date_time" +
                    "  from bookmark AS b" +
                    "  left join bookmark_group bg on b.bookmark_group_id = bg.id" +
                    "  left join wifi w on b.manage_no = w.manage_no" +
                    " where b.id = ?" +
                    " order by b.id;";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while(rs.next()){
                bookmarkDto = BookmarkMapper.resultSetToBookmarkDto(rs);
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
            return bookmarkDto;
        }
    }

    public List<BookmarkDto> getList() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<BookmarkDto> list = new ArrayList<>();
        try {
            connection = DataBaseConnector.getConnection();
            String sql = "select b.id as id, bg.name as bookmark_name, w.main_name as wifi_name, w.manage_no as wifi_manage_no, b.reg_date_time as reg_date_time" +
                         "  from bookmark AS b" +
                         "  left join bookmark_group bg on b.bookmark_group_id = bg.id" +
                         "  left join wifi w on b.manage_no = w.manage_no" +
                         " order by b.id;";
            statement = connection.prepareStatement(sql);

            rs = statement.executeQuery();
            while(rs.next()){
                list.add(BookmarkMapper.resultSetToBookmarkDto(rs));
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
            String sql = "DELETE FROM bookmark WHERE id=?";
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
