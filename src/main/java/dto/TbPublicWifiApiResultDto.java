package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;

public class TbPublicWifiApiResultDto {
    @SerializedName("CODE")
    private String code;

    @SerializedName("MESSAGE")
    private String message;

}
