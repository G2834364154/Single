<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        $(function () {
            $("#code").click(function () {
                $(this).attr("src","codeServlet?t="+Math.random());
            });
        })
    </script>
</head>
<body>
    <form action="userServlet" method="post">
        <%--version1.0  ====》 version2.0，使用反射造一个BaseServlet--%>
        <input type="hidden" name="op" value="login">
        用户名:<input type="text" name="uname" /> <br/>
        密码:<input type="password" name="pwd" /> <br/>
        验证码:<input type="text" name="code" />
            <img src="codeServlet" id="code">
            <br/>
        <input type="submit" value="登录" />
    </form>
</body>
</html>
