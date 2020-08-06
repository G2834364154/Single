<%@ page import="com.iweb.beans.User" %>
<%@ page import="com.iweb.utils.Constants" %>
<%@ page import="com.iweb.beans.Customer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>欢迎<%=((User)(session.getAttribute(Constants.LOGIG_USER))).getUsername()%>>来到xxxx网站/系统</h1>

    <h1>客户列表数据</h1>
    <table border="1px solid red" cellspacing="0" cellpadding="0">
        <%
            Object attribute = request.getAttribute(Constants.CUSTS);
            List<Customer> custs = (List<Customer>) attribute;

            for (Customer cust : custs) {
         %>
            <tr>
                <td>
                    <%=cust.getName()%>
                </td>
                <td>
                    <%=cust.getBirthday()%>
                </td>
                <td>
                    <%=cust.getGender()%>
                </td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
