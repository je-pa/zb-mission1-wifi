package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class TbPublicWifiInfoResponseDto {
    @SerializedName("TbPublicWifiInfo")
    private TbPublicWifiInfoDto publicWifiInfo;
}
