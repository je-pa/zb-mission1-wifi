<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>

<html>
<head>
    <link href="table.css" rel="stylesheet" type="text/css">
    <title>북마크 그룹 추가</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="PAGETITLE" value="북마크 그룹 추가"/>
</jsp:include>
<form method="post" action="/bookmark-group-add-action.jsp">
    <table>
        <tr>
            <th style="width: 20%">북마크 이름</th>
            <td>
                <input type="text" id="name" name="name" required value=""/>
            </td>
        </tr>
        <tr>
            <th>순서</th>
            <td>
                <input type="text" id="order" name="order" required value=""/>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center">
                <form>
                    <input type="submit" value="추가"/>
                </form>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
