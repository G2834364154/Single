package web.servlet;

import web.base.BaseServlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IndexServlet")
public class IndexServlet extends BaseServlet {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)  {
		//转发到真实的首页
		return "/jsp/index.jsp";
	}
}
