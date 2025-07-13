package controller;

import java.io.IOException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.DaoComentario;
import model.Comentario;
import model.Usuario;

@WebServlet("/criar-comentario")
@MultipartConfig
public class ComentarioCreateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private DaoComentario dao = DaoComentario.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Recupera o usuário logado da sessão
        HttpSession session = request.getSession(false);
        System.out.println("Sessão: " + session);
        System.out.println("Atributo usuario: " + session.getAttribute("usuarioLogado"));
        Usuario usuario = (session != null) ? (Usuario) session.getAttribute("usuarioLogado") : null;
        
        if (usuario == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuário não está logado.");
            return;
        }
        


        try {
            // Recupera os dados do formulário
            String texto = request.getParameter("comentarioTexto");
            int nota = Integer.parseInt(request.getParameter("comentarioNota"));
            int idJogo = Integer.parseInt(request.getParameter("idJogo"));

            // Cria e popula objeto Comentario
            Comentario comentario = new Comentario();
            comentario.setTexto(texto);
            comentario.setNota(nota);
            comentario.setIdJogo(idJogo);
            comentario.setIdUsuario(usuario.getId());

            // Adiciona ao DAO
            dao.adicionar(comentario);

            // Redireciona de volta para a página do jogo
            response.sendRedirect("verMais.html?id=" + idJogo);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro ao processar o comentário.");
        }
    }
}
