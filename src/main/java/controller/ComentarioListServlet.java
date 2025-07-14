package controller;

import dao.DaoComentario;
import model.Comentario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/api/comentarios")
public class ComentarioListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DaoComentario dao = DaoComentario.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String idJogoParam = request.getParameter("idJogo");
        if (idJogoParam == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parâmetro idJogo é obrigatório.");
            return;
        }

        int idJogo;
        try {
            idJogo = Integer.parseInt(idJogoParam);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "idJogo inválido.");
            return;
        }

        ArrayList<Comentario> comentarios = dao.listarPorIdJogo(idJogo);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String json = new com.google.gson.Gson().toJson(comentarios);
        response.getWriter().write(json);
    }
}
