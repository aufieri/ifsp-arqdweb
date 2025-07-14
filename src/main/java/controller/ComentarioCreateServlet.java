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
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Sessão não encontrada.");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuário não está logado.");
            return;
        }

        try {
            String texto = request.getParameter("comentarioTexto");
            int nota = Integer.parseInt(request.getParameter("comentarioNota"));
            int idJogo = Integer.parseInt(request.getParameter("idJogo"));

            Comentario comentario = new Comentario();
            comentario.setTexto(texto);
            comentario.setNota(nota);
            comentario.setIdJogo(idJogo);
            comentario.setIdUsuario(usuario.getId());
            comentario.setNomeUsuario(usuario.getNome());

            dao.adicionar(comentario);

            response.sendRedirect("verMais.html?id=" + idJogo);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro ao processar o comentário.");
        }
    }
}
