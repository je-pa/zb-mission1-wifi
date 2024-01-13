package entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
@Builder
@Getter
public class Wifi {
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
    private LocalDateTime workDateTime;
}
