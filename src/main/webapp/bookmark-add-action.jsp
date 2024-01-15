<%@ page import="repository.BookmarkRepository" %>
<%@ page import="service.BookmarkService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
  request.setCharacterEncoding("utf-8");
  String wifiManageNo = request.getParameter("wifi_manage_no");
  String bookmarkGroupId = request.getParameter("bookmark_group_id");

  if(wifiManageNo != null && bookmarkGroupId != null){
    BookmarkRepository bookmarkRepository = new BookmarkRepository();
    BookmarkService bookmarkService = new BookmarkService(bookmarkRepository);
    int count = bookmarkService.add(wifiManageNo, Integer.parseInt(bookmarkGroupId));
    if(count==1){
      out.print("<script>alert('북마크 정보를 추가하였습니다.');</script>");
      out.print("<script>location.href='/bookmark-list.jsp'</script>");
    }
  }
%>