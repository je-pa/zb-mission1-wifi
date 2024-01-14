package mapper;

import dto.WifiDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public final class WifiMapper {
    private WifiMapper(){

    }
    public static WifiDto resultSetToWifiDto(ResultSet rs) throws SQLException {
        return WifiDto.builder()
                .distance(rs.getDouble("distance"))
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
