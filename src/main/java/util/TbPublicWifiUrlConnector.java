package util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public final class TbPublicWifiUrlConnector {
    static private final String apiUrl = "http://openapi.seoul.go.kr:8088";
    static private final String key = "6c7179706d6a657035334d496e6a77";
    static private final String type = "json";
    static private final String serviceName = "TbPublicWifiInfo";
    static private URL getUrl(int start, int end, String wrdofc, String address) throws MalformedURLException {
        return new URL(String.format("%s/%s/%s/%s/%d/%d/%s/%s", apiUrl,key,type,serviceName,start,end,wrdofc,address));
    }

    private TbPublicWifiUrlConnector() {
    }

    static public HttpURLConnection getURLConnection(int start, int end, String wrdofc, String address) throws IOException {
        URL url = getUrl(start, end, wrdofc, address);
        return (HttpURLConnection) url.openConnection();
    }
    static public HttpURLConnection getURLConnection(int start, int end) throws IOException {
        return getURLConnection(start, end, "", "");
    }
}
