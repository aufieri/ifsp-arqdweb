package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String username = request.getParameter ("username");
			String senha = request.getParameter("senha");
			
			if ("aufieri".equals(username) && "1234".equals(senha)) {
				HttpSession session = request.getSession();
	            session.setAttribute("usuario", username);
	            response.sendRedirect("dashboard.jsp"); // 
	        } else {
	            request.setAttribute("erroLogin", "Email ou senha inválidos.");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	}

}
