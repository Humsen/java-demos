package pers.husen.demo.shiro.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;

/**
 * @Desc 退出
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午3:43:36
 * 
 * @Version 1.0.0
 */
@WebServlet(name = "logoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SecurityUtils.getSubject().logout();
        req.getRequestDispatcher("/WEB-INF/jsp/logoutSuccess.jsp").forward(req, resp);
    }
}