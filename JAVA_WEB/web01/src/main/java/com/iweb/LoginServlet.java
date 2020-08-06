package com.iweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author azzhu
 * @create 2020-07-27 14:48:01
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取到请求参数
        final String uname = request.getParameter("uname");
        final String pwd = request.getParameter("pwd");

        // 2.应该调用service去执行查询操作 admin /admin
        // TODO userService.login(uname,pwd);
        // TODO 测试一下有没有请求乱码的问题 ，如何解决？get、post，还是都有，还是只有一个？
        // if(user != NULL)给一个文字响应

        String result = "";
        if("admin".equals(uname) && "admin".equals(pwd)) {
            result = "登录成功，欢迎"+uname;
            System.out.println("登录成功....."+uname);
        } else {
            result = "登录失败";
            System.out.println("登录失败.....");
        }

        // 3.将处理结果返回到浏览器
        response.setContentType("text/html;charset=utf-8");
        // TODO  能否写标签 ？？？？？
        response.getWriter().write(result);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
