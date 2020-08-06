package com.iweb;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author azzhu
 * @create 2020-07-28 09:07:44
 */
@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1.获取ServletContext
        final ServletContext context = this.getServletContext();
        System.out.println("sec-old:"+context.getAttribute("age"));
        context.setAttribute("age",100);

        final String encoding = context.getInitParameter("encoding");
        System.out.println("sec:"+encoding);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
