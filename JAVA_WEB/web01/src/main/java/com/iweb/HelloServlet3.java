package com.iweb;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author azzhu
 * @create 2020-07-27 13:37:22
 */
@WebServlet(name = "HelloServlet3",urlPatterns = {"/hello3"},
        initParams = {
        @WebInitParam(name = "age",value = "12"),
        @WebInitParam(name = "encoding",value = "utf-8"),
    },loadOnStartup = 1)
public class HelloServlet3 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("aaaaaa");
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("bbbbbb");

        // 1.关于ServletConfig的使用
        ServletConfig config = this.getServletConfig();

        //1.1 拿到名字
        System.out.println(config.getServletName());

        //1.2 获取上下文信息
        final ServletContext context = config.getServletContext();
        System.out.println("当前项目名称:"+context.getContextPath());

        // 1.3 根据key获取到初始化参数
        System.out.println(config.getInitParameter("age"));

        // 1.4 获取所有的初始化参数
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            final String name = initParameterNames.nextElement();
            final String val = config.getInitParameter(name);
            System.out.println(name+":"+val);
        }
    }
}
