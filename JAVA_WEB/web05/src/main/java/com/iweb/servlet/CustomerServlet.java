package com.iweb.servlet;

import com.iweb.beans.Customer;
import com.iweb.service.CustomerService;
import com.iweb.service.impl.CustomerServiceImpl;
import com.iweb.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wj
 * @create 2020-07-30 10:25:42
 */
@WebServlet("/customerServlet")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取请求操作的
        final String op = req.getParameter("op");
        switch (op) {
            case "view":
                //查看
                view(req,resp);
                break;
            case "del":
                del(req,resp);
                break;
            case "batchDel":
                batchDel(req,resp);
                break;
        }
    }

    /**
     * 批量删除
     * @param req
     * @param resp
     */
    private void batchDel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String ids = req.getParameter("ids");
        //01gfffd8486f-76f98-4cb6-a487-a0f9139c6637,01gffffasd8f486f-76f98-4cb6-a487-a0f9139c6637
        //System.out.println(ids);
       int result =  customerService.batchDel(ids);
        if(result > 0) {
            //删除成功.....，删除完成之后 去哪？？？回到index.jsp，
            // 怎么过去？？？？
            req.setAttribute(Constants.CUSTS,customerService.getAll());
            req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
        }
    }

    /**
     * 执行删除
     * @param req
     * @param resp
     */
    private void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");
        int result = customerService.delById(id);
        if(result > 0) {
            //删除成功.....，删除完成之后 去哪？？？回到index.jsp，
            // 怎么过去？？？？
            req.setAttribute(Constants.CUSTS,customerService.getAll());
            req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
        }
    }

    /**
     * 查看当前cust信息、学生信息、课程。。。。。
     * @param req
     * @param resp
     */
    private void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");
        //根据id去调用Service的方法
        Customer customer = customerService.getById(id);

        //将这个customer放到request域中
        req.setAttribute("cust",customer);

        //转发到view.jsp页面
        //todo 思考：若想页面显示view.jsp，怎么搞？？？
        // customerServlet ==>曲线救国，搞一个Aservlet，url-pattern ==> view.jsp
        // 在Aservlet 干这个事情 ：req.setAttribute("cust",customer);

        req.getRequestDispatcher("/WEB-INF/cust/view.jsp").forward(req, resp);
    }
}
