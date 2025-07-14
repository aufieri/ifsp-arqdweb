package controller;

import dao.DaoJogo;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/excluir")
public class DeleteGameServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Verificação se o usuário está logado e é admin
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect(request.getContextPath() + "/erro.html");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null || !"admin".equalsIgnoreCase(usuario.getTipo())) {
            response.sendRedirect(request.getContextPath() + "/erro.html");
            return;
        }

        try {
            // Pega o id do jogo enviado no corpo da requisição (form-urlencoded)
            String idParam = request.getParameter("id");
            if (idParam == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID do jogo não fornecido");
                return;
            }

            int id = Integer.parseInt(idParam);

            // Remover o jogo
            boolean sucesso = DaoJogo.getInstance().removerPorId(id);
            if (sucesso) {
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Jogo não encontrado");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
        }
    }
}
