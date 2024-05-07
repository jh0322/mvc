<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.mvc03.model.MemberVO" %>
<%@ page import="java.util.ArrayList" %>
<%
    ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script type="text/javascript">
        function deleteFn(num) {
            location.href = "memberDelete.do?num="+num;
        }
    </script>
</head>
<body>
[MVC03 예제 - Controller+View]
<table class="table table-bordered">
    <tr>
        <td>번호</td>
        <td>아이디</td>
        <td>비밀번호</td>
        <td>이름</td>
        <td>나이</td>
        <td>이메일</td>
        <td>전화번호</td>
    </tr>
    <% for (MemberVO vo : list) { %>
    <tr>
        <td><%=vo.getNum()%></td>
        <td><a href="memberContent.do?num=<%=vo.getNum()%>"><%=vo.getId()%></a></td>
        <td><%=vo.getPassword()%></td>
        <td><%=vo.getName()%></td>
        <td><%=vo.getAge()%></td>
        <td><%=vo.getEmail()%></td>
        <td><%=vo.getPhone()%></td>
        <td><input type="button" value="삭제" class="btn btn-danger" onclick="deleteFn(<%=vo.getNum()%>)"></td>
    </tr>
    <% } %>
    <td colspan="8" align="right"><input type="button" value="회원가입" class="btn btn-primary" onclick="location.href='member/memberRegister.html'"></td>
</table>
</body>
</html>
