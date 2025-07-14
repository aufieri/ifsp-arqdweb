package controller;

import dao.DaoJogo;
import model.Jogo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/buscar-jogos")
public class BuscarJogosServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private DaoJogo dao = DaoJogo.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String termo = request.getParameter("query");
        String[] generos = request.getParameterValues("genero");

        ArrayList<Jogo> resultados = dao.buscarPorTituloEGenero(termo, generos);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        response.getWriter().write(gson.toJson(resultados));
    }
}
