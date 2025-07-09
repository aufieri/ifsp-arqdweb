package dao;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Usuario;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DaoUsuario {
    private static DaoUsuario instance;
    private ArrayList<Usuario> usuarios;

    // Caminho fixo absoluto no PC
    private final String jsonPath = "C:/data/usuarios.json";

    private DaoUsuario() {
        usuarios = carregarUsuariosDoArquivo();
        if (usuarios == null) {
            usuarios = new ArrayList<>();
            System.out.println("[LOG] Nenhum usuário encontrado. Criando nova lista.");
        } else {
            System.out.println("[LOG] Lista de usuários carregada com sucesso. Total: " + usuarios.size());
        }
    }

    public static DaoUsuario getInstance() {
        if (instance == null) {
            instance = new DaoUsuario();
            System.out.println("[LOG] Instância do DaoUsuario criada.");
        }
        return instance;
    }

    private ArrayList<Usuario> carregarUsuariosDoArquivo() {
        try {
            File arquivo = new File(jsonPath);
            System.out.println("[LOG] Caminho do arquivo JSON: " + arquivo.getAbsolutePath());

            if (!arquivo.exists()) {
                System.out.println("[LOG] Arquivo JSON não encontrado. Será criado após o primeiro cadastro.");
                return null;
            }

            try (Reader reader = new FileReader(arquivo, StandardCharsets.UTF_8)) {
                Type tipoLista = new TypeToken<ArrayList<Usuario>>() {}.getType();
                ArrayList<Usuario> lista = new Gson().fromJson(reader, tipoLista);
                System.out.println("[LOG] Arquivo JSON carregado com sucesso.");
                return lista;
            }

        } catch (IOException e) {
            System.out.println("[ERRO] Falha ao carregar JSON: " + e.getMessage());
            return null;
        }
    }

    private void salvarUsuariosNoArquivo() {
        try {
            File arquivo = new File(jsonPath);
            File parentDir = arquivo.getParentFile();
            if (!parentDir.exists()) {
                parentDir.mkdirs(); // cria a pasta se não existir
                System.out.println("[LOG] Pasta criada: " + parentDir.getAbsolutePath());
            }

            try (Writer writer = new FileWriter(jsonPath, StandardCharsets.UTF_8)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(usuarios, writer);
                System.out.println("[LOG] Usuários salvos com sucesso no arquivo JSON.");
            }

        } catch (IOException e) {
            System.out.println("[ERRO] Falha ao salvar JSON: " + e.getMessage());
        }
    }

    public boolean adicionarUsuario(Usuario usuario) {
        usuario.setId(usuarios.size() + 1);
        boolean sucesso = usuarios.add(usuario);
        if (sucesso) {
            System.out.println("[LOG] Usuário adicionado: " + usuario.getEmail());
            salvarUsuariosNoArquivo();
        } else {
            System.out.println("[ERRO] Falha ao adicionar usuário: " + usuario.getEmail());
        }
        return sucesso;
    }

    public Usuario buscarPorEmail(String email) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                System.out.println("[LOG] Usuário encontrado com email: " + email);
                return u;
            }
        }
        System.out.println("[LOG] Nenhum usuário encontrado com email: " + email);
        return null;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
