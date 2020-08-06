package com.iweb.servlet;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wj
 * @create 2020-07-29 11:49:16
 */
@WebServlet("/codeServlet")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100,4,5);
        //todo 把流关闭
        lineCaptcha.write(resp.getOutputStream());
        //Servlet的OutputStream记得自行关闭哦！
    }
}
