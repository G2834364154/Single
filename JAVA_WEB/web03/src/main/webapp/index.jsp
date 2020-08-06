<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${pageContext.request.contextPath}
    <h1>hello，小jsp！！</h1>
    <h2>ssssss!!!!!</h2>
    <%--1.脚本--%>
    <%
        int a = 10;
        System.out.println(10);
    %>

    <%--2.声明成员变量--%>
    <%!
        {

        }
        int bb = 10;
        public int sum(int a,int b) {
            return a+b;
        }
    %>
    <%
        request.setAttribute("uer","ss");

        List<String> list = new ArrayList<>();
        list.add("aaaaa");
        list.add("aaaaa");
        list.add("aaaaa");
       // Object aaaaa = request.getAttribute("uer");
        System.out.println(sum(1,2));
    %>

    <%--3.输出表达式--%>
    <%=bb%>

    <%--遍历集合--%>
    <table border="1px solid red" cellpadding="0" cellspacing="0">
        <%
            for (String s : list) {
        %>
            <tr>
                <td>
                    <%=s%>
                </td>
            </tr>
        <%
            }
        %>
    </table>
    <%@include file="a.jsp"%>

    <hr/>
    <%
        //向4个域对象中放值，看什么地方可以取到
        //pageContext.setAttribute("reqKey","reqVal");
        request.setAttribute("reqKey","reqVal");
        session.setAttribute("reqKey","sessVal");
        application.setAttribute("reqKey","appVal");
    %>
    req:<%=request.getAttribute("reqKey")%>
    sess:<%=session.getAttribute("sessKey")%>
    app:<%=application.getAttribute("appKey")%>

    <a href="a.jsp">to a.jsp</a>

    ${sessionScope.reqKey}
</body>
</html>
