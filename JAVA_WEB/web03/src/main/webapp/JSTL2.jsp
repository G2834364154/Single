<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>JSTL的其他标签</title>
</head>
<body>
    <%--1.模拟多重if
        c:choose跟c:when能否写东西？？？？自测
    --%>

    <c:choose>
        <c:when test="${param.age > 60}">
            老年人
        </c:when>
        <c:when test="${param.age > 40}">
            青年人
        </c:when>
        <c:otherwise>
            小孩子
        </c:otherwise>
    </c:choose>
    <hr/>
    <%--2.c:out--%>
    <%
        request.setAttribute("req","reqval");
    %>
    <c:out value="${req}"/> <br>
    <c:out value="${req222}" default="abc"/> <br>

    <%--3.c:set
        蛮好用的，${pageContext.request.contextPath}
        var:变量名
        value:变量的值
        scope:你这个变量的作用范围
    --%>
    <c:set var="ctx" value="${pageContext.request.contextPath}" scope="application"></c:set>
    ${ctx}

    <%--4.其他 --自己写写
        c:url
        c:redirect
        c:forTokens
    --%>

    <%
        request.setAttribute("time", new Date());
    %>
    <br/>
    ${time} <br/>
    <%--了解--%>
    <fmt:formatNumber value="999999" pattern="###,###,##"/>

    <c:set var="str" value="stringStRiNg"/>
    <c:out value="${str} = ${fn:length(str)}"/>
    </body>

</html>
