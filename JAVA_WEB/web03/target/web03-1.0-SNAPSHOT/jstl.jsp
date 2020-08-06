<%@ page import="com.iweb.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL的使用-1</title>
</head>
<body>
<%
    List<User> users = new ArrayList<>();
    final User u1 = new User();
    u1.setUsername("abc");
    final User u2 = new User();
    u2.setUsername("bcd");
    final User u3 = new User();
    u3.setUsername("eee");
    users.add(u1);
    users.add(u2);
    users.add(u3);
    request.setAttribute("users",users);
%>
    <%--1.c:if
        c:choose c:when--可有多个 c:otherwise
    --%>
    <c:if test="${not empty users}">
        <%--遍历集合，放到表格中--%>
        <table border="1px solid red" cellpadding="0" cellspacing="0">
            <%--
            items:你要遍历的集合，可以是数组，map、list等等
            var:给遍历的每个元素，起一个变量名
            增强for
              --%>
            <c:forEach items="${users}" var="user" varStatus="vs">
                <tr style="${vs.count % 2==0?'color:red':''}">
                    <td>${vs.index}--->${user.username}--->${vs.count}</td>
                    <td>${user.password}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <%--2.c:foreach--%>
</body>
</html>
