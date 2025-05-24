package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.DaoJogo;
import model.Jogo;

@WebServlet("/AddGameServlet")
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DaoJogo dao = DaoJogo.getInstance();
    
    public AddGameServlet() {
        super();
    }
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
    			
		request.setCharacterEncoding("UTF-8");
		
		try {
			String titulo = request.getParameter("titulo");
			String anoStr = request.getParameter("anoLancamento");
			String genero = request.getParameter("genero");
			String sinopse = request.getParameter("sinopse");
			int ano = Integer.parseInt(anoStr);
			
			System.out.println("Titulo: " + request.getParameter("titulo"));
			System.out.println("Ano: " + request.getParameter("anoLancamento"));
			System.out.println("Genero: " + request.getParameter("genero"));
			System.out.println("Sinopse: " + request.getParameter("sinopse"));

			
			if (titulo == null || titulo.isEmpty() ||
				    anoStr == null || anoStr.isEmpty() ||
				    genero == null || genero.isEmpty() ||
				    sinopse == null || sinopse.isEmpty()) {
				
				 response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos os campos sao obrigatórios.");
				    return;
			}
			
			
			
			Jogo novoJogo = new Jogo (titulo, "", ano, genero, sinopse, "", "", "", 0.0);
			dao.adicionarJogo(novoJogo);
			
			response.sendRedirect("index.jsp");
			
			
		} catch (NumberFormatException e) {
		    request.setAttribute("erro", "Ano de lançamento inválido.");
		    request.getRequestDispatcher("adicionarJogo.jsp").forward(request, response);
		} catch (Exception e) {
		    e.printStackTrace();
		    request.setAttribute("erro", "Erro inesperado no servidor.");
		    request.getRequestDispatcher("adicionarJogo.jsp").forward(request, response);
		}
		


		
	}

}
