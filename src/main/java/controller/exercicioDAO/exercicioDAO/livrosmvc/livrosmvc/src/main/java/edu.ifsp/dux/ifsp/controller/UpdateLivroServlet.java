package pe.dux.ifsp.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import pe.dux.ifsp.dao.DAOLivro;
import pe.dux.ifsp.model.Livro;

@WebServlet("/editar-livro")
public class UpdateLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DAOLivro dao = DAOLivro.getInstance();

	public UpdateLivroServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<String> generos = Arrays.asList("Ficção", "Não Ficção", "Fantasia", "Romance");
		request.setAttribute("generos", generos);

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Livro livroEncontrado = null;

			for (Livro l : dao.getListaDeLivros()) {
				if (l.getId() == id) {
					livroEncontrado = l;
					break;
				}
			}

			if (livroEncontrado == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "Livro não encontrado.");
				return;
			}

			getServletContext().setAttribute("livro", livroEncontrado);
			request.getRequestDispatcher("change.jsp").forward(request, response);

		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");
			String genero = request.getParameter("genero");
			int ano = Integer.parseInt(request.getParameter("anoPublicacao"));

			// Procura o livro pelo ID
			for (Livro l : dao.getListaDeLivros()) {
				if (l.getId() == id) {
					l.setTitulo(titulo);
					l.setAutor(autor);
					l.setGenero(genero);
					l.setAnoPublicacao(ano);
					break;
				}
			}

			response.sendRedirect("listar-livros");

		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro ao atualizar livro: " + e.getMessage());
		}
	}
}
