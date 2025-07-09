package controller;

import dao.DaoUsuario;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/CadastroUsuarioServlet")
public class CadastroUsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Pega os dados do formulário
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        System.out.println("[SERVLET] Recebido cadastro: " + nome + " | " + email);

        // 2. Usa o DAO normalmente (sem passar caminho, pois já é fixo no DaoUsuario)
        DaoUsuario dao = DaoUsuario.getInstance();

        // 3. Verificação se e-mail já existe
        if (dao.buscarPorEmail(email) != null) {
            System.out.println("[SERVLET] Email já cadastrado: " + email);
            response.sendRedirect("cadastro.html?erro=email");
            return;
        }

        // 4. Criação do usuário
        Usuario novoUsuario = new Usuario(0, nome, email, senha, "avaliador");
        boolean sucesso = dao.adicionarUsuario(novoUsuario);

        // 5. Redirecionamento final
        if (sucesso) {
            System.out.println("[SERVLET] Usuário cadastrado com sucesso: " + email);
            response.sendRedirect("login.html");
        } else {
            System.out.println("[SERVLET] Falha ao cadastrar o usuário: " + email);
            response.sendRedirect("cadastro.html?erro=cadastro");
        }
    }
}
