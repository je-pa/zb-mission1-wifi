<%@ page import="repository.BookmarkGroupRepository" %>
<%@ page import="service.BookmarkGroupService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    request.setCharacterEncoding("utf-8");
    String idParam = request.getParameter("id");
    if(idParam != null){
        BookmarkGroupRepository bookmarkGroupRepository = new BookmarkGroupRepository();
        BookmarkGroupService bookmarkGroupService = new BookmarkGroupService(bookmarkGroupRepository);
        int count = bookmarkGroupService.delete(Integer.parseInt(idParam));
        if(count==1){
            out.print("<script>alert('북마크 그룹 정보를 삭제하였습니다.');</script>");
            out.print("<script>location.href='./bookmark-group.jsp'</script>");
        }
    }
%>