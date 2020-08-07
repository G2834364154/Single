package filter;

import beans.User;
import servicer.UserService;
import servicer.impl.UserServiceImpl;
import utils.CookUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:cn.wj
 * @date:2020/8/7
 */
public class AutoLoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        // 如果是登录页直接放行
        String servletPath = req.getServletPath();
        if(servletPath.startsWith("/userServlet")) {
            String method = req.getParameter("method");
            if("loginUI".equals(method)) {
                chain.doFilter(req, res);
                return;
            }
        }

        //1.获取session,看session是否有值
        User loginUser = (User) req.getSession().getAttribute("loginUser");
        //2.if没有处于登录状态，需要获取cookie
        if (loginUser != null) {
            chain.doFilter(req, res);
            return;
        }
        // 3.获得 自动登录cookie信息
        Cookie cookie = CookUtils.getCookieByName("autoLogin", req.getCookies());
        if (cookie == null) {
            chain.doFilter(req, res);
            return;
        }

        // 5.通过用户cookie中记录信息，查询用户
        // 5.1 获得用户信息
        String[] u = cookie.getValue().split("#");
        String userName = u[0];
        String pwd = u[1];

        User user = new User();
        user.setUsername(userName);
        user.setPassword(pwd);

        try {
            // 5.2 执行登录
            UserService userService = new UserServiceImpl();
            loginUser = userService.login(user);
            // 6.如果没有查询到（说明密码被修改了）
            if (loginUser == null) {
                chain.doFilter(req, res);
                return;
            }

            // 7.自动登录
            req.getSession().setAttribute("loginUser", loginUser);

            //放行
            chain.doFilter(req, res);
        } catch (Exception e) {
            System.out.println("自动登录异常，自动忽略....");
            e.printStackTrace();
        }
    }
}
