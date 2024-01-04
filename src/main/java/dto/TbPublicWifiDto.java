package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class TbPublicWifiDto {
    //관리번호
    @SerializedName("X_SWIFI_MGR_NO")
    private String manageNo;

    //자치구
    @SerializedName("X_SWIFI_WRDOFC")
    private String wrdofc;

    //와이파이명
    @SerializedName("X_SWIFI_MAIN_NM")
    private String mainName;

    //도로명주소
    @SerializedName("X_SWIFI_ADRES1")
    private String address1;

    //상세주소
    @SerializedName("X_SWIFI_ADRES2")
    private String address2;

    //설치위치(층)
    @SerializedName("X_SWIFI_INSTL_FLOOR")
    private String installFloor;

    //설치유형
    @SerializedName("X_SWIFI_INSTL_TY")
    private String installType;

    //설치기관
    @SerializedName("X_SWIFI_INSTL_MBY")
    private String installMBY;

    //서비스구분
    @SerializedName("X_SWIFI_SVC_SE")
    private String serviceSegment;

    //망종류
    @SerializedName("X_SWIFI_CMCWR")
    private String cmcwr;

    //설치년도
    @SerializedName("X_SWIFI_CNSTC_YEAR")
    private String installYear;

    //실내외구분
    @SerializedName("X_SWIFI_INOUT_DOOR")
    private String inoutDoor;

    //WIFI 접속환경
    @SerializedName("X_SWIFI_REMARS3")
    private String remars3;

    //X좌표
    @SerializedName("LAT")
    private Double latitude;

    //Y좌표
    @SerializedName("LNT")
    private Double longitude;

    //작업일자
    @SerializedName("WORK_DTTM")
    private LocalDateTime workDateTime;

}
