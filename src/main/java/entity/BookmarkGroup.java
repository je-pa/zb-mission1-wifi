package entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class BookmarkGroup {
    private int id;

    private String name;

    private int order;

    private LocalDateTime registerDateTime;

    private LocalDateTime updatedDateTime;
}
