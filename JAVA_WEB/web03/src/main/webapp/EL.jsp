<%@ page import="com.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("uname","张三年");
        final User user = new User();
        user.setUsername("zzz");
        session.setAttribute("loginUser",user);

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

        Map<String,User> map = new HashMap<>();
        map.put("L1001",u1);
        map.put("L1002",u2);
        map.put("L1003",u3);
        request.setAttribute("map",map);
    %>

    <%----%>
    获取单值: <%=request.getAttribute("unamsssse")%> <br/>
    获取单值: <%=request.getAttribute("unamsssse")%> <br/>
    <hr />
    获取单值: <%=request.getAttribute("uname")%> <br/>
    获取单值new: ${uname} <br/>
    <%
        final Object obj = session.getAttribute("loginUser");
        User uu = (User) obj;
    %>
    获取对象的某个值:<%=uu.getUsername()%> <br/>
    获取对象的某个值111new:${sessionScope.loginUser.username} <br/>

    获取list的数据：${users.get(0).username}    <br/>
    获取list的数据22222：${users[0].username}    <br/>
    获取map的数据：${map.get("L1001").username} <br/>

    <hr/>
    <%--执行运算
        xml,html &gt;
    --%>
    1>2??: ${1 > 2}  <br/>
    1>2??: ${1 gt 2}<br/>
    1==2??: ${1 eq 2}<br/>
    1<2??: ${1 lt 2}<br/>
    1>2或者3>1 ${1 gt 2 or 3 gt 1}<br/>
    1+2=？： ${1 + 2}<br/>

    判空1:${empty users}
    判空2:${! empty users}
    判空3:${not empty users}

    三元运算符 ：
    <input type="checkbox" ${not empty loginUser ? 'checked':''}>你

    <hr/>
    age:${param.age}  <br/>
    项目名称：${pageContext.request.contextPath} <br/>
    图片：
    <img src="${pageContext.request.contextPath}/img/2.jpg" width="100px">
</body>
</html>
