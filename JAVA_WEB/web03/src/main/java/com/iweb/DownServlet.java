package com.iweb;

import cn.hutool.core.io.IoUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author:cn.wj
 * @date:2020/8/4
 */
@WebServlet(name = "DownServlet")
public class DownServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 需要设置2头1流
        //获取文件名
        String filename = request.getParameter("filename");
        //获取ServletContext对象
        ServletContext sc = getServletContext();
        //通过对象的getMimeType方法获取mime类型
         String mimeType = sc.getMimeType("/file/" + filename);
        //1.设置文件的mime类型头
        response.setHeader("content-type",mimeType);
        //2.获取浏览器的版本内核
        String agent = request.getHeader("user-agent");
        System.out.println(agent);
        //设置文件下载头
        response.setHeader("content-disposition", "attachment;filename="+filename);
        //设置流
        //获取输入流
        InputStream is = sc.getResourceAsStream("/file/"+filename);
        //获取输出流
        ServletOutputStream os = response.getOutputStream();
        IoUtil.copy(is,os);
        //关闭流
        os.close();
        is.close();

        //两流互拷
        /*byte[] buf = new byte[1024];
        int len = 0;
        while((len=is.read(buf))!=-1){
            os.write(buf, 0, len);
        }*/


    }
}
