package controller;

import dao.DaoJogo;
import model.Jogo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/buscar-jogos")
public class BuscarJogosServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private DaoJogo dao = DaoJogo.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String termo = request.getParameter("query");

        ArrayList<Jogo> resultados = dao.buscarPorTitulo(termo);

        request.setAttribute("resultados", resultados);
        request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
    }
}
