package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoJogo;
import model.Jogo;

@WebServlet("/AddGame")
@MultipartConfig
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DaoJogo dao = DaoJogo.getInstance();

	public AddGameServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    request.setCharacterEncoding("UTF-8");

	    try {
	        String titulo = request.getParameter("titulo");
	        String dev = request.getParameter("desenvolvedor");
	        String ano = request.getParameter("anoLancamento");
	        String genero = request.getParameter("genero");
	        String sinopse = request.getParameter("sinopse");
	        String idioma = request.getParameter("idioma");
	        String plataforma = request.getParameter("plataforma");
	        String classificacao = request.getParameter("classificacao");
	        String aval = request.getParameter("avaliacao");
	        String precoStr = request.getParameter("preco"); // novo campo preço

	        Part imagemPart = request.getPart("imagem");
	        String nomeImagem = Paths.get(imagemPart.getSubmittedFileName()).getFileName().toString();

	        if (titulo == null || dev == null || ano == null || genero == null || sinopse == null || idioma == null
	                || plataforma == null || classificacao == null || aval == null || precoStr == null
	                || nomeImagem.isEmpty()) {

	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos os campos são obrigatórios.");
	            return;
	        }

	        String caminhoImagem = getServletContext().getRealPath("/imagens");
	        File diretorio = new File(caminhoImagem);
	        if (!diretorio.exists()) {
	            diretorio.mkdir();
	        }
	        imagemPart.write(caminhoImagem + File.separator + nomeImagem);

	        int anoLancamento = Integer.parseInt(ano);
	        double avaliacao = Double.parseDouble(aval);
	        double preco = Double.parseDouble(precoStr); // converte preço

	        // Cria o objeto Jogo usando o construtor com preço
	        Jogo novoJogo = new Jogo(titulo, dev, anoLancamento, genero, sinopse, idioma, plataforma, classificacao,
	                avaliacao, nomeImagem, preco);

	        dao.adicionarJogo(novoJogo);

	        System.out.println("jogos na lista: " + dao.getListaDeJogos().size());
	        response.sendRedirect("listar-jogos");

	    } catch (NumberFormatException e) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ano de lançamento, avaliação ou preço inválido.");
	    } catch (IllegalArgumentException e) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro inesperado no servidor");
	    }
	}
}