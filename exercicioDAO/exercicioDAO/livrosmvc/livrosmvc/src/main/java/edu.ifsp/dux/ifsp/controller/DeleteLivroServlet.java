package pe.dux.ifsp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import pe.dux.ifsp.dao.DAOLivro;
import pe.dux.ifsp.model.Livro;

@WebServlet("/excluir-livro")
public class DeleteLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DAOLivro dao = DAOLivro.getInstance();

	public DeleteLivroServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Livro livroParaRemover = null;

			for (Livro l : dao.getListaDeLivros()) {
				if (l.getId() == id) {
					livroParaRemover = l;
					break;
				}
			}

			if (livroParaRemover != null) {
				dao.removerLivro(livroParaRemover);
			}

			response.sendRedirect("listar-livros");

		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
