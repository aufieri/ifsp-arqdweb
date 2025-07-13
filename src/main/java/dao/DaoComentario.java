package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Comentario;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DaoComentario {

    private static DaoComentario instance;
    private final String jsonPath = "C:/data/comentarios.json";
    private ArrayList<Comentario> comentarios;

    private DaoComentario() {
        this.comentarios = carregarDoArquivo();
        if (this.comentarios == null) {
            this.comentarios = new ArrayList<>();
        }
    }

    public static DaoComentario getInstance() {
        if (instance == null) {
            instance = new DaoComentario();
        }
        return instance;
    }

    private ArrayList<Comentario> carregarDoArquivo() {
        try (Reader reader = new FileReader(jsonPath)) {
            Gson gson = new Gson();
            Type tipoLista = new TypeToken<ArrayList<Comentario>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            return null;
        }
    }

    private void salvarNoArquivo() {
        try {
            File arquivo = new File(jsonPath);
            File pasta = arquivo.getParentFile();
            if (!pasta.exists()) {
                pasta.mkdirs();
            }

            try (Writer writer = new FileWriter(jsonPath)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(comentarios, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionar(Comentario comentario) {
        comentario.setIdComentario(gerarProximoId());
        comentarios.add(comentario);
        salvarNoArquivo();
    }

    private int gerarProximoId() {
        int maior = 0;
        for (Comentario c : comentarios) {
            if (c.getIdComentario() > maior) {
                maior = c.getIdComentario();
            }
        }
        return maior + 1;
    }

    public ArrayList<Comentario> listarTodos() {
        return comentarios;
    }

    public ArrayList<Comentario> listarPorIdJogo(int idJogo) {
        ArrayList<Comentario> resultado = new ArrayList<>();
        for (Comentario c : comentarios) {
            if (c.getIdJogo() == idJogo) {
                resultado.add(c);
            }
        }
        return resultado;
    }
}
