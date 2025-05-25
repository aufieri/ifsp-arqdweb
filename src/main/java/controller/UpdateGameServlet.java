package controller;

import dao.DaoJogo;
import model.Jogo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/UpdateGame")
@javax.servlet.annotation.MultipartConfig // para receber arquivos
public class UpdateGameServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "uploads"; // pasta para salvar imagens

    // GET para carregar o formulário de edição com os dados do jogo
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
        String idParam = request.getParameter("id");
        if (idParam == null) {
            response.sendRedirect("listar-jogos");
            return;
        }

        try {
            int id = Integer.parseInt(idParam);
            DaoJogo dao = DaoJogo.getInstance();
            Jogo jogo = dao.buscarPorId(id);

            if (jogo == null) {
                response.sendRedirect("listar-jogos");
                return;
            }

            // Coloca o jogo como atributo para ser usado no JSP
            request.setAttribute("jogo", jogo);
            // Encaminha para a página JSP de edição
            request.getRequestDispatcher("editar.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendRedirect("listar-jogos");
        }
    }

    // POST para atualizar os dados do jogo
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            DaoJogo dao = DaoJogo.getInstance();
            Jogo jogo = dao.buscarPorId(id);

            if (jogo == null) {
                response.sendRedirect("listar-jogos");
                return;
            }

            // Atualizar os campos do jogo
            jogo.setTitulo(request.getParameter("titulo"));
            jogo.setDesenvolvedor(request.getParameter("desenvolvedor"));
            jogo.setAnoLancamento(Integer.parseInt(request.getParameter("anoLancamento")));
            jogo.setGenero(request.getParameter("genero"));
            jogo.setSinopse(request.getParameter("sinopse"));
            jogo.setIdioma(request.getParameter("idioma"));
            jogo.setPlataforma(request.getParameter("plataforma"));
            jogo.setClassificacao(request.getParameter("classificacao"));
            jogo.setAvaliacao(Double.parseDouble(request.getParameter("avaliacao")));

            // Tratar upload de imagem (se houver)
            Part filePart = request.getPart("imagem");
            if (filePart != null && filePart.getSize() > 0) {
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                String applicationPath = request.getServletContext().getRealPath("");
                String uploadPath = applicationPath + UPLOAD_DIR;
                Path uploadDirPath = Paths.get(uploadPath);

                if (!Files.exists(uploadDirPath)) {
                    Files.createDirectories(uploadDirPath);
                }

                Path filePath = uploadDirPath.resolve(fileName);
                try (InputStream input = filePart.getInputStream()) {
                    Files.copy(input, filePath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                }

                jogo.setNomeImagem(fileName);
            }

            // Redireciona para a lista após atualizar
            response.sendRedirect("listar-jogos");

        } catch (Exception e) {
            e.printStackTrace();
            // Caso erro, volta para a página de edição com o id
            response.sendRedirect("UpdateGame?id=" + request.getParameter("id"));
        }
    }
}
