package BaseServlet;

import domain.User;
import service.impi.UserServiceImpi;
import utils.MyBeanUtils;
import utils.UUIDUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author wxh
 * @create 2020-08-05 17:44:15
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
    public void findAll(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("findAll......");
    }

    /**
     * 跳转到注册界面
     */
    public String registUI(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进了registUI");
        return "/jsp/register.jsp";
    }

    /**
     * 用户注册实现
     */
    public String regist(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("执行了regist");
        //接收表单数据
        //封装成一个Map集合，集合中是从前端拿到的User信息，有多少封装多少，没有的是null
        Map<String, String[]> parameterMap = req.getParameterMap();
        //封装
        System.out.println("qdqwdqwdwq"+parameterMap);
        //把上面的Map封装成User对象
        User user = MyBeanUtils.populate(User.class,parameterMap);
        //为用户其他属性赋值
        user.setUid(UUIDUtils.getId());
        user.setState(0);
        user.setCode(UUIDUtils.getCode());

        //调用业务层注册功能
        System.out.println("调用了业务层");
        UserServiceImpi u = new UserServiceImpi();
        try {
            u.regist(user);
            req.setAttribute("msg", "用户注册成功,请激活!");
            //放到域对象中让前端使用
            return "/jsp/login.jsp";
        } catch (SQLException e) {
            req.setAttribute("msg", "用户注册失败,请重新注册!");
            return "/jsp/info.jsp";

        }
    }

    /**
     * 跳转登陆界面
     */
    public String loginUI(HttpServletRequest req, HttpServletResponse resp) {
        return "/jsp/login.jsp";
    }

    /**
     * 登陆功能实现
     */
    public String login(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进了login");
        //获取表单元素封装成MAP
        Map<String, String[]> parameterMap = req.getParameterMap();
        User user = MyBeanUtils.populate(User.class, parameterMap);
        System.out.println("--------------------"+user);
        UserServiceImpi u = new UserServiceImpi();
        try {
            List<User> userList = u.loginService(user);

            if (userList.size() > 0) {
                System.out.println("adasda"+userList.size());
                req.getSession().setAttribute("loginUser",user);
                resp.sendRedirect(req.getContextPath()+"/");
                return null;
            } else {
                req.getSession().setAttribute("noLogin","用户名错误");
                return "/jsp/login.jsp";
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return "/jsp/login.jsp";
    }

    /**
     * 退出功能实现
     * @param req
     * @param resp
     * @return
     */
    public String exit(HttpServletRequest req, HttpServletResponse resp) {
        //退出清除session
        //并且返回到首页
        HttpSession session = req.getSession();
        session.removeAttribute("loginUser");
        return "/index.jsp";
    }
}
