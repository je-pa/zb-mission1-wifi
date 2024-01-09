<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="dto.TbPublicWifiDto" %>
<%@ page import="service.WifiService" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
    <link href="table.css" rel="stylesheet" type="text/css">
    <title>와이파이 정보 구하기</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="PAGETITLE" value="와이파이 정보 구하기"/>
</jsp:include>
<%
    WifiService service = new WifiService();
    TbPublicWifiDto wifi = service.detail();
%>

    <table>
        <tr>
            <th style="width: 30%">거리(Km)</th>
            <td><fmt:formatNumber value="${wifi.distance}" pattern="0.####" /></td>
        </tr>
        <tr>
            <th>관리번호</th>
            <td>${wifi.manageNo}</td>
        </tr>
        <tr>
            <th>자치구</th>
            <td>${wifi.wrdofc}</td>
        </tr>
        <tr>
            <th>와이파이명</th>
            <td><a href="#">${wifi.mainName}</a></td>
        </tr>
        <tr>
            <th>도로명주소</th>
            <td>${wifi.address1}</td>
        </tr>
        <tr>
            <th>상세주소</th>
            <td>${wifi.address2}</td>
        </tr>
        <tr>
            <th>설치위치(층)</th>
            <td>${wifi.installFloor}</td>
        </tr>
        <tr>
            <th>설치유형</th>
            <td>${wifi.installType}</td>
        </tr>
        <tr>
            <th>설치기관</th>
            <td>${wifi.installMBY}</td>
        </tr>
        <tr>
            <th>서비스구분</th>
            <td>${wifi.serviceSegment}</td>
        </tr>
        <tr>
            <th>망종류</th>
            <td>${wifi.cmcwr}</td>
        </tr>
        <tr>
            <th>설치년도</th>
            <td>${wifi.installYear}</td>
        </tr>
        <tr>
            <th>실내외구분</th>
            <td>${wifi.inoutDoor}</td>
        </tr>
        <tr>
            <th>WIFI접속환경</th>
            <td>${wifi.remars3}</td>
        </tr>
        <tr>
            <th>X좌표</th>
            <td>${wifi.latitude}</td>
        </tr>
        <tr>
            <th>Y좌표</th>
            <td>${wifi.longitude}</td>
        </tr>
        <tr>
            <th>작업일자</th>
            <td>${wifi.workDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.S"))}</td>
        </tr>
    </table>

</body>
</html>
