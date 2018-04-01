package pers.husen.demo.shiro.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Desc 认证
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午3:41:54
 * 
 * @Version 1.0.0
 */
@WebServlet(name = "authenticatedServlet", urlPatterns = "/authenticated")
public class AuthenticatedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			req.getRequestDispatcher("/WEB-INF/jsp/authenticated.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		}
	}
}