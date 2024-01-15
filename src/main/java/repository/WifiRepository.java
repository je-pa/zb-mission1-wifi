package repository;

import dto.TbPublicWifiDto;
import dto.WifiDto;
import mapper.WifiMapper;
import util.DataBaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WifiRepository {

    public int addAll(List<TbPublicWifiDto> wifis) {
        Connection connection = null;
        int rowCount = 0;
        try {
            connection = DataBaseConnector.getConnection();
            String sql = " insert into wifi (" +
                    "manage_no, " +
                    "wrdofc, " +
                    "main_name, " +
                    "address1, " +
                    "address2, " +
                    "install_floor, " +
                    "install_type, " +
                    "install_mby, " +
                    "service_segment, " +
                    "cmcwr, " +
                    "install_year, " +
                    "inout_door, " +
                    "remars3, " +
                    "latitude, " +
                    "longitude, " +
                    "work_date_time) " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement statement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            for (TbPublicWifiDto dto : wifis) {
                statement.setString(1, dto.getManageNo());
                statement.setString(2, dto.getWrdofc());
                statement.setString(3, dto.getMainName());
                statement.setString(4, dto.getAddress1());
                statement.setString(5, dto.getAddress2());
                statement.setString(6, dto.getInstallFloor());
                statement.setString(7, dto.getInstallType());
                statement.setString(8, dto.getInstallMBY());
                statement.setString(9, dto.getServiceSegment());
                statement.setString(10, dto.getCmcwr());
                statement.setString(11, dto.getInstallYear());
                statement.setString(12, dto.getInoutDoor());
                statement.setString(13, dto.getRemars3());
                statement.setDouble(14, dto.getLatitude());
                statement.setDouble(15, dto.getLongitude());
                statement.setString(16, dto.getWorkDateTime().toString());

                rowCount += statement.executeUpdate();
            }
            connection.commit();
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

    public WifiDto getById(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        WifiDto wifiDto = null;
        try {
            connection = DataBaseConnector.getConnection();
            String sql = "select 0 as distance,* from wifi where manage_no = ?;";
            statement = connection.prepareStatement(sql);
            statement.setString(1,id);

            rs = statement.executeQuery();
            while(rs.next()){
                wifiDto = WifiMapper.resultSetToWifiDto(rs);
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
            return wifiDto;
        }
    }

    public List<WifiDto> getListByLatAndLnt(double lat, double lnt) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<WifiDto> list = new ArrayList<>();
        try {
            connection = DataBaseConnector.getConnection();
            String sql = "select " +
                    " *" +
                    " ,(6371 * acos(cos(radians(?)) * cos(radians(latitude)) * cos(radians(longitude) - radians(?)) + sin(radians(?)) * sin(radians(latitude)))) AS distance" +
                    " FROM wifi ORDER BY distance" +
                    " LIMIT 20;";
            statement = connection.prepareStatement(sql);
            statement.setDouble(1,lat);
            statement.setDouble(2,lnt);
            statement.setDouble(3,lat);

            rs = statement.executeQuery();
            while(rs.next()){
                WifiDto wifiDto = WifiMapper.resultSetToWifiDto(rs);
                list.add(wifiDto);
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

    public int deleteAll() {
        Connection connection = null;
        int rowCount = 0;
        try {
            connection = DataBaseConnector.getConnection();
            String sql = "delete from wifi";
            PreparedStatement statement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            rowCount += statement.executeUpdate();
            connection.commit();
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
