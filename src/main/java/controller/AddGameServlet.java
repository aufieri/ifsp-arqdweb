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
            // Captura dos parâmetros comuns
            String titulo = request.getParameter("titulo");
            String dev = request.getParameter("desenvolvedor");
            String ano = request.getParameter("anoLancamento");
            String genero = request.getParameter("genero");
            String sinopse = request.getParameter("sinopse");
            String idioma = request.getParameter("idioma");
            String plataforma = request.getParameter("plataforma");
            String classificacao = request.getParameter("classificacao");
            String aval = request.getParameter("avaliacao");
            String precoStr = request.getParameter("preco");

            // Captura dos novos parâmetros booleanos (checkbox)
            String destaqueStr = request.getParameter("destaque");
            String lancamentoStr = request.getParameter("lancamento");
            System.out.println("Jogo cadastrado: " + titulo + ", lançamento? " + lancamentoStr);


            Part imagemPart = request.getPart("imagem");
            String nomeImagem = "";
            if (imagemPart != null && imagemPart.getSize() > 0) {
                nomeImagem = Paths.get(imagemPart.getSubmittedFileName()).getFileName().toString();
            }

            // Verificação simples dos campos obrigatórios
            if (titulo == null || titulo.isEmpty() || dev == null || dev.isEmpty() || ano == null || ano.isEmpty() 
                || genero == null || genero.isEmpty() || sinopse == null || sinopse.isEmpty() || idioma == null || idioma.isEmpty()
                || plataforma == null || plataforma.isEmpty() || classificacao == null || classificacao.isEmpty()
                || aval == null || aval.isEmpty() || precoStr == null || precoStr.isEmpty()
                || nomeImagem.isEmpty()) { // Se imagem for obrigatória
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos os campos são obrigatórios.");
                return;
            }

            // Salvando a imagem na pasta imagens do projeto
            String caminhoImagem = getServletContext().getRealPath("/imagens");
            File diretorio = new File(caminhoImagem);
            if (!diretorio.exists()) {
                diretorio.mkdir();
            }
            imagemPart.write(caminhoImagem + File.separator + nomeImagem);

            // Conversão dos dados numéricos e booleanos
            int anoLancamento = Integer.parseInt(ano);
            double avaliacao = Double.parseDouble(aval);
            double preco = Double.parseDouble(precoStr);

            boolean destaque = "on".equalsIgnoreCase(destaqueStr);
            boolean lancamento = "on".equalsIgnoreCase(lancamentoStr);


            // Criando o objeto Jogo com os novos campos
            Jogo novoJogo = new Jogo(titulo, dev, anoLancamento, genero, sinopse, idioma, plataforma,
                    classificacao, avaliacao, nomeImagem, preco, destaque, lancamento);

            // Adiciona o jogo no DAO
            dao.adicionarJogo(novoJogo);

            // Redireciona para a lista
            response.sendRedirect("listar-jogos");

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ano, avaliação ou preço inválidos.");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro inesperado no servidor.");
        }
    }
}