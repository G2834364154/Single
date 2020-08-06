package com.iweb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author azzhu
 * @create 2020-07-28 10:28:06
 */
@WebServlet("/thirdServlet")
public class ThirdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //关于request的使用
        //1.1 获取请求参数:返回值值都是String，xxx.parseXxx()
        // 1.获取单个请求参数 ---> 使用较多
        final String uname = request.getParameter("uname");
        System.out.println(uname);
        // 2.拿到所有参数的map数据 ---》 map ---JavaBean进行映射 ，BeanUtils
        final Map<String, String[]> parameterMap = request.getParameterMap();
        // 3.拿到复选框的所有value值
        final String[] hobbies = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));
        System.out.println("==============>");
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            //TODO uname=[Ljava.lang.String;@28138716
            // TODO uname=zz
            System.out.println(entry);
        }
        System.out.println("==============>");
        //1.2 获取到请求头信息
        // 1.获取某个请求头信息，比如userAgent，若做文件下载，文件名为中文的
        // 话，可能要考虑一个浏览器兼容性问题 ，编码不一样
        final String userAgent = request.getHeader("user-agent");
        System.out.println("浏览器信息:"+userAgent);
        System.out.println("==============>");
        //2.了解：拿到所有的头信息
        final Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }

        //get请求，拿到url后面的所有请参数  age=10&name=zs
        // http://xxx:8080/aa/firServlet?age=10&name=zs
        request.getQueryString();
        //TODO 拼接出 http://xxx:8080/aa
        System.out.println("----------------aaaa -----");
        //1.3 其他非常重要的方法
        //1.获取项目名称 ---》 常用这种方式
        final String contextPath = request.getContextPath();
        System.out.println("contextPath:"+contextPath);
        //2.回归到context的作用 ----》参考ServletContext
        final ServletContext context = request.getServletContext();
        //3.获取servlet的路径---》了解
        final String servletPath = request.getServletPath();
        System.out.println("servletPath:"+servletPath);

        //4.可以作为域对象传递数据:只能在一次请求中有效
        request.setAttribute("age",10);
        System.out.println("getAttribute:"+request.getAttribute("age"));
        //5.解决post请求乱码的问题

        //6.转发 ---》单独说 ----》代表小哥
        System.out.println("===================>>>>>>>>>>>>");
        System.out.println("缺钱了，借我点钱");
        request.setAttribute("money",100);
       // System.out.println("葛说：没钱，我去帮你想办法....");
        //6.1 在服务端获取一个派发器
        /*final RequestDispatcher dispat = request.getRequestDispatcher("LWBServlet");
        dispat.forward(request, response);*/
        /*System.out.println(request.getAttribute("msg"));
        request.getRequestDispatcher("LWBServlet").forward(request, response);*/
        System.out.println("葛说：没钱，你去找王....");
        //TODO 你把项目名称去掉，测试一下
        response.sendRedirect(request.getContextPath()+"/LWBServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
