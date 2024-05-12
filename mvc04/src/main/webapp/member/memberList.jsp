<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//    ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
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
[MVC03 예제 - Controller+View(JSTL+EL)]
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
    <c:forEach var="vo" items="${list}">
    <tr>
        <td>${vo.num}</td>
        <td><a href="memberContent.do?num=${vo.num}">${vo.id}</a></td>
        <td>${vo.password}</td>
        <td>${vo.name}</td>
        <td>${vo.age}</td>
        <td>${vo.email}</td>
        <td>${vo.phone}</td>
        <td><input type="button" value="삭제" class="btn btn-danger" onclick="deleteFn(${vo.num})"></td>
    </tr>
    </c:forEach>
    <td colspan="8" align="right"><input type="button" value="회원가입" class="btn btn-primary" onclick="location.href='/memberRegister.do'"></td>
</table>
</body>
</html>
