package dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class BookmarkDto {
    private int id;
    private String bookmarkName;
    private String wifiName;
    private String wifiManageNo;
    private LocalDateTime registerDateTime;
}
