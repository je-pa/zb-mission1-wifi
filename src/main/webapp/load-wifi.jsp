<%@ page import="service.WifiService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    WifiService service = new WifiService();
    service.loadWifi();
%>
<a href="/">홈 으로 가기</a>
</body>
</html>
