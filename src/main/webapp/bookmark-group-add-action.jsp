<%@ page import="repository.BookmarkGroupRepository" %>
<%@ page import="service.BookmarkGroupService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    String order = request.getParameter("order");

    BookmarkGroupRepository bookmarkGroupRepository = new BookmarkGroupRepository();
    BookmarkGroupService bookmarkGroupService = new BookmarkGroupService(bookmarkGroupRepository);
    int count =0;
    if(name!=null && order!=null){
        count = bookmarkGroupService.add(name, Integer.parseInt(order));
    }
    if(count==1){
        out.print("<script>alert('북마크 그룹 정보를 추가하였습니다.');</script>");
        out.print("<script>location.href='/bookmark-group.jsp'</script>");
    }
%>