package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.DaoJogo;

@WebServlet("/excluir")
public class DeleteGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Verifica se o usuário está logado
		HttpSession session = request.getSession(false); // false evita criar uma nova sessão se não existir

		if (session == null || session.getAttribute("usuarioLogado") == null) {
			// Redireciona para uma página de erro ou login
			response.sendRedirect("erro.jsp"); // ou "login.jsp"
			return;
		}

		// Executa a exclusão se estiver logado
		int id = Integer.parseInt(request.getParameter("id"));
		DaoJogo.getInstance().removerPorId(id);

		response.sendRedirect("listar-jogos");
	}
}
