<%@ page import="entity.BookmarkGroup" %>
<%@ page import="repository.BookmarkGroupRepository" %>
<%@ page import="service.BookmarkGroupService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>

<html>
<head>
    <link href="table.css" rel="stylesheet" type="text/css">
    <title>북마크 그룹 삭제</title>
</head>
<body>
<%
    String idParam = request.getParameter("id");
    BookmarkGroup bookmarkGroup = null;
    if(idParam != null){
        BookmarkGroupRepository bookmarkGroupRepository = new BookmarkGroupRepository();
        BookmarkGroupService bookmarkGroupService = new BookmarkGroupService(bookmarkGroupRepository);
        bookmarkGroup = bookmarkGroupService.get(Integer.parseInt(idParam));
        pageContext.setAttribute("bookmarkGroup", bookmarkGroup);
    }
%>
<jsp:include page="header.jsp">
    <jsp:param name="PAGETITLE" value="북마크 그룹 삭제"/>
</jsp:include>
<p>북마크 그룹 이름을 삭제하시겠습니까?</p>
<form method="post" action="/bookmark-group-delete-action.jsp">
    <table>
        <tr>
            <th style="width: 20%">북마크 이름</th>
            <td>
                <input type="text" id="name" name="name" required value="<%=((bookmarkGroup != null) ? bookmarkGroup.getName() : "")%>"/>
            </td>
        </tr>
        <tr>
            <th>순서</th>
            <td>
                <input type="text" id="order" name="order" required value="<%=((bookmarkGroup != null) ? bookmarkGroup.getOrder() : 0)%>"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center">
                <a href="/bookmark-group.jsp">돌아가기</a>
                |
                <form>
                    <input type="hidden" name="id" value="<%=((bookmarkGroup != null) ? bookmarkGroup.getId() : 0)%>">
                    <input type="submit" value="삭제"/>
                </form>
            </td>
        </tr>
    </table>

</form>
</body>
</html>
