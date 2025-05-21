package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoJogo;


@WebServlet("/listar-jogos")
public class ViewGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DaoJogo dao = DaoJogo.getInstance();

    public ViewGameServlet() {
        super();       
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.setCharacterEncoding("UTF-8");
			
			getServletContext().setAttribute("jogos", dao.getListaDeJogos());
			if (dao.getListaDeJogos().size() > 10) {
				System.out.println(dao.getListaDeJogos().get(0).getTitulo());
			}
			System.out.println(request.getAttribute("jogos"));
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
