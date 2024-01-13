package dto;

import com.google.gson.annotations.JsonAdapter;
import lombok.Builder;
import lombok.Getter;
import util.LocalDateTimeAdapter;

import java.time.LocalDateTime;
@Builder
@Getter
public class WifiDto {
    //관리번호
    private String manageNo;

    //자치구
    private String wrdofc;

    //와이파이명
    private String mainName;

    //도로명주소
    private String address1;

    //상세주소
    private String address2;

    //설치위치(층)
    private String installFloor;

    //설치유형
    private String installType;

    //설치기관
    private String installMBY;

    //서비스구분
    private String serviceSegment;

    //망종류
    private String cmcwr;

    //설치년도
    private String installYear;

    //실내외구분
    private String inoutDoor;

    //WIFI 접속환경
    private String remars3;

    //X좌표
    private Double latitude;

    //Y좌표
    private Double longitude;

    //작업일자
    @JsonAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime workDateTime;

    private Double currentLat;
    private Double currentLnt;
    public void setParamLocation(Double currentLat, Double currentLnt){
        this.currentLat = currentLat;
        this.currentLnt = currentLnt;
    }

    public Double getDistance() {
        // 지구 반경 (단위: km)
        double R = 6371;

        // 라디안 변환
        double lat1Rad = Math.toRadians(latitude);
        double lon1Rad = Math.toRadians(longitude);
        double lat2Rad = Math.toRadians(currentLat);
        double lon2Rad = Math.toRadians(currentLnt);

        // 위도 및 경도의 차이 계산
        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        // Haversine 공식 적용
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // 거리 계산
        return R * c;
    }
}
