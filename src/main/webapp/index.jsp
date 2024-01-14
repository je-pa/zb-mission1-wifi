<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="service.WifiService" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.List" %>
<%@ page import="repository.WifiRepository" %>
<%@ page import="dto.WifiDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
    <link href="table.css" rel="stylesheet" type="text/css">
    <title>와이파이 정보 구하기</title>
    <script type="text/javascript">
        document.addEventListener("DOMContentLoaded", function () {
            const params = getUrlParams();
            if (params.lat) {
                document.getElementById("lat").value = params.lat;
            }
            if (params.lnt) {
                document.getElementById("lnt").value = params.lnt;
            }
        });

        function getUrlParams() {
            const params = {};
            window.location.search.replace(/[?&]+([^=&]+)=([^&]*)/gi,
                function (str, key, value) {
                    params[key] = value;
                }
            );
            return params;
        }

        function getLocation() {
            const lat = document.getElementById("lat");
            const lnt = document.getElementById("lnt");

            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(
                    function (position) {
                        lat.value = position.coords.latitude;
                        lnt.value = position.coords.longitude;
                    }, function (error) {
                        alert(error);
                    })
            }
        }
    </script>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="PAGETITLE" value="와이파이 정보 구하기"/>
</jsp:include>
<%
    WifiRepository wifiRepository = new WifiRepository();
    WifiService wifiService = new WifiService(wifiRepository);
    String latParam = request.getParameter("lat");
    String lntParam = request.getParameter("lnt");
    if(latParam != null && lntParam != null){
        double lat = Double.parseDouble(latParam);
        double lnt = Double.parseDouble(lntParam);
        System.out.println(" 호ㅓㅏ면");
        List<WifiDto> wifis = wifiService.list(lat, lnt);
        pageContext.setAttribute("wifis", wifis);

//        System.out.println(wifis.get(0).getManageNo() + " 호ㅓㅏ면");
    }
%>
<form method="GET" action="/">
    <label>LAT:</label>
    <input type="text" id="lat" name="lat" value="0.0"/>
    <label>, LNT:</label>
    <input type="text" id="lnt" name="lnt" value="0.0"/>
    <input type="button" value="내 위치 가져오기" onclick="getLocation()"/>
    <input type="submit" value="근처 WIFI 정보 보기"/>
</form>
<table>
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

    <c:if test="${empty wifis}">
        <tr>
            <td colspan="17">위치 정보를 입력한 후에 조회해 주세요.</td>
        </tr>
    </c:if>

    <c:if test="${not empty wifis}">
        <c:forEach var="wifi" items="${wifis}">
            <tr>
                <td><fmt:formatNumber value="${wifi.distance}" pattern="0.####" /></td>
                <td>${wifi.manageNo}</td>
                <td>${wifi.wrdofc}</td>
                <td><a href="/detail.jsp?mgrNo=${wifi.manageNo}">${wifi.mainName}</a></td>
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