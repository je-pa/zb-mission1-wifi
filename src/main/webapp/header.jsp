<%--
  Created by IntelliJ IDEA.
  User: qkrwl
  Date: 2024-01-05
  Time: 오후 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String pageTitle = request.getParameter("PAGETITLE");
%>
<h1><%= pageTitle %>
</h1>
<p>
    <a href="/">홈</a> |
    <a href="/history.jsp">위치 히스토리 목록</a> |
    <a href="/load-wifi.jsp">Open API 와이파이 정보 가져오기</a> |
    <a href="/bookmark-list.jsp">북마크 보기</a> |
    <a href="bookmark-group.jsp">북마크 그룹 관리</a>
</p>
