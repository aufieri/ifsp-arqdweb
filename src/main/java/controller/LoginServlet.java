package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Usuario;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String username = request.getParameter("username");
	    String senha = request.getParameter("senha");

	    Usuario usuarioValido = new Usuario();
	    usuarioValido.setUserName("admin");
	    usuarioValido.setSenha("123");

	    if (usuarioValido.getUserName().equals(username) && usuarioValido.getSenha().equals(senha)) {
	        HttpSession session = request.getSession();
	        session.setAttribute("usuarioLogado", usuarioValido);
	        response.sendRedirect("CRUD.jsp");
	    } else {
	        request.setAttribute("loginErro", true);
	        request.setAttribute("username", username); 
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	}
}
