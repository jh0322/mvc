<%@ page import="com.example.mvc03.model.MemberVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    MemberVO vo = (MemberVO) request.getAttribute("vo");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
Controller에서 받은 데이터 출력
이름: <%=vo.getName()%><br>
나이: <%=vo.getAge()%><br>
이메일: <%=vo.getEmail()%><br>
</body>
</html>
