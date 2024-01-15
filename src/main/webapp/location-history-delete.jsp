<%@ page import="repository.LocationHistoryRepository" %>
<%@ page import="service.LocationHistoryService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>위치히스토리 지우기</title>
</head>
<body>
<%
    String idParam = request.getParameter("id");
    if(idParam != null){
        LocationHistoryRepository historyRepository = new LocationHistoryRepository();
        LocationHistoryService locationHistoryService = new LocationHistoryService(historyRepository);
        int result = locationHistoryService.deleteById(Integer.parseInt(idParam));
        if(result ==1){
            out.print("<script>alert('히스토리 정보를 삭제하였습니다.');</script>");
            out.print("<script>location.href='/history.jsp'</script>");
        }
    }
%>
</body>
</html>
