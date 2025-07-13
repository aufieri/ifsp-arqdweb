package dao;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import model.Comentario;

public class ComentarioDAOJSON {
    private final String filePath = "C:/data/comentarios.json";
    private List<Comentario> comentarios;
    private Gson gson = new Gson();

    public ComentarioDAOJSON() {
        carregar();
    }

    private void carregar() {
        try (Reader reader = new FileReader(filePath)) {
            comentarios = gson.fromJson(reader, new TypeToken<List<Comentario>>(){}.getType());
            if (comentarios == null) comentarios = new ArrayList<>();
        } catch (IOException e) {
            comentarios = new ArrayList<>();
        }
    }

    private void salvar() {
        try {
            File arquivo = new File(filePath);
            File parentDir = arquivo.getParentFile();

            if (!parentDir.exists()) {
                parentDir.mkdirs(); // cria a pasta C:/data se não existir
            }

            try (Writer writer = new FileWriter(arquivo)) {
                gson.toJson(comentarios, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void adicionar(Comentario c) {
        c.setId(gerarId());
        comentarios.add(c);
        salvar();
    }

    public void atualizar(Comentario c) {
        excluir(c.getId());
        comentarios.add(c);
        salvar();
    }

    public void excluir(int id) {
        comentarios.removeIf(c -> c.getId() == id);
        salvar();
    }

    public Comentario buscarPorId(int id) {
        return comentarios.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public List<Comentario> listarPorJogo(int idJogo) {
        return comentarios.stream()
                .filter(c -> c.getIdJogo() == idJogo)
                .collect(Collectors.toList());
    }

    private int gerarId() {
        return comentarios.stream()
                .mapToInt(Comentario::getId)
                .max()
                .orElse(0) + 1;
    }
}
