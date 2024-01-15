<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="repository.BookmarkRepository" %>
<%@ page import="service.BookmarkService" %>
<%@ page import="dto.BookmarkDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <link href="table.css" rel="stylesheet" type="text/css">
    <title>북마크삭제</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="PAGETITLE" value="북마크 삭제"/>
</jsp:include>
<%
    String idParam = request.getParameter("id");
    BookmarkRepository bookmarkRepository = new BookmarkRepository();
    BookmarkService bookmarkService = new BookmarkService(bookmarkRepository);
    BookmarkDto bookmark = bookmarkService.getById(Integer.parseInt(idParam));
    pageContext.setAttribute("bookmark", bookmark);
%>
<p>북마크를 삭제하시겠습니까?</p>
<table>
    <tr>
        <th style="width: 30%">북마크 이름</th>
        <td>${bookmark.bookmarkName}</td>
    </tr>
    <tr>
        <th>와이파이명</th>
        <td>${bookmark.wifiManageNo}</td>
    </tr>
    <tr>
        <th>등록일자</th>
        <td>${bookmark.registerDateTime}</td>
    </tr>
    <tr>
        <td colspan="2" style="text-align: center">
            <a href="./bookmark-list.jsp">돌아가기</a>
            |
            <form method="post" action="/bookmark-del-action.jsp" style="display: contents">
                <input type="hidden" name="id" value="${bookmark.id}">
                <input type="submit" value="삭제"/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
