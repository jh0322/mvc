<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
String name = request.getParameter("name");
String age = request.getParameter("age");
String email = request.getParameter("email");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
 이름: <%=name%><br>
 나이: <%=age%><br>
 이메일: <%=email%>
</body>
</html>
