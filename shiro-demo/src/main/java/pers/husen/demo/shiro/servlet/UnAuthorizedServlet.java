package pers.husen.demo.shiro.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Desc 未认证
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午3:44:47
 * 
 * @Version 1.0.0
 */
@WebServlet(name = "unauthorizedServlet", urlPatterns = "/unauthorized")
public class UnAuthorizedServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/unauthorized.jsp").forward(req, resp);
	}
}