package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoJogo;
import model.Jogo;

@WebServlet("/UpdateGame")
public class UpdateGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DaoJogo dao = DaoJogo.getInstance();
       
    public UpdateGameServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	List<String> generos = Arrays.asList("Ação", "Aventura", "Esporte");
    	request.setAttribute("generos", generos);
    	
    	try {
    		int id = Integer.parseInt(request.getParameter("id"));
    		Jogo jogoEncontrado = null;
    		
    		for (Jogo jogo1 : dao.getListaDeJogos()) {
    			if (jogo1.getId() == id) {
    				jogoEncontrado = jogo1;
    				break;
    			}
    		}
    		if (jogoEncontrado == null) {
    			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Jogo nao encontrado");
    			return;
    		}
    		
    		request.setAttribute("jogo", jogoEncontrado);
    		request.getRequestDispatcher("change.jsp").forward(request, response);
    		
    	}catch (NumberFormatException e) {
    		response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID Invalido");
    	}
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    		request.setCharacterEncoding("UTF-8");
    		
    		try {
    			int id = Integer.parseInt(request.getParameter("id"));
    			String titulo = request.getParameter("titulo");
    			String desenvolvedor = request.getParameter("desenvolvedor");
    			int anoLancamento = Integer.parseInt(request.getParameter("anoLancamento"));
    			String genero = request.getParameter("genero");
    			String sinopse = request.getParameter("sinopse");
    			String idioma = request.getParameter("idioma");
    			String plataforma = request.getParameter("plataforma");
    			String classificacao = request.getParameter("classificacao");
    			Double avaliacao = Double.parseDouble(request.getParameter("avaliacao"));
    			
    			for (Jogo jogo1 : dao.getListaDeJogos()) {
    				if (jogo1.getId() == id) {
    					jogo1.setTitulo(titulo);
    					jogo1.setDesenvolvedor(desenvolvedor);
    					jogo1.setAnoLancamento(anoLancamento);
    					jogo1.setGenero(genero);
    					jogo1.setSinopse(sinopse);
    					jogo1.setIdioma(idioma);
    					jogo1.setPlataforma(plataforma);
    					jogo1.setClassificacao(classificacao);
    					jogo1.setAvaliacao(avaliacao);
    					break;
    					
    				}
    			}
    			
    			response.sendRedirect("listar-jogos");
    			
    		}catch (Exception e) {
    			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro ao atualizar os jogos");
    		}
		
	}

}
