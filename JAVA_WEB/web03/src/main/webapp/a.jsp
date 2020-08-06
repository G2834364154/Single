<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>我是悲催的h2</h2>
    req:<%=request.getAttribute("reqKey")%>
    sess:<%=session.getAttribute("sessKey")%>
    app:<%=application.getAttribute("appKey")%>
</body>
</html>
