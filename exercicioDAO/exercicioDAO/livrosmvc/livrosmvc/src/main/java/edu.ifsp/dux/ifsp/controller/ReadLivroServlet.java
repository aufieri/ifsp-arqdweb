package pe.dux.ifsp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import pe.dux.ifsp.dao.DAOLivro;

@WebServlet("/listar-livros")
public class ReadLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DAOLivro dao = DAOLivro.getInstance();

	public ReadLivroServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		// Recupera lista de livros
		getServletContext().setAttribute("livros", dao.getListaDeLivros());
		if (dao.getListaDeLivros().size() > 0) {
			System.out.println(dao.getListaDeLivros().get(0).getTitulo());
		}
		System.out.println(request.getAttribute("livros"));

		// Encaminha para a página JSP index.jsp (na pasta raiz ou /WEB-INF/views/)
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
