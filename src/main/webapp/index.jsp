<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
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
    List<TbPublicWifiDto> wifi = service.list();
%>
<table>
    <caption>이 테이블은 저장된 와이파이 정보입니다.</caption>
    <tr>
        <th>거리(Km)</th>
        <th>관리번호</th>
        <th>자치구</th>
        <th>와이파이명</th>
        <th>도로명주소</th>
        <th>상세주소</th>
        <th>설치위치(층)</th>
        <th>설치유형</th>
        <th>설치기관</th>
        <th>서비스구분</th>
        <th>망종류</th>
        <th>설치년도</th>
        <th>실내외구분</th>
        <th>WIFI접속환경</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>작업일자</th>
    </tr>

    <c:if test="${empty wifi}">
        <tr>
            <td colspan="17">위치 정보를 입력한 후에 조회해 주세요.</td>
        </tr>
        <tr>
            <td colspan="17">위치 정보를 입력한 후에 조회해 주세요.</td>
        </tr>
        <tr>
            <td colspan="17">위치 정보를 입력한 후에 조회해 주세요.</td>
        </tr>
    </c:if>

    <c:if test="${not empty wifi}">
        <c:forEach var="wifi" items="${wifi}">
            <tr>
                <td><fmt:formatNumber value="${wifi.distance}" pattern="0.####" /></td>
                <td>${wifi.manageNo}</td>
                <td>${wifi.wrdofc}</td>
                <td><a href="./detail.jsp?mgrNo=${wifi.manageNo}">${wifi.mainName}</a></td>
                <td>${wifi.address1}</td>
                <td>${wifi.address2}</td>
                <td>${wifi.installFloor}</td>
                <td>${wifi.installType}</td>
                <td>${wifi.installMBY}</td>
                <td>${wifi.serviceSegment}</td>
                <td>${wifi.cmcwr}</td>
                <td>${wifi.installYear}</td>
                <td>${wifi.inoutDoor}</td>
                <td>${wifi.remars3}</td>
                <td>${wifi.latitude}</td>
                <td>${wifi.longitude}</td>
                <td>${wifi.workDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.S"))}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>