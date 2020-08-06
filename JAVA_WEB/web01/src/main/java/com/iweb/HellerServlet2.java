package com.iweb;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author azzhu
 * @create 2020-07-27 11:03:02
 */
@WebServlet("/hello")
public class HellerServlet2 implements Servlet {
    public HellerServlet2() {
        System.out.println("HellerServlet2() ......");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init2 ......");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig2 .....");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service2 ......");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy2 .......");
    }
}
