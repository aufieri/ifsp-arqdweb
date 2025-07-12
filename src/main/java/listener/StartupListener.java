package listener;

import dao.DaoJogo;
import dao.DaoUsuario;
import model.Usuario;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[LISTENER] Aplicação iniciando...");

        DaoUsuario dao = DaoUsuario.getInstance();

        if (dao.getUsuarios().isEmpty()) {
            System.out.println("[LISTENER] Nenhum usuário encontrado, criando usuário admin.");

            Usuario admin = new Usuario(0, "admin", "admin@exemplo.com", "123", "admin");
            dao.adicionarUsuario(admin);

            System.out.println("[LISTENER] Usuário admin criado com sucesso.");
        } else {
            System.out.println("[LISTENER] Usuários já existem, não cria admin.");
        }
    
    
    	DaoJogo daoJogo = DaoJogo.getInstance();
    	if (daoJogo.getListaDeJogos() == null || daoJogo.getListaDeJogos().isEmpty()) {
        System.out.println("[LISTENER] Nenhum jogo encontrado, criando jogos padrão.");

        System.out.println("[LISTENER] Jogos carregados com sucesso.");
    	} else {
        System.out.println("[LISTENER] Jogos já existem no sistema.");
    	}
}

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[LISTENER] Aplicação finalizando...");
    }
}
