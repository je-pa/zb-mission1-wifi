<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="repository.BookmarkRepository" %>
<%@ page import="service.BookmarkService" %>
<%@ page import="dto.BookmarkDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
    <link href="table.css" rel="stylesheet" type="text/css">
    <title>북마크 목록</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="PAGETITLE" value="북마크 목록"/>
</jsp:include>
<%
    BookmarkRepository bookmarkRepository = new BookmarkRepository();
    BookmarkService bookmarkService = new BookmarkService(bookmarkRepository);
    List<BookmarkDto> bookmarks = bookmarkService.getList();
    pageContext.setAttribute("bookmarks", bookmarks);
%>
<table>
    <tr>
        <th>ID</th>
        <th>북마크 이름</th>
        <th>와이파이명</th>
        <th>등록일자</th>
        <th>비고</th>
    </tr>

    <c:if test="${empty bookmarks}">
        <tr>
            <td colspan="17">북마크가 없습니다.</td>
        </tr>
    </c:if>

    <c:if test="${not empty bookmarks}">
        <c:forEach var="bookmark" items="${bookmarks}">
            <tr>
                <td>${bookmark.id}</td>
                <td>${bookmark.bookmarkName}</td>
                <td><a href="./detail.jsp?mgrNo=${bookmark.wifiManageNo}">${bookmark.wifiName}</a></td>
                <td>${bookmark.registerDateTime}</td>
                <td style="text-align: center"><a href="/bookmark-del.jsp?id=${bookmark.id}">삭제</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>