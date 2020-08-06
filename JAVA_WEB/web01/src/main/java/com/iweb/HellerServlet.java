package com.iweb;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author azzhu
 * @create 2020-07-27 11:03:02
 */
public class HellerServlet implements Servlet {
    public HellerServlet() {
        System.out.println("HellerServlet() ......");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init ......");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig .....");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service ......");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy .......");
    }
}
