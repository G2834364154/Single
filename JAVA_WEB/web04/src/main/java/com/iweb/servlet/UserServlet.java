package com.iweb.servlet;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.iweb.beans.Customer;
import com.iweb.beans.User;
import com.iweb.service.CustomerService;
import com.iweb.service.UserService;
import com.iweb.service.impl.CustomerServiceImpl;
import com.iweb.service.impl.UserServiceImpl;
import com.iweb.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author azzhu
 * @create 2020-07-29 11:12:46
 */
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //2.获取登录信息 req.getparametMap()
        final String op = req.getParameter("op");

        if(StrUtil.equals("login",op)) {
            //登录
            login(req,resp);
        } else if(StrUtil.equals("regist",op)) {
            //注册
        } else if(StrUtil.equals("del",op)) {

        }
    }

    /**
     * 登录功能实现
     * @param req
     * @param resp
     */
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取用户名、密码、验证码
        final String uname = req.getParameter("uname");
        final String pwd = req.getParameter("pwd");

        final String code = req.getParameter("code");

        //调用Userservice
        final User loginUser = userService.login(uname, pwd);
        if(ObjectUtil.isNotNull(loginUser)) {
            //登录成功,成功之后去哪？？？？WEB-INF/index.jsp
            req.getSession().setAttribute(Constants.LOGIG_USER,loginUser);
            //==========整合Customer列表数据 start===============
            final List<Customer> custs = customerService.getAll();
            req.setAttribute(Constants.CUSTS,custs);
            //==========整合Customer列表数据 end===============
           // resp.sendRedirect(req.getContextPath()+"/WEB-INF/index.jsp");
            req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
        } else {
            //失败，去哪？？？？？ login.jsp
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
