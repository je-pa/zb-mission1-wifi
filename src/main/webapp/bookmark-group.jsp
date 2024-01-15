<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="repository.BookmarkGroupRepository" %>
<%@ page import="service.BookmarkGroupService" %>
<%@ page import="entity.BookmarkGroup" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
    <link href="table.css" rel="stylesheet" type="text/css">
    <title>북마크 그룹</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="PAGETITLE" value="북마크 그룹"/>
</jsp:include>
<%
    BookmarkGroupRepository bookmarkGroupRepository = new BookmarkGroupRepository();
    BookmarkGroupService bookmarkGroupService = new BookmarkGroupService(bookmarkGroupRepository);
    List<BookmarkGroup> bookmarkGroups = bookmarkGroupService.getList();
    pageContext.setAttribute("bookmarkGroups", bookmarkGroups);
%>
<a href="/bookmark-group-add.jsp"><button>북마크 그룹 이름 추가</button></a>
<table>
    <tr>
        <th>ID</th>
        <th>북마크 이름</th>
        <th>순서</th>
        <th>등록일자</th>
        <th>수정일자</th>
        <th>비고</th>
    </tr>

    <c:if test="${empty bookmarkGroups}">
        <tr>
            <td colspan="6">북마크 그룹이 없습니다.</td>
        </tr>
    </c:if>
    <c:if test="${not empty bookmarkGroups}">
        <c:forEach var="bookmarkGroup" items="${bookmarkGroups}">
            <tr>
                <td>${bookmarkGroup.id}</td>
                <td>${bookmarkGroup.name}</td>
                <td>${bookmarkGroup.order}</td>
                <td>${bookmarkGroup.registerDateTime}</td>
                <td>${bookmarkGroup.updatedDateTime}</td>
                <td style="text-align: center">
                    <a href="./bookmark-group-edit.jsp?id=${bookmarkGroup.id}">수정</a>
                    <a href="./bookmark-group-delete.jsp?id=${bookmarkGroup.id}">삭제</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>