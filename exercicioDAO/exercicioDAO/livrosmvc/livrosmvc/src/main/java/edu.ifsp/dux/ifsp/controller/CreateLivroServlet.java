package pe.dux.ifsp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import pe.dux.ifsp.dao.DAOLivro;
import pe.dux.ifsp.model.Livro;

@WebServlet("/criar-livro")
public class CreateLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DAOLivro dao = DAOLivro.getInstance();

	public CreateLivroServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    request.setCharacterEncoding("UTF-8");

	    try {
	        String titulo = request.getParameter("titulo");
	        String autor = request.getParameter("autor");
	        String genero = request.getParameter("genero");
	        String anoStr = request.getParameter("anoPublicacao");

	        if (titulo == null || autor == null || genero == null || anoStr == null) {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos os campos são obrigatórios.");
	            return;
	        }

	        int anoPublicacao = Integer.parseInt(anoStr);

	        Livro novoLivro = new Livro(titulo, autor, genero, anoPublicacao);

	        dao.adicionarLivro(novoLivro);

	        response.sendRedirect("listar-livros");

	    } catch (NumberFormatException e) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ano de publicação inválido.");
	    } catch (IllegalArgumentException e) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro inesperado no servidor.");
	    }
	}
}
