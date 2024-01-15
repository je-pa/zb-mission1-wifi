<%@ page import="repository.BookmarkRepository" %>
<%@ page import="service.BookmarkService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    String idParam = request.getParameter("id");
    if(idParam != null){
        BookmarkRepository bookmarkRepository = new BookmarkRepository();
        BookmarkService bookmarkGroupService = new BookmarkService(bookmarkRepository);
        int count = bookmarkGroupService.deleteById(Integer.parseInt(idParam));
        if(count==1){
            out.print("<script>alert('북마크 정보를 삭제하였습니다.');</script>");
            out.print("<script>location.href='/bookmark-list.jsp'</script>");
        }
    }
%>