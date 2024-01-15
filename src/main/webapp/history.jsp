<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page import="java.util.List" %>
<%@ page import="repository.LocationHistoryRepository" %>
<%@ page import="service.LocationHistoryService" %>
<%@ page import="entity.LocationHistory" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
    <link href="table.css" rel="stylesheet" type="text/css">
    <title>위치 히스토리 목록</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="PAGETITLE" value="위치 히스토리 목록"/>
</jsp:include>
<%
    LocationHistoryRepository historyRepository = new LocationHistoryRepository();
    LocationHistoryService locationHistoryService = new LocationHistoryService(historyRepository);
    List<LocationHistory> historys = locationHistoryService.getList();
    pageContext.setAttribute("historys", historys);
%>
<table>
    <tr>
        <th>ID</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>조회일자</th>
        <th>비고</th>
    </tr>

    <c:if test="${empty historys}">
        <tr>
            <td colspan="5">정보가 없습니다.</td>
        </tr>
    </c:if>

    <c:if test="${not empty historys}">
        <c:forEach var="history" items="${historys}">
            <tr>
                <td>${history.id}</td>
                <td>${history.latitude}</td>
                <td>${history.longitude}</td>
                <td>${history.searchDateTime}</td>
                <td style="text-align: center"><a href="./location-history-delete.jsp?id=${history.id}"><button>삭제</button></a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>