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
 * @Desc 权限
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午3:43:55
 * 
 * @Version 1.0.0
 */
@WebServlet(name = "permissionServlet", urlPatterns = "/permission")
public class PermissionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Subject subject = SecurityUtils.getSubject();
		subject.checkPermission("user:create");
		req.getRequestDispatcher("/WEB-INF/jsp/hasPermission.jsp").forward(req, resp);
	}
}