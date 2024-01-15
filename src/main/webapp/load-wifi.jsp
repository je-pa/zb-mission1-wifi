<%@ page import="service.WifiService" %>
<%@ page import="repository.WifiRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Oen API 와이파이 정보 가져오기</title>
</head>
<body>
<%
    WifiRepository wifiRepository = new WifiRepository();
    WifiService wifiService = new WifiService(wifiRepository);

    int count = wifiService.loadWifi();
%>
<h1 style="text-align: center"><%=count%>개의 WIFI 정보를 정상적으로 저장하였습니다.</h1>
<p style="text-align: center"><a href="/">홈 으로 가기</a></p>
</body>
</html>
