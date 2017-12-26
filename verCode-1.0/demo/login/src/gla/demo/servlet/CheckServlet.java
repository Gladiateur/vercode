package gla.demo.servlet;

import gla.vercode.VerificationCode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 17.6.9 Modified template by Gladiateur
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		String vercode = (String) session.getAttribute("vercode");
		if(VerificationCode.check(request.getParameter("code"), vercode)){
			request.setAttribute("msg", "验证码正确");
		}else{
			request.setAttribute("msg", "验证码错误");
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	/**
	 * 17.6.9 Modified template by Gladiateur
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
