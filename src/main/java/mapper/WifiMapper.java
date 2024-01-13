package mapper;

import dto.WifiDto;
import entity.Wifi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public final class WifiMapper {
    public static WifiDto wifiToWifiDto(Wifi wifi){
        return WifiDto.builder()
                .manageNo(wifi.getManageNo())
                .wrdofc(wifi.getWrdofc())
                .mainName(wifi.getMainName())
                .address1(wifi.getAddress1())
                .address2(wifi.getAddress2())
                .installFloor(wifi.getInstallFloor())
                .installType(wifi.getInstallType())
                .installMBY(wifi.getInstallMBY())
                .serviceSegment(wifi.getServiceSegment())
                .cmcwr(wifi.getCmcwr())
                .installYear(wifi.getInstallYear())
                .inoutDoor(wifi.getInoutDoor())
                .remars3(wifi.getRemars3())
                .latitude(wifi.getLatitude())
                .longitude(wifi.getLongitude())
                .workDateTime(wifi.getWorkDateTime())
                .build();
    }
    private WifiMapper(){

    }
    public static Wifi resultSetToWifi(ResultSet rs) throws SQLException {
        return Wifi.builder()
                .manageNo(rs.getString("manage_no"))
                .wrdofc(rs.getString("wrdofc"))
                .mainName(rs.getString("main_name"))
                .address1(rs.getString("address1"))
                .address2(rs.getString("address2"))
                .installFloor(rs.getString("install_floor"))
                .installType(rs.getString("install_type"))
                .installMBY(rs.getString("install_mby"))
                .serviceSegment(rs.getString("service_segment"))
                .cmcwr(rs.getString("cmcwr"))
                .installYear(rs.getString("install_year"))
                .inoutDoor(rs.getString("inout_door"))
                .remars3(rs.getString("remars3"))
                .latitude(rs.getDouble("latitude"))
                .longitude(rs.getDouble("longitude"))
                .workDateTime(LocalDateTime.parse(rs.getString("work_date_time")))
                .build();
    }
}
