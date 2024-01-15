package entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class LocationHistory {
    private int id;
    private double latitude;
    private double longitude;
    private LocalDateTime searchDateTime;
}
