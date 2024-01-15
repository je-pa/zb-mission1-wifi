package mapper;

import entity.BookmarkGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public final class BookmarkGroupMapper {
    private BookmarkGroupMapper() {
    }
    public static BookmarkGroup resultSetToBookmarkGroup(ResultSet rs) throws SQLException {
        String updateDateTime = rs.getString("update_date_time");
        return BookmarkGroup.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .order(rs.getInt("order"))
                .registerDateTime(LocalDateTime.parse(rs.getString("reg_date_time")))
                .updatedDateTime(updateDateTime == null ? null : LocalDateTime.parse(updateDateTime))
                .build();
    }
}
