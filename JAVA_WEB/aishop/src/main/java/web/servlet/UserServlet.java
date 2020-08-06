package web.servlet;

import web.base.BaseServlet;

import beans.User;
import servicer.UserService;
import servicer.impl.UserServiceImpl;
import utils.MyBeanUtils;
import utils.UUIDUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {

    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("findAll");
    }

    private UserService userService = new UserServiceImpl();

    /**
     * 跳转到注册页面
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String registUI(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return "/jsp/register.jsp";
    }

    /**
     * 用户注册
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 接收表单参数
        Map<String, String[]> map = request.getParameterMap();
        // 封装
        User user = MyBeanUtils.populate(User.class, map);
        // 为用户的其他属性赋值
        user.setUid(UUIDUtils.getId());
        //未激活 ,此处可以省略，你要修改表结构，将该字段的值默认为0
        user.setState(0);
        //激活码，这个要带到邮件的链接中
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

    /**
     * 用户激活
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String active(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取激活码
        String code = request.getParameter("code");
        //调用业务层激活功能
        UserService UserService = new UserServiceImpl();
        boolean flag = UserService.activeUser(code);

        //进行激活信息提示
        if (flag) {
            //用户激活成功,向request放入提示信息,转发到登录页面
            request.setAttribute("msg", "用户激活成功,请登录!");
            return "/jsp/login.jsp";
        } else {
            //用户激活失败,向request放入提示信息,转发到提示页面
            request.setAttribute("msg", "用户激活失败,请重新激活!");
            return "/jsp/info.jsp";
        }
    }

    /**
     * 跳转到登录页面
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String loginUI(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return "/jsp/login.jsp";
    }

    /**
     * 用户登录
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取用户数据(账户/密码)
        User user = MyBeanUtils.populate(User.class, request.getParameterMap());

        //2.调用业务层登录功能
        User loginUser = userService.login(user);
        if (loginUser != null) {
            //3.登录成功
            //select * from user where username=?  and password=?
            //用户登录成功,将用户信息放入session中
            //todo 最好使用常量....
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

    /**
     * 退出
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1.将session 用户状态清除
        request.getSession().removeAttribute("loginUser");
        // 2.重新定向到首页
        response.sendRedirect(request.getContextPath()+"/index.jsp");
        // 3.不使用BaseServlet的请求转发
        return null;
    }
}
