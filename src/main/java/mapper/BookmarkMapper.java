package mapper;

import dto.BookmarkDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public final class BookmarkMapper {
    private BookmarkMapper() {
    }

    public static BookmarkDto resultSetToBookmarkDto(ResultSet rs) throws SQLException {
        return BookmarkDto.builder()
                .id(rs.getInt("id"))
                .bookmarkName(rs.getString("bookmark_name"))
                .wifiName(rs.getString("wifi_name"))
                .wifiManageNo(rs.getString("wifi_manage_no"))
                .registerDateTime(LocalDateTime.parse(rs.getString("reg_date_time")))
                .build();
    }
}
