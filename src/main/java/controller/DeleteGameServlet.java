package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoJogo;
import model.Jogo;


@WebServlet("/DeleteGame")
public class DeleteGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DaoJogo dao = DaoJogo.getInstance();
       

    public DeleteGameServlet() {
        super();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Jogo jogoParaRemover = null;
			
			for (Jogo jogo1 : dao.getListaDeJogos()) {
				if (jogo1.getId() == id) {
					jogoParaRemover = jogo1;
					break;
				}
			}
			
			if (jogoParaRemover != null) {
				dao.removerJogo(jogoParaRemover);
			}
			
			response.sendRedirect("listar-jogos");
			
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID Inválido");
		}
		

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
