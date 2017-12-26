package gla.demo.servlet;

import gla.vercode.VerificationCode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 17.6.9 Modified template by Gladiateur
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VerificationCode code = new VerificationCode();
		code.write(request, response);
	}

	/**
	 * 17.6.9 Modified template by Gladiateur
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
