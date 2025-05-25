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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // para capturar os dados enviados (form multipart/form-data)
        request.setCharacterEncoding("UTF-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            DaoJogo dao = DaoJogo.getInstance();
            Jogo jogo = dao.buscarPorId(id);

            if (jogo == null) {
                response.sendRedirect("listar-jogos");
                return;
            }

            // atualizar campos do jogo
            jogo.setTitulo(request.getParameter("titulo"));
            jogo.setDesenvolvedor(request.getParameter("desenvolvedor"));
            jogo.setAnoLancamento(Integer.parseInt(request.getParameter("anoLancamento")));
            jogo.setGenero(request.getParameter("genero"));
            jogo.setSinopse(request.getParameter("sinopse"));
            jogo.setIdioma(request.getParameter("idioma"));
            jogo.setPlataforma(request.getParameter("plataforma"));
            jogo.setClassificacao(request.getParameter("classificacao"));
            jogo.setAvaliacao(Double.parseDouble(request.getParameter("avaliacao")));

            // tratar upload de imagem (se houver)
            Part filePart = request.getPart("imagem"); // campo do formulário
            if (filePart != null && filePart.getSize() > 0) {
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // extrai nome
                // salvar arquivo na pasta uploads (dentro do contexto)
                String applicationPath = request.getServletContext().getRealPath("");
                String uploadPath = applicationPath + UPLOAD_DIR;
                Path uploadDirPath = Paths.get(uploadPath);
                if (!Files.exists(uploadDirPath)) {
                    Files.createDirectories(uploadDirPath);
                }

                // caminho completo para salvar o arquivo
                Path filePath = uploadDirPath.resolve(fileName);
                try (InputStream input = filePart.getInputStream()) {
                    Files.copy(input, filePath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                }
                // atualizar nome da imagem no objeto
                jogo.setNomeImagem(fileName);
            }

            // não precisa salvar explicitamente pois o objeto já está na lista

            // redirecionar para listagem após atualizar
            response.sendRedirect("listar-jogos");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("UpdateGame?id=" + request.getParameter("id"));
        }
    }
}
