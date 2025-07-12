package controller;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/api/usuario-logado")
public class UsuarioLogadoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false); // não cria nova sessão
        Usuario usuario = (session != null) ? (Usuario) session.getAttribute("usuarioLogado") : null;

        if (usuario != null) {
            response.getWriter().write("{\"nome\": \"" + usuario.getNome() + "\"}");
        } else {
            response.getWriter().write("{\"nome\": null}");
        }
    }
}
