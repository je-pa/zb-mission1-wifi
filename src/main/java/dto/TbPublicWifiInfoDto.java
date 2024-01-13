package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class TbPublicWifiInfoDto {
    @SerializedName("list_total_count")
    private int listTotalCount;

    @SerializedName("RESULT")
    private TbPublicWifiApiResultDto result;

    @SerializedName("row")
    private List<TbPublicWifiDto> wifis;


}
