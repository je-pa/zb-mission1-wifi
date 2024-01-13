package service;

import com.google.gson.Gson;
import dto.TbPublicWifiDto;
import dto.TbPublicWifiInfoDto;
import dto.TbPublicWifiInfoResponseDto;
import dto.WifiDto;
import repository.WifiRepository;
import util.TbPublicWifiUrlConnector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class WifiService {
    WifiRepository wifiRepository;

    public WifiService(WifiRepository wifiRepository) {
        this.wifiRepository = wifiRepository;
    }

    public int loadWifi() {
        wifiRepository.deleteAll();
        return wifiRepository.addAll(getAllWifi());
    }

    public TbPublicWifiDto detail() {
        return null;
    }

    public List<WifiDto> list(double lat, double lnt) {
        return wifiRepository.getListByLatAndLnt(lat, lnt);
    }

    private List<TbPublicWifiDto> getAllWifi(){
        int start = 1;
        final int MAX = 1000;
        int end = MAX;
        int listTotalCount;
        List<TbPublicWifiDto> allWifi = new ArrayList<>();
        do{
            TbPublicWifiInfoDto dto = getTbPublicWifiInfoDto(start, end);
            allWifi.addAll(dto.getWifis());
            listTotalCount = dto.getListTotalCount();
            start+=MAX;
            end+=MAX;
        }while (start <= listTotalCount);

        return allWifi;
    }

    private TbPublicWifiInfoDto getTbPublicWifiInfoDto(int start, int end){
        HttpURLConnection conn = null;
        StringBuilder sb = new StringBuilder();
        try {
            conn = TbPublicWifiUrlConnector.getURLConnection(start,end);
            BufferedReader rd;

            // 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line).append("\n");
            }
            rd.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        conn.disconnect();
        Gson gson = new Gson();
        return gson.fromJson(sb.toString(), TbPublicWifiInfoResponseDto.class).getPublicWifiInfo();
    }
}
