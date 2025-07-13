package controller;

import dao.DaoUsuario;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		System.out.println("[LOGIN SERVLET] Tentativa de login: " + email);

		DaoUsuario dao = DaoUsuario.getInstance();
		Usuario usuario = dao.buscarPorEmail(email);

		if (usuario != null && usuario.getSenha().equals(senha)) {
			System.out.println("[LOGIN SERVLET] Login OK para: " + email);

			HttpSession session = request.getSession();
			System.out.println("Usuário logado: " + usuario);
			session.setAttribute("usuarioLogado", usuario);

			switch (usuario.getTipo()) {
				case "admin":
					response.sendRedirect("CRUD.html");
					break;
				case "avaliador":
					response.sendRedirect("index.html");
					break;
			}

		} else {
			System.out.println("[LOGIN SERVLET] Falha no login para: " + email);
			response.sendRedirect("login.html?erro=1");
		}
	}
}
