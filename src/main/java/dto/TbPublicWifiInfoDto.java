package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class TbPublicWifiInfoDto {
    @SerializedName("list_total_count")
    private int list_total_count;

    @SerializedName("RESULT")
    private TbPublicWifiApiResultDto result;

    @SerializedName("row")
    private List<TbPublicWifiDto> wifis;


}
