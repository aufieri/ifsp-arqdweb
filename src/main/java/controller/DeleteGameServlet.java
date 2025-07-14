package controller;

import dao.DaoJogo;

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

        // Verifica sessão e usuário logado
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuarioLogado") == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuário não autenticado");
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
