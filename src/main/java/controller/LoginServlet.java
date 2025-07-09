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
		// 1. Recebe os dados do formulário
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		System.out.println("[LOGIN SERVLET] Tentativa de login: " + email);

		DaoUsuario dao = DaoUsuario.getInstance();

		Usuario usuario = dao.buscarPorEmail(email);

		if (usuario != null && usuario.getSenha().equals(senha)) {
			// Login OK
			System.out.println("[LOGIN SERVLET] Login OK para: " + email);

			// Cria sessão e guarda usuário
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);

			// Verifica se é admin
			if (usuario.getEmail().equalsIgnoreCase("admin@examplo.com")) {
				response.sendRedirect("CRUD.html");
			} else {
				response.sendRedirect("index.html");
			}

		} else {
			// Login falhou
			System.out.println("[LOGIN SERVLET] Falha no login para: " + email);

			// Redireciona de volta para a página de login com parâmetro de erro
			response.sendRedirect("login.html?erro=1");
		}
	}
}
