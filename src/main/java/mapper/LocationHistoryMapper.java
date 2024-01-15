package mapper;

import entity.LocationHistory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public final class LocationHistoryMapper {
    private LocationHistoryMapper() {
    }
    public static LocationHistory resultSetToLocationHistory(ResultSet rs) throws SQLException {
        return LocationHistory.builder()
                .id(rs.getInt("id"))
                .latitude(rs.getDouble("latitude"))
                .longitude(rs.getDouble("longitude"))
                .searchDateTime(LocalDateTime.parse(rs.getString("search_date_time")))
                .build();
    }
}
