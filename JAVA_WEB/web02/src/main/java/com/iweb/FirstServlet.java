package com.iweb;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author azzhu
 * @create 2020-07-28 08:55:11
 */
@WebServlet("/firstServlet")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取ServletContext
      //  ServletContext context = this.getServletConfig().getServletContext();
         ServletContext context = this.getServletContext();

         // 2.作用
         // 2.1 获取项目部署的名称:工程名称跟部署的名称，毛的关系都没有！！一般我们搞一样的
        String contextPath = context.getContextPath();
        // 2.2 获取资源的真实路径: /opt/aa/1.jpg c:\\aa\\1.jpg
        final String realPath = context.getRealPath("index.html");
        // 2.3 获取文件的扩展名
        final String mimeType = context.getMimeType("img/2.jpg");
        // 2.4 共享资源，而且它我们称之为域对象 是Web中最大的一个域对象[在web资源之间进行数据传递]
        System.out.println("first-new:"+context.getAttribute("age"));
        context.setAttribute("age",10);
        System.out.println("first-old:"+context.getAttribute("age"));
        System.out.println("contextPath:"+contextPath);
        System.out.println("realPath"+realPath);
        System.out.println("mimeType"+mimeType);

        final String encoding = context.getInitParameter("encoding");
        System.out.println("fir:"+encoding);

        System.out.println("=====================");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
