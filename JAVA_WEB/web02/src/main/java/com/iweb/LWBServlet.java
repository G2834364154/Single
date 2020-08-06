package com.iweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author azzhu
 * @create 2020-07-28 11:45:13
 */
@WebServlet("/LWBServlet")
public class LWBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //拿到你要借的钱
        final Object money = request.getAttribute("money");
        System.out.println("小葛想老王八借的钱:"+money);

        //有又没，老王八跟葛大说
       request.setAttribute("msg","给你100块！！！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
