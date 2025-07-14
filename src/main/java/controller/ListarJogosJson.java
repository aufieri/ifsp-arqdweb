package controller;

import com.google.gson.Gson;
import dao.DaoJogo;
import model.Jogo;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/api/jogos")
public class ListarJogosJson extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DaoJogo dao = DaoJogo.getInstance();
	private Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Gera JSON com lista de jogos
		ArrayList<Jogo> jogos = dao.getListaDeJogos();
		String json = gson.toJson(jogos);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
}
