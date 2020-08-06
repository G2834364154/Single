package servlet;

import beans.User;
import servicer.UserService;
import servicer.impl.UserServiceImpl;
import utils.BaseServlet.BaseServlet;
import utils.MyBeanUtils;
import utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author:cn.wj
 * @date:2020/8/5
 */
@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        System.out.println("findAll");
    }
    public String regist(HttpServletRequest request, HttpServletResponse
            response) throws Exception {
        // 接收表单参数
        Map<String, String[]> map = request.getParameterMap();
        // 封装
        User user = MyBeanUtils.populate(User.class, map);
        // 为用户的其他属性赋值
        user.setUid(UUIDUtils.getId());
        user.setState(0);   //未激活
        user.setCode(UUIDUtils.getCode());
        //System.out.println(user);
        // 调用业务层注册功能
        UserService userService = new UserServiceImpl();
        try {
            userService.regist(user);
            // 注册成功,向用户邮箱发送信息,跳转到提示页面
            // TODO 发送邮件
            request.setAttribute("msg", "用户注册成功,请激活!");
            //注册成功到登录页面
            return "/jsp/login.jsp";
        } catch (Exception e) {
            // 注册失败,跳转到提示页面
            request.setAttribute("msg", "用户注册失败,请重新注册!");
            return "/jsp/info.jsp";
        }
    }
    public String active(HttpServletRequest request, HttpServletResponse
            response) throws Exception {
        //获取激活码
        String code=request.getParameter("code");
        //调用业务层激活功能
        UserService UserService=new UserServiceImpl();
        boolean flag=UserService.activeUser(code);
        //进行激活信息提示
        if(flag){
            //用户激活成功,向request放入提示信息,转发到登录页面
            request.setAttribute("msg", "用户激活成功,请登录!");
            return "/jsp/login.jsp";
        }else{
            //用户激活失败,向request放入提示信息,转发到提示页面
            request.setAttribute("msg", "用户激活失败,请重新激活!");
            return  "/jsp/info.jsp";
        }
    }

    /**
     * 用户登录
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String login(HttpServletRequest request, HttpServletResponse
            response) throws Exception {
        //1.获取用户数据(账户/密码)
        User user = MyBeanUtils.populate(User.class,
                request.getParameterMap());
        //2.调用业务层登录功能
        UserService userService = new UserServiceImpl();
        User loginUser = userService.login(user);
        if (loginUser != null) {
            //3.登录成功
            //select * from user where username=? and password=?
            //用户登录成功,将用户信息放入session中
            request.getSession().setAttribute("loginUser", loginUser);
            //重定向到首页
            response.sendRedirect(request.getContextPath() + "/");
            return null;
        }
        // 4.登录失败
        //向request放入失败的信息
        request.setAttribute("msg", "用户名或密码不匹配或未激活");
        //请求转发到登录页
        return "/jsp/login.jsp";
    }
}
